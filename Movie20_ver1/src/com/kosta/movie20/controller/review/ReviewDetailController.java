package com.kosta.movie20.controller.review;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.ReviewVO;
import com.kosta.movie20.second.comment.CommentDAO;
import com.kosta.movie20.second.comment.CommentVO;

public class ReviewDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String rNo=request.getParameter("rno");
		if(request.getSession(false)!=null) {
			MovieDAO.getInstance().reviewHitsup(rNo);
		}
		ReviewVO rvo=MovieDAO.getInstance().movieReviewDetail(rNo);
		request.setAttribute("rvo", rvo);
		
		ArrayList<CommentVO> clist=CommentDAO.getInstance().commentList(rNo);
		
		request.setAttribute("clist", clist);
	
		
		String url = "../movie/reviewDetail.jsp";
		request.setAttribute("url", url);
		return "layout/home.jsp";
	}

}
