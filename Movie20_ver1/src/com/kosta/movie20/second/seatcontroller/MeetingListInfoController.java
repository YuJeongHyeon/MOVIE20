package com.kosta.movie20.second.seatcontroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.second.seatmodel.MeetingVO;
import com.kosta.movie20.second.seatmodel.SeatDAO;

public class MeetingListInfoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<MeetingVO> list =
				SeatDAO.getInstance().getMeetingListInfo();
		
		

		request.setAttribute("meetList", list);

		request.setAttribute("url", "../second/meetingListInfo.jsp");
		return "/layout/home.jsp";
	}

}
