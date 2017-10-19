package com.kosta.movie20.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;


public class MemberDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		System.out.println("session : serchmember " );
		if(session==null||session.getAttribute("membervo")==null){
			return "redirect:index.jsp";
		}
		String deleteId = request.getParameter("id");
		MasterDAO.getInstance().deleteMemberById(deleteId);
		System.out.println("삭제 완료");
		return "redirect:index.jsp";
	}

}
