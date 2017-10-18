package com.kosta.movie20.second.commentcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.ReviewVO;
import com.kosta.movie20.second.comment.CommentDAO;
import com.kosta.movie20.second.comment.CommentVO;

public class UpdateCommentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("membervo")==null){
			return "redirect:index.jsp";
		}
	
		String cno=request.getParameter("cno");
		String comment=request.getParameter("comment");
		String rno=request.getParameter("rno");
		String mno=request.getParameter("mno");
		CommentVO cvo=new CommentVO( cno,comment);
		CommentDAO.getInstance().commentUpdate(cvo);
		
	
		
		
		String url = "redirect:DispatcherServlet?command=reviewDetail&rno="+rno+"&movieno="+mno;
		
		return url;
	}

}
