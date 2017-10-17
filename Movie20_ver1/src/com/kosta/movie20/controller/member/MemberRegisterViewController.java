package com.kosta.movie20.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;

public class MemberRegisterViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("컨트롤러 들어온다");
		request.setAttribute("url", "/member/memberRegister.jsp");
		return "/layout/home.jsp";
	}

}
