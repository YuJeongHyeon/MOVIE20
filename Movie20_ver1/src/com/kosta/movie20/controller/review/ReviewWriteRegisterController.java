package com.kosta.movie20.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.ReviewVO;

public class ReviewWriteRegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String movieno=request.getParameter("movieno");
		ReviewVO rvo=new ReviewVO( title, content, movieno, id);
		
		MovieDAO.getInstance().reviewWrite(rvo);		

		request.setAttribute("movieNo", movieno);
		String url = "redirect:DispatcherServlet?command=MovieDetail&movieNo="+movieno;
		//request.setAttribute("url", url);
		return url;
	}

}
