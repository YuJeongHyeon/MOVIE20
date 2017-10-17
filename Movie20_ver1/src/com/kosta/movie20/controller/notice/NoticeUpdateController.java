package com.kosta.movie20.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;
import com.kosta.movie20.model.vo.MemberVO;
import com.kosta.movie20.model.vo.NoticeVO;

public class NoticeUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		String path ="";
		if(session==null||session.getAttribute("membervo")==null){
			path = "redirect:index.jsp";
		}
		String nNo = request.getParameter("nNo");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		MemberVO membervo = (MemberVO) session.getAttribute("membervo");
		String masterId = membervo.getId();
		String important = request.getParameter("important");
		System.out.println(important);
		NoticeVO nvo = MasterDAO.getInstance().noticeDetail(nNo);
		nvo.setTitle(title);
		nvo.setContent(content);
		nvo.setMasterId(masterId);
		nvo.setImportant(important);
	//	NoticeVO nvo = new NoticeVO(nNo,title,content,important,masterId);
		System.out.println(nvo);
		System.out.println(nvo.getImportant());
		MasterDAO.getInstance().noticeUpdate(nvo);
		path = "redirect:DispatcherServlet?command=cmdNoticeDetail&nNo="+nNo;
		
		return path;
	}

}



