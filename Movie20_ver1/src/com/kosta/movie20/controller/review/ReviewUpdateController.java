package com.kosta.movie20.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.ReviewVO;

public class ReviewUpdateController implements Controller {

		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			HttpSession session=request.getSession(false);
			if(session==null||session.getAttribute("membervo")==null){
				return "redirect:index.jsp";
			}
		
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			String rno=request.getParameter("rno");
			
			ReviewVO rvo=new ReviewVO( title, content, rno);
			
			
			MovieDAO.getInstance().reviewUpdate(rvo);
			ReviewVO rivo=MovieDAO.getInstance().movieReviewDetail(rno);
			
			String url = "redirect:DispatcherServlet?command=MovieDetail&movieNo="+rivo.getMno();
			//request.setAttribute("url", url);
			return url;
		}

	}

