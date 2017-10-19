package com.kosta.movie20.second.seatcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.vo.MemberVO;
import com.kosta.movie20.second.seatmodel.SeatDAO;

public class SeatReservationController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);

		if(session==null||session.getAttribute("membervo")==null){
			System.out.println("session : 체크 실패 index로 ");
			return "redirect:index.jsp";
		}
		
		String meetingDate = request.getParameter("meetingDate"); //상영시간
	//	String mNo = request.getParameter("mNo"); //영화번호
		String seatNum = request.getParameter("seatNum"); //좌석번호
		MemberVO mvo = (MemberVO)session.getAttribute("membervo");
		System.out.println("seatNum : "+ seatNum);
		SeatDAO.getInstance().reserveSeat(meetingDate,seatNum,mvo.getId());
		
		//request.setAttribute("url", "/second/seetReservationForm.jsp");
		return "redirect:index.jsp";
	}

}
