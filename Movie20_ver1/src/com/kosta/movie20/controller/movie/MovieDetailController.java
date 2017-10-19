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
import com.kosta.movie20.second.score.model.ScoreDAO;
import com.kosta.movie20.second.score.model.ScoreVO;

public class MovieDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String movieNo = request.getParameter("movieNo");
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			MovieDAO.getInstance().addMovieHit(movieNo);
		}
		
		MovieVO movievo =MovieDAO.getInstance().getMovieDetail(movieNo);
		
		///// 광태 추가  카트 코드 
		if(session!=null&&session.getAttribute("membervo")!=null) {
			MemberVO mvo=	(MemberVO)session.getAttribute("membervo");
			
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
		
		/////////////// 영훈 checkScore 코드 start
		// db의 score table이 생성되었는지 여부 체킹 후 
		// 생성이 되지 않았을 경우 생성해주는 과정
		if(session!=null&&session.getAttribute("membervo")!=null) {
			MemberVO membervo = (MemberVO) session.getAttribute("membervo");
			String id = membervo.getId();
			//	String movieNo = request.getParameter("movieNo");
			int mNo = Integer.parseInt(movieNo);
			ScoreVO svo = ScoreDAO.getInstance().getCheckScore(mNo, id);
			System.out.println("처음 체킹 "+svo.getScore());
			if(svo.getScore()==0) {
				ScoreDAO.getInstance().registerScroreTable(svo);
				ScoreVO svo2 = ScoreDAO.getInstance().getCheckScore(mNo,id);
				svo = svo2;
				System.out.println("new register 후 체킹 "+svo.getScore());	
			}
			request.setAttribute("svo", svo);
			System.out.println("마지막 "+svo.getScore());
		}
	
		//////////////// checkScore 코드 end
	
		int totalPostCount=MovieDAO.getInstance().getReviewListcount(movieNo);
		String pno=request.getParameter("pageNo");
		
		PagingBean pb=null;
		if(pno==null){
			pb=new PagingBean(totalPostCount);
		}else{
			pb=new PagingBean(totalPostCount,Integer.parseInt(pno));
		}

		
		ArrayList<ReviewVO> rlist =MovieDAO.getInstance().getMovieReviewList(movieNo,pb);
		ReviewListVO listVO=new ReviewListVO(rlist,pb);
		request.setAttribute("listVO", listVO);//보여줄 리뷰리스트		
		request.setAttribute("movievo", movievo);//영화정보
		
		String url = "../movie/movieDetailResult.jsp";
		request.setAttribute("url", url);
		return "layout/home.jsp";
		
	}

}
