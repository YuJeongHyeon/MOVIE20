package com.kosta.movie20.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.ReviewVO;

public class ReviewUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
	
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String rno=request.getParameter("rno");
		ReviewVO rvo=new ReviewVO( title, content, rno);
		
		MovieDAO.getInstance().reviewUpdate(rvo);
		
		String url = "movie/movieDetailResult.jsp";
		request.setAttribute("url", url);
		return "layout/home.jsp";
	}

}
