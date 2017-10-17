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
		
		MovieDAO.getInstance().reviewDelete(rNo);
		
		String movieno=request.getParameter("movieno");
		System.out.println(movieno);
		request.setAttribute("movieNo", movieno);
		String url = "DispatcherServlet?command=MovieDetail&movieNo="+movieno;
		//request.setAttribute("url", url);
		return url;
	}

}
