package com.kosta.movie20.second.seatcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;

public class MeetingRegisterFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		
		if(session==null||session.getAttribute("membervo")==null){
			System.out.println("session : 체크 실패 index로 ");
			return "redirect:index.jsp";
		}
		
		String moiveNo = request.getParameter("mNo");
		String movieTitle = request.getParameter("title");
		
		request.setAttribute("mNo", moiveNo);
		request.setAttribute("title", movieTitle);
		System.out.println("session : 체크됨, 검색폼으로 ");
		request.setAttribute("url", "../second/meetingRegisterForm.jsp");
		return "/layout/home.jsp";
	}

}
