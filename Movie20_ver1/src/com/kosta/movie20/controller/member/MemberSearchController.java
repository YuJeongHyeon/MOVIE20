package com.kosta.movie20.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;

import com.kosta.movie20.model.vo.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(false);
		System.out.println("session : serchmember " );
		System.out.println("cmdMemberSearch후 컨트롤러와서 세션체크 전 내용");
		if(session==null||session.getAttribute("membervo")==null){
			return "redirect:index.jsp";
		}
	//	System.out.println("cmdMemberSearch후 컨트롤러와서 세션체크 이후 내용");
		String searchMemberId = request.getParameter("id");
		//System.out.println("searchMemberId : "+ searchMemberId);
		MemberVO mvo = MasterDAO.getInstance().findMemberById(searchMemberId);

		if(mvo!=null) {
			System.out.println("sdfsdf:" + mvo.toString());
			session.setAttribute("searchMember", mvo);
			request.setAttribute("url", "../member/memberSearch_result.jsp");		
		}else {
			return "redirect:index.jsp";
		}
		return "/layout/home.jsp";
		
	}

}
