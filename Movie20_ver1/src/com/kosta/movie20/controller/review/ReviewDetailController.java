package com.kosta.movie20.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.ReviewVO;

public class ReviewDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String rNo=request.getParameter("rno");
		if(request.getSession(false)!=null) {
			MovieDAO.getInstance().reviewHitsup(rNo);
		}
		ReviewVO rvo=MovieDAO.getInstance().movieReviewDetail(rNo);
		request.setAttribute("rvo", rvo);

		String url = "../movie/reviewDetail.jsp";
		request.setAttribute("url", url);
		return "layout/home.jsp";
	}

}
