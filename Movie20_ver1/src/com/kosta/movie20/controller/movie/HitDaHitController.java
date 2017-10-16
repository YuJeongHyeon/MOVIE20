package com.kosta.movie20.controller.movie;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.common.MoviePagingBean;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.MainListVO;
import com.kosta.movie20.model.vo.MovieVO;

public class HitDaHitController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int totalPageCount = MovieDAO.getInstance().getTotalPostCount();
		String pno=request.getParameter("pageNo");
		MoviePagingBean MoviePagingBean=null;
		if(pno==null){
			MoviePagingBean = new MoviePagingBean(totalPageCount);
		}else{
			MoviePagingBean = new MoviePagingBean(totalPageCount, Integer.parseInt(pno));
		}
		
		ArrayList<MovieVO> mList = MovieDAO.getInstance().hitDaHit(MoviePagingBean);
		MainListVO<MovieVO> lvo = new MainListVO<MovieVO>(mList, MoviePagingBean);
		request.setAttribute("lvo", lvo);
		request.setAttribute("url", "/movie/hitDaHitResult.jsp");
		
		return "/layout/home.jsp";
	}
}
