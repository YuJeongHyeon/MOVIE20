package com.kosta.movie20.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MemberDAO;

public class CheckDuplicateIdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		int idcomfirm=MemberDAO.getInstance().checkDuplicateId(id);
		String result=null;
		if(idcomfirm!=1) {
            result="ok";
         }else {
            result="fail";
         }
         request.setAttribute("responseBody", result);
		return "AjaxView";
	}

}
