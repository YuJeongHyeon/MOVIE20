package com.kosta.movie20.controller.movie;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.common.PagingBeanSearch;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.MovieVO;
import com.kosta.movie20.model.vo.SeacrhListVO;

public class MovieSearchController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String strSearchWord = request.getParameter("searchWord");
		int totalCount = MovieDAO.getInstance().getSearchMovieTotalCount(strSearchWord);
		System.out.println("r검색 totalCount : "+ totalCount);
		String pno = request.getParameter("pageNo");
		PagingBeanSearch pb = null;
		if(pno==null) {
			pb = new PagingBeanSearch(totalCount);
		}else {
			pb = new PagingBeanSearch(totalCount, Integer.parseInt(pno));
		}
		
		ArrayList<MovieVO> list = 
				MovieDAO.getInstance().getSearchMovieListByName(strSearchWord,pb);
		System.out.println("list size:"+ list.size());
		
		SeacrhListVO listVO = new SeacrhListVO(list, pb);
		
		
		if( list.isEmpty()) {
			request.setAttribute("searchWord", strSearchWord);
			request.setAttribute("url", "../movie/movieSearchResult_isEmpty.jsp");		
		}else {
			request.setAttribute("totalCount", totalCount);
			request.setAttribute("serchListVO", listVO);
			request.setAttribute("searchWord", strSearchWord);
			request.setAttribute("url", "../movie/movieSearchResult.jsp");	
		}
		
		
		
		return "/layout/home.jsp";
	}

}
