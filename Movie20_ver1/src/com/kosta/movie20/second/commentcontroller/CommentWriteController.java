package com.kosta.movie20.second.commentcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.second.comment.CommentDAO;
import com.kosta.movie20.second.comment.CommentVO;

public class CommentWriteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("membervo")==null){
			return "redirect:index.jsp";
		}
		String id=request.getParameter("id");
		
		String rno=request.getParameter("rno");
	
		String  content=request.getParameter("content");
		
		CommentVO cvo=new CommentVO(content,id,rno);
		CommentDAO.getInstance().commentWrite(cvo);;
		
		
		String mno = request.getParameter("mno");
		request.setAttribute("rno", rno);
		
		request.setAttribute("mno", mno);
		
		String url = "DispatcherServlet?command=reviewDetail&rno="+rno+"&movieno="+mno;
		return url;
	}

}
