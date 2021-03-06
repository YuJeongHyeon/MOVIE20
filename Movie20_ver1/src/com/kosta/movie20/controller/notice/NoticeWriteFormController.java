package com.kosta.movie20.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;

public class NoticeWriteFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("membervo")==null) {
			request.setAttribute("url", "../notice/noticeList.jsp");
		}else {
			request.setAttribute("url", "../notice/noticeWrite.jsp");
		}
		
		return "/layout/home.jsp";
	}

}
