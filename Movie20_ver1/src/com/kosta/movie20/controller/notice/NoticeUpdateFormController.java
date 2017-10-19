package com.kosta.movie20.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;
import com.kosta.movie20.model.vo.NoticeVO;

public class NoticeUpdateFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("membervo")==null){
			return "redirect:index.jsp";
		}
		String nNo = request.getParameter("nNo");
		NoticeVO nvo = MasterDAO.getInstance().getNoticeDetail(nNo);
		request.setAttribute("nvo", nvo);
	//	System.out.println(nvo.getImportant());
		request.setAttribute("url", "../notice/noticeUpdate.jsp");
		return "/layout/home.jsp";
	}

}
