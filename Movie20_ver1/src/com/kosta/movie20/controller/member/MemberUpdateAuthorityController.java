package com.kosta.movie20.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;

public class MemberUpdateAuthorityController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		HttpSession session = request.getSession(false);
		System.out.println("UpdateAuthorityController세션체크 전 내용");
		if(session==null||session.getAttribute("membervo")==null){
			return "redirect:index.jsp";
		}
		System.out.println("UpdateAuthorityController 세션체크 이후 내용");
		String updateId = request.getParameter("id");
		String authority = request.getParameter("authority");
		System.out.println("id : "+updateId +" authority: "+authority );
		MasterDAO.getInstance().updateMemberAuthorityById(updateId, authority);
	
		return "redirect:index.jsp";
	}

}
