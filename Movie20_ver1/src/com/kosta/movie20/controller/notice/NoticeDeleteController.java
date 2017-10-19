package com.kosta.movie20.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;

public class NoticeDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		String path ="";
		if(session==null||session.getAttribute("membervo")==null){
			path = "redirect:index.jsp";
		}
		String nNo = request.getParameter("nNo");
		MasterDAO.getInstance().deleteNotice(nNo);
		path = "redirect:DispatcherServlet?command=cmdNoticeList";
		
		return path;
	}

}
