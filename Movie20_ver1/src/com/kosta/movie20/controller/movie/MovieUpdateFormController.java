package com.kosta.movie20.controller.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;
import com.kosta.movie20.model.vo.MovieVO;

public class MovieUpdateFormController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String mNo = request.getParameter("mNo");
		
		MovieVO movievo = MasterDAO.getInstance().getMoviePostingByNo(mNo);
		request.setAttribute("movieupdatevo", movievo);
		request.setAttribute("url", "/movie/movieUpdate.jsp");
		return "layout/home.jsp";
	}
}
