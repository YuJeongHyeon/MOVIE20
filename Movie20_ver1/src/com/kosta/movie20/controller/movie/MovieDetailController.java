package com.kosta.movie20.controller.movie;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.common.PagingBean;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.MovieVO;
import com.kosta.movie20.model.vo.ReviewVO;

public class MovieDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mNo = request.getParameter("mNo");
		if(request.getSession(false)!=null) {
			MovieDAO.getInstance().movieHitsup(mNo);
		}
		MovieVO mvo =MovieDAO.getInstance().movieDetail(mNo);
		int totalPostCount=MovieDAO.getInstance().getReviewListcount();
		int nowPage=1;
		String lp=request.getParameter("listpage");
		
		if(lp!=null) {
			nowPage=Integer.parseInt(lp);			
		}
		
		PagingBean pb=new PagingBean(totalPostCount, nowPage);

		
		ArrayList<ReviewVO> rlist =MovieDAO.getInstance().movieReviewList(mNo,pb);
		request.setAttribute("rlist", rlist);//보여줄 리뷰리스트
		request.setAttribute("mvo", mvo);//영화정보
		
		String url = "movie/movieDetailResult.jsp";
		request.setAttribute("url", url);
		return "layout/home.jsp";
		
	}

}
