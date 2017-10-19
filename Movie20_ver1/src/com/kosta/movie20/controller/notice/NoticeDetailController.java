package com.kosta.movie20.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;
import com.kosta.movie20.model.vo.NoticeVO;

public class NoticeDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		String nNo = request.getParameter("nNo");
		NoticeVO nvo = MasterDAO.getInstance().getNoticeDetail(nNo);
		if(session==null||session.getAttribute("membervo")==null) {
			request.setAttribute("nvo", nvo);
		}else {
			MasterDAO.getInstance().updateHitdaHit(nNo);
			request.setAttribute("nvo", nvo);
		}
		request.setAttribute("url", "../notice/noticeDetailList.jsp");
		return "/layout/home.jsp";
	}

}
