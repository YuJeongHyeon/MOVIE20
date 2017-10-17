package com.kosta.movie20.controller.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.common.NoticePagingBean;
import com.kosta.movie20.model.dao.MasterDAO;
import com.kosta.movie20.model.vo.ListVO;
import com.kosta.movie20.model.vo.NoticeVO;

public class NoticeListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int tpc = MasterDAO.getInstance().getTotalPostCount();
		String pno=request.getParameter("pageNo");
		NoticePagingBean npb=null;
		if(pno==null){
			npb = new NoticePagingBean(tpc);
		}else{
			npb = new NoticePagingBean(tpc,Integer.parseInt(pno));
		}
		ArrayList<NoticeVO> list =  MasterDAO.getInstance().noticeList(npb);
		ListVO<NoticeVO> lvo = new ListVO<NoticeVO>(list,npb);
		request.setAttribute("lvo", lvo);
		// 공지사항 중 목록에 고정할 중요공지사항을 호출해 리스트에 담아 jsp로 던진다
		ArrayList<NoticeVO> importList = MasterDAO.getInstance().ImportNoticeList();
		request.setAttribute("importList", importList);
		request.setAttribute("url", "/notice/noticeList.jsp");
		return "/layout/home.jsp";
	}

}
