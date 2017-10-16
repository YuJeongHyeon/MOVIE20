package com.kosta.movie20.controller.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.common.PagingBean;
import com.kosta.movie20.model.dao.MasterDAO;
import com.kosta.movie20.model.vo.ListVO;
import com.kosta.movie20.model.vo.NoticeVO;

public class NoticeListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int tpc = MasterDAO.getInstance().getTotalPostCount();
		String pno=request.getParameter("pageNo");
		PagingBean pb=null;
		if(pno==null){
			pb = new PagingBean(tpc);
		}else{
			pb = new PagingBean(tpc,Integer.parseInt(pno));
		}
		ArrayList<NoticeVO> list =  MasterDAO.getInstance().noticeList(pb);
		ListVO<NoticeVO> lvo = new ListVO<NoticeVO>(list,pb);
		request.setAttribute("lvo", lvo);
		request.setAttribute("url", "/notice/noticeList.jsp");
		return "/layout/home.jsp";
	}

}
