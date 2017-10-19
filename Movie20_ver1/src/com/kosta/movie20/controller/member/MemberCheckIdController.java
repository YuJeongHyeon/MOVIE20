package com.kosta.movie20.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.dao.MasterDAO;

public class MemberCheckIdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String checkId =request.getParameter("id");
		int checkFlag = 
				MasterDAO.getInstance().checkMemberIdByAjax(checkId);
		JSONObject json = new JSONObject();
		if(checkFlag>=1) {
			json.put("flag", 1);
		}else {
			json.put("flag", 0);
		}
		//map or VO 는 JSONObject 생성자에 할당한다.
	
		request.setAttribute("responseBody", json);
		
		return "AjaxView";
	}

}
