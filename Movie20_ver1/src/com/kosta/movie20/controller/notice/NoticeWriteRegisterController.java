package com.kosta.movie20.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;
import com.kosta.movie20.model.vo.MemberVO;
import com.kosta.movie20.model.vo.NoticeVO;

public class NoticeWriteRegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		String path ="";
		if(session==null||session.getAttribute("membervo")==null) {
			path = "redirect:index.jsp";
		}else {
	//		MemberVO mvo = (MemberVO) session.getAttribute("membervo");
	//		String masterId  = mvo.getId();
			String masterId = ((MemberVO) session.getAttribute("membervo")).getId();
			System.out.println(masterId);
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String important = request.getParameter("important");
			NoticeVO nvo = new NoticeVO(title,content,important,masterId);
			nvo = MasterDAO.getInstance().noticeWrite(nvo);
			System.out.println(nvo);
			path="redirect:DispatcherServlet?command=cmdNoticeDetail&nNo="+nvo.getnNo();
			System.out.println(nvo.getnNo());
		}
		return path;
	}

}
