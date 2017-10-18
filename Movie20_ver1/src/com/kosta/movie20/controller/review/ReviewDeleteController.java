package com.kosta.movie20.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.second.comment.CommentDAO;

public class ReviewDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("membervo")==null){
			return "redirect:index.jsp";
		}
		String rNo=request.getParameter("rno");
		MovieDAO.getInstance().reviewDelete(rNo);
		
		CommentDAO.getInstance().commentDelete(rNo);
		
		String movieno=request.getParameter("movieno");
		
		request.setAttribute("movieNo", movieno);
		String url = "DispatcherServlet?command=MovieDetail&movieNo="+movieno;
		return url;
	}

}
