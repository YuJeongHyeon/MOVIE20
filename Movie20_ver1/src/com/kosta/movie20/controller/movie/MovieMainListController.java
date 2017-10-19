package com.kosta.movie20.controller.movie;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.common.PagingBeanMovie;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.ListVO;
import com.kosta.movie20.model.vo.MovieVO;


public class MovieMainListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int tpc = MovieDAO.getInstance().getTotalMovieCount();
		String pno=request.getParameter("pageNo");
		PagingBeanMovie mpb=null;
		if(pno==null){
			mpb = new PagingBeanMovie(tpc);
		}else{
			mpb = new PagingBeanMovie(tpc,Integer.parseInt(pno));
		}
		ArrayList<MovieVO> list =  MovieDAO.getInstance().getMovieList(mpb);
		ListVO<MovieVO> lvo = new ListVO<MovieVO>(list,mpb);
		request.setAttribute("lvo", lvo);
		request.setAttribute("url", "/movie/mainMovieList.jsp");
		return "/layout/home.jsp";
	}

}
