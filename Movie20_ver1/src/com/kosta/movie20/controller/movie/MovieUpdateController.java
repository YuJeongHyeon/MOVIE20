package com.kosta.movie20.controller.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;
import com.kosta.movie20.model.vo.MovieVO;

public class MovieUpdateController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("membervo")==null||request.getMethod().equals("POST")==false){
			return "redirect:index.jsp";
		}
		String mNo = request.getParameter("mNo");
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		String character = request.getParameter("character");
		String runtime = request.getParameter("runtime");
		String viewingcheck = request.getParameter("viewingcheck");
		String playdate = request.getParameter("playdate");
		int grade = Integer.parseInt(request.getParameter("grade"));
		String summary = request.getParameter("summary");
		
		
		MovieVO movievo = new MovieVO(mNo, title, summary, character, director, genre, runtime, viewingcheck, playdate, grade);
		MasterDAO.getInstance().movieUpdate(movievo);
		
		return "index.jsp";
	}
}
