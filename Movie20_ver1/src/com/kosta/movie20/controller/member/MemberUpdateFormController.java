package com.kosta.movie20.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MemberDAO;
import com.kosta.movie20.model.vo.MemberVO;

public class MemberUpdateFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		
		
		if(session==null||session.getAttribute("membervo")==null){
			return "redirect:index.jsp";
		}
		MemberVO membervo=(MemberVO)session.getAttribute("membervo");
		String id=membervo.getId();
		
		MemberVO memberVo=MemberDAO.getInstance().memberSearch(id);
		
		request.setAttribute("memberVo", memberVo);
		
		String url = "../member/myInfoUpdate.jsp";
		request.setAttribute("url", url);
		return "layout/home.jsp";
		
		
	}

}
