package com.kosta.movie20.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.controller.handler.HandlerMapping;


/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		requestProcess(request, response);
	}
	/**
	 * client의 command를 반환받는다
	 * HandlerMapping을 이용해 컨트롤러 구현체를 반환받는다 
	 * 컨트롤러 구현체의 표준화된 메서드를 실행한 후 
	 * 반환되는 url 정보를 받는다. 
	 * 컨트롤러 구현체가 명시한 이동방식과 url 에 의거해 
	 * View로 이동한다 ( redirect or forward ) 
	 * 컨트롤러 구현체가 실행되는 도중에 발생되는 모든 Exception에
	 * 대해 error.jsp로 redirect 하도록 처리한다. 
	 */  
	public void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//파일업로드 요청인지 확인해야 한다 
			// enctype="multipart/form-data"
			String command=null;
			//파일업로드 요청이면 
			if(request.getContentType() != null && 
				    request.getContentType().toLowerCase().indexOf("multipart/form-data") > -1) {				
				command="Upload";
				System.out.println("파일업로드요청 "+command);
			}else {//일반요청이면 
				command=request.getParameter("command");
		    }
			Controller c=HandlerMapping.getInstance().create(command);
			String url=c.execute(request, response);			
			if(url.startsWith("redirect:"))
				response.sendRedirect(url.substring(9));
			else
				request.getRequestDispatcher(url).forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}			
	}	

}
