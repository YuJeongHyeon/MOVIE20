package com.kosta.movie20.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MemberDAO;
import com.kosta.movie20.model.vo.MemberVO;

public class MemberRegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String nick=request.getParameter("nick");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String birth=request.getParameter("birth");
		String tel=request.getParameter("tel");
		String favoriteGenre=request.getParameter("favoriteGenre");
		MemberVO vo=new MemberVO(id,name,password,nick,address,birth,tel,favoriteGenre);
		MemberDAO.getInstance().registerMember(vo);
		return "index.jsp";
	}

}
