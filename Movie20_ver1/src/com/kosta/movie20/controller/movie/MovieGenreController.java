package com.kosta.movie20.controller.movie;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.common.PagingBeanMovie;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.ListVO;
import com.kosta.movie20.model.vo.MovieVO;

public class MovieGenreController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String genre = request.getParameter("genre");
		int tpc = MovieDAO.getInstance().getPostCountByGenre(genre);
		String pno = request.getParameter("pageNo");
		PagingBeanMovie mpb = null;
		if (pno == null) {
			mpb = new PagingBeanMovie(tpc);
		} else {
			mpb = new PagingBeanMovie(tpc, Integer.parseInt(pno));
		}

		ArrayList<MovieVO> list = MovieDAO.getInstance().getMovieListByGenre(genre, mpb);
		ListVO<MovieVO> lvo = new ListVO<MovieVO>(list, mpb);
		if (genre.equals("액션") || genre.equals("멜로") || genre.equals("로맨스") || genre.equals("코미디")
				|| genre.equals("19")) {
			request.setAttribute("lvo", lvo);
			request.setAttribute("url", "/movie/genre.jsp");
			request.setAttribute("genre", genre);
		}

		return "/layout/home.jsp";
	}

}
