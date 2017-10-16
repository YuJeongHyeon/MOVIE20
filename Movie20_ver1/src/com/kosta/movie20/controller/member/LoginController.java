package com.kosta.movie20.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MemberDAO;
import com.kosta.movie20.model.vo.MemberVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("id :" + id + " " + "password : "+ password);
		MemberVO mvo = new MemberVO(id, password);
		MemberVO vo = MemberDAO.getInstance().login(mvo);
		
		if(vo != null){
			HttpSession session = request.getSession();
			session.setAttribute("mvo", vo);
			return "redirect:index.jsp";
		}else{
			return "redirect:member/loginFail.jsp";
		}
			
	}

}