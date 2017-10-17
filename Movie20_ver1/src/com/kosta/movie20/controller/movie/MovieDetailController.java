package com.kosta.movie20.controller.movie;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.model.common.PagingBean;
import com.kosta.movie20.model.dao.MovieDAO;
import com.kosta.movie20.model.vo.MemberVO;
import com.kosta.movie20.model.vo.MovieVO;
import com.kosta.movie20.model.vo.ReviewListVO;
import com.kosta.movie20.model.vo.ReviewVO;

public class MovieDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String movieNo = request.getParameter("movieNo");
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			MovieDAO.getInstance().movieHitsup(movieNo);
		}
		
		MovieVO movievo =MovieDAO.getInstance().movieDetail(movieNo);
		
		///// 광태 추가  카트 코드 
		if(session!=null&&session.getAttribute("membervo")!=null) {
			MemberVO mvo=	(MemberVO)session.getAttribute("membervo");
			System.out.println("mvo.getCart().size() ::" + mvo.getCart().size());
			if(mvo.getCart().size()==0) {
				mvo.getCart().add(movievo);
			}else {
				int checkCart = -1;
				for (int i = 0; i <mvo.getCart().size(); i++) {
					if( mvo.getCart().get(i).getTitle().equals(movievo.getTitle()) ){	
						checkCart=1;
						break;
					}		
				}
				// 카트에 중복 없을 시 추가.
				if(checkCart==-1&& mvo.getCart().size()>=5) {
					mvo.getCart().remove(0);
					mvo.getCart().add(movievo);
				}else if( checkCart==-1&& mvo.getCart().size()<5) {
					mvo.getCart().add(movievo);
				}			
			}
		}
		//////// 카트 코드 end		
		
		int totalPostCount=MovieDAO.getInstance().getReviewListcount();
		String pno=request.getParameter("pageNo");
		
		PagingBean pb=null;
		if(pno==null){
			pb=new PagingBean(totalPostCount);
		}else{
			pb=new PagingBean(totalPostCount,Integer.parseInt(pno));
		}

		
		ArrayList<ReviewVO> rlist =MovieDAO.getInstance().movieReviewList(movieNo,pb);
		ReviewListVO listVO=new ReviewListVO(rlist,pb);
		request.setAttribute("listVO", listVO);//보여줄 리뷰리스트		
		request.setAttribute("movievo", movievo);//영화정보
		
		String url = "../movie/movieDetailResult.jsp";
		request.setAttribute("url", url);
		return "layout/home.jsp";
		
	}

}
