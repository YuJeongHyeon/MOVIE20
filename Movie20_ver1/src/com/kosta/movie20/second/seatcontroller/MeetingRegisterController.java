package com.kosta.movie20.second.seatcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.second.seatmodel.SeatDAO;

public class MeetingRegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(false);
		
		if(session==null||session.getAttribute("membervo")==null){
			System.out.println("session : 체크 실패 index로 ");
			return "redirect:index.jsp";
		}
		
		
		String mNo = request.getParameter("mNo");
		String meetingDate = request.getParameter("meetingDate");
		String location = request.getParameter("location");
		
		SeatDAO.getInstance().meetingRegister(meetingDate, Integer.parseInt(mNo), location);
		
		
		return "redirect:index.jsp";
	}

}
