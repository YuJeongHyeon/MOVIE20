package com.kosta.movie20.second.seatcontroller;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.vo.MemberVO;
import com.kosta.movie20.second.seatmodel.MeetingVO;
import com.kosta.movie20.second.seatmodel.SeatDAO;


public class SeatReservationFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(false);

		if(session==null||session.getAttribute("membervo")==null){
			System.out.println("session : 체크 실패 index로 ");
			return "redirect:index.jsp";
		}
		
		String picture = request.getParameter("picture");
		String title = request.getParameter("title");
		String meetingDate = request.getParameter("meetingDate");
		
		MeetingVO mvo = 
				SeatDAO.getInstance().meetingInfoByDate(meetingDate);


		MemberVO mvo2 = (MemberVO)session.getAttribute("membervo");
		String seatNum = SeatDAO.getInstance().getSeatNumById(mvo2.getId(), meetingDate);

		ArrayList<String> seatList = SeatDAO.getInstance().getAllSeat();
		request.setAttribute("seatList", seatList);
		
		if(mvo!=null) {
			mvo.setTitle(title);
			mvo.setPicture(picture);
			request.setAttribute("meetingData", mvo);
			request.setAttribute("seatNum", seatNum);
		}else {
			System.out.println("MeetingVO 객체 null");
		}
		
		request.setAttribute("url", "/second/seatReservationForm.jsp");
		return "/layout/home.jsp";
	}

}
