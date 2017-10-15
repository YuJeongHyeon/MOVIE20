package com.kosta.movie20.controller.movie;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.common.MoviePagingBean;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.MainListVO;
import com.kosta.movie20.model.vo.MovieVO;

public class MainMovieListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int tpc = MovieDAO.getInstance().getTotalPostCount();
		String pno=request.getParameter("pageNo");
		MoviePagingBean mpb=null;
		if(pno==null){
			mpb = new MoviePagingBean(tpc);
		}else{
			mpb = new MoviePagingBean(tpc,Integer.parseInt(pno));
		}
		/*int nowPage = 1;
		if(request.getParameter("pageNo")!=null) {
			nowPage = Integer.parseInt(request.getParameter("pageNo"));
		}
		MoviePagingBean mpb = new MoviePagingBean(tpc,nowPage);*/
		ArrayList<MovieVO> list =  MovieDAO.getInstance().movieList(mpb);
		MainListVO lvo = new MainListVO(list,mpb);
		request.setAttribute("lvo", lvo);
		request.setAttribute("url", "/movie/mainMovieList.jsp");
		return "/layout/home.jsp";
	}

}
