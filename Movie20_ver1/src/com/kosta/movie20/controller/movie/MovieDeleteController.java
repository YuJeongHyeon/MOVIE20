package com.kosta.movie20.controller.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;

public class MovieDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("memvervo")==null||request.getMethod().equals("POST")==false){
			return "redirect:index.jsp";
		}*/
		String mNo=request.getParameter("mNo");
		System.out.println("배승찬 영화 삭제 컨트롤러: "+mNo);
		MasterDAO.getInstance().movieDelete(mNo);

		return "redirect:DispatcherServlet?command=cmdMainList";
		
	}

}
