package com.kosta.movie20.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MovieDAO;

public class ReviewDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String rNo=request.getParameter("rno");
		MovieDAO.getInstance().reviewDelete(rNo);
		
		String url = "movie/movieDetailResult.jsp";
		request.setAttribute("url", url);
		return "layout/home.jsp";
	}

}
