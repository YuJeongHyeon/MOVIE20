package com.kosta.movie20.second.score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.vo.MemberVO;
import com.kosta.movie20.second.score.model.ScoreDAO;
import com.kosta.movie20.second.score.model.ScoreVO;

public class RegisterScoreController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("membervo")==null){
			request.setAttribute("url", "../movie/movieDetailResult.jsp");
		}
		int score = Integer.parseInt(request.getParameter("score"));
		MemberVO membervo = (MemberVO) session.getAttribute("membervo");
		String id = membervo.getId();
		String mNo = request.getParameter("mNo");
		ScoreVO svo = new ScoreVO(mNo,id,score);
		ScoreDAO.getInstance().registerScore(svo);
	//	아래 주석을 제외하고 jsp로가 아닌 MovieDetailController로 전달
	//	request.setAttribute("svo", svo);
	//	request.setAttribute("url", "../movie/movieDetailResult.jsp");
		
	//	return "layout/home.jsp";
		
		return "DispatcherServlet?command=MovieDetail&movieNo="+mNo;
		
	}

}
