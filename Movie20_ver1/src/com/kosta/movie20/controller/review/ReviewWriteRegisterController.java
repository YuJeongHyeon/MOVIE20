package com.kosta.movie20.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.ReviewVO;

public class ReviewWriteRegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String mno=request.getParameter("mno");
		ReviewVO rvo=new ReviewVO( title, content, mno, id);
		
		MovieDAO.getInstance().reviewWrite(rvo);		

		String url = "movie/movieDetailResult.jsp";
		request.setAttribute("url", url);
		return "layout/home.jsp";
	}

}
