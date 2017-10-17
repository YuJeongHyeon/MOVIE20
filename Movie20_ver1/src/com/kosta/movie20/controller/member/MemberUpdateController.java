package com.kosta.movie20.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MemberDAO;
import com.kosta.movie20.model.vo.MemberVO;
import com.kosta.movie20.model.vo.ReviewVO;

public class MemberUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("membervo")==null){
			return "redirect:index.jsp";
		}
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String nick=request.getParameter("nick");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String tel=request.getParameter("tel");
		String favoriteGenre=request.getParameter("favoriteGenre");
		
		MemberVO membervo= new MemberVO(id,name,password,nick,address,tel,favoriteGenre);
		
		MemberDAO.getInstance().memberUpdate(membervo);
		
		
		String url = "redirect:DispatcherServlet?command=cmdMainList";
		
		return url;
	}

}
