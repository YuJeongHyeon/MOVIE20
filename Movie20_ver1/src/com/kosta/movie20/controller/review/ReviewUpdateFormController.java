package com.kosta.movie20.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.ReviewVO;

public class ReviewUpdateFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("membervo")==null){
			return "redirect:index.jsp";
		}
		String rNo=request.getParameter("rno");
		
		
		ReviewVO rvo=MovieDAO.getInstance().getMovieReviewDetail(rNo);		
		request.setAttribute("rvo", rvo);
		
		String url = "../movie/reviewupdateform.jsp";
		request.setAttribute("url", url);
		return "layout/home.jsp";
	}

}
