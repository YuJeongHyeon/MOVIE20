package com.kosta.movie20.controller.handler;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.controller.member.LoginController;
import com.kosta.movie20.controller.member.LogoutController;
import com.kosta.movie20.controller.movie.HitDaHitController;
import com.kosta.movie20.controller.movie.MainMovieListController;
import com.kosta.movie20.controller.movie.MovieDetailController;
import com.kosta.movie20.controller.movie.MovieSearchController;
import com.kosta.movie20.controller.notice.NoticeDetailController;
import com.kosta.movie20.controller.notice.NoticeListController;
import com.kosta.movie20.controller.notice.NoticeUpdateFormController;
import com.kosta.movie20.controller.notice.NoticeWriteFormController;
import com.kosta.movie20.controller.notice.NoticeWriteRegisterController;
import com.kosta.movie20.controller.review.ReviewDeleteController;
import com.kosta.movie20.controller.review.ReviewDetailController;
import com.kosta.movie20.controller.review.ReviewUpdateController;
import com.kosta.movie20.controller.review.ReviewUpdateFormController;
import com.kosta.movie20.controller.review.ReviewWriteRegisterController;

public class HandlerMapping {
	private static HandlerMapping instance=new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return instance;
	}
	public Controller create(String command){		
		Controller controller = null;
		
		if(command.equals("cmdMainList")){
			controller = new MainMovieListController();
		}else if( command.equals("cmdMovieSearch")) {
			controller = new MovieSearchController();
		}else if(command.equals("login")){
			controller = new LoginController();
		}else if(command.equals("hitdahit")){
			controller = new HitDaHitController();
		}else if(command.equals("MovieDetail")) {
			controller = new MovieDetailController();
		}else if(command.equals("reviewDetail")) {
			controller = new ReviewDetailController();
		}else if(command.equals("reviewWrite")) {
			controller = new ReviewWriteRegisterController();
		}else if(command.equals("updateReviewform")) {
			controller = new ReviewUpdateFormController();
		}else if(command.equals("updateReview")) {
			controller = new ReviewUpdateController();
		}else if(command.equals("deleteReview")) {
			controller = new ReviewDeleteController();
		}else if(command.equals("logout")) {
			controller = new LogoutController();
		}else if(command.endsWith("cmdNoticeList")) {
			controller = new NoticeListController();
		}else if(command.endsWith("cmdNoticeDetail")) {
			controller = new NoticeDetailController();
		}else if(command.endsWith("cmdUpdateFormNotice")) {
			controller = new NoticeUpdateFormController();
		}else if(command.endsWith("cmdWriteFormNotice")) {
			controller = new NoticeWriteFormController();
		}else if(command.endsWith("cmdNoticeWrite")) {
			controller = new NoticeWriteRegisterController();
		}
		
		
		return controller;
	}
	
	
}
