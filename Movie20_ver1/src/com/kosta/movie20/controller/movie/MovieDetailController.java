package com.kosta.movie20.controller.movie;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.common.PagingBean;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.MovieVO;
import com.kosta.movie20.model.vo.ReviewListVO;
import com.kosta.movie20.model.vo.ReviewVO;

public class MovieDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String movieNo = request.getParameter("movieNo");
		if(request.getSession(false)!=null) {
			MovieDAO.getInstance().movieHitsup(movieNo);
		}
		MovieVO movievo =MovieDAO.getInstance().movieDetail(movieNo);
		
		int totalPostCount=MovieDAO.getInstance().getReviewListcount();
		String pno=request.getParameter("pageNo");
		
		PagingBean pb=null;
		if(pno==null){
			pb=new PagingBean(totalPostCount);
		}else{
			pb=new PagingBean(totalPostCount,Integer.parseInt(pno));
		}

		
		ArrayList<ReviewVO> rlist =MovieDAO.getInstance().movieReviewList(movieNo,pb);
		ReviewListVO listVO=new ReviewListVO(rlist,pb);
		request.setAttribute("listVO", listVO);//보여줄 리뷰리스트		
		request.setAttribute("movievo", movievo);//영화정보
		
		String url = "../movie/movieDetailResult.jsp";
		request.setAttribute("url", url);
		return "layout/home.jsp";
		
	}

}
