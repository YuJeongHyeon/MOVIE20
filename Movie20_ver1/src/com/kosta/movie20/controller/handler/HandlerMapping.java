package com.kosta.movie20.controller.handler;

import com.kosta.movie20.controller.common.Controller;
import com.kosta.movie20.controller.member.MemberDeleteController;
import com.kosta.movie20.controller.member.MemberLoginController;
import com.kosta.movie20.controller.member.MemberLogoutController;
import com.kosta.movie20.controller.member.MemberDuplicateIdController;
import com.kosta.movie20.controller.member.MemberCheckIdController;
import com.kosta.movie20.controller.member.MemberDeleteController;
import com.kosta.movie20.controller.member.MemberLoginController;
import com.kosta.movie20.controller.member.MemberLogoutController;
import com.kosta.movie20.controller.member.MemberRegisterController;
import com.kosta.movie20.controller.member.MemberRegisterViewController;
import com.kosta.movie20.controller.member.MemberSearchController;
import com.kosta.movie20.controller.member.MemberSearchFormController;
import com.kosta.movie20.controller.member.MemberUpdateController;
import com.kosta.movie20.controller.member.MemberUpdateFormController;
import com.kosta.movie20.controller.member.MemberUpdateAuthorityController;
import com.kosta.movie20.controller.movie.MovieGenreController;
import com.kosta.movie20.controller.movie.MovieHitDaHitController;
import com.kosta.movie20.controller.movie.MovieMainListController;
import com.kosta.movie20.controller.movie.MovieDeleteController;
import com.kosta.movie20.controller.movie.MovieDetailController;
import com.kosta.movie20.controller.movie.MovieRegisterViewController;
import com.kosta.movie20.controller.movie.MovieSearchController;
import com.kosta.movie20.controller.movie.MovieUpdateController;
import com.kosta.movie20.controller.movie.MovieUpdateFormController;
import com.kosta.movie20.controller.movie.MovieUploadController;
import com.kosta.movie20.controller.notice.NoticeDeleteController;
import com.kosta.movie20.controller.notice.NoticeDetailController;
import com.kosta.movie20.controller.notice.NoticeListController;
import com.kosta.movie20.controller.notice.NoticeUpdateController;
import com.kosta.movie20.controller.notice.NoticeUpdateFormController;
import com.kosta.movie20.controller.notice.NoticeWriteFormController;
import com.kosta.movie20.controller.notice.NoticeWriteRegisterController;
import com.kosta.movie20.controller.review.ReviewDeleteController;
import com.kosta.movie20.controller.review.ReviewDetailController;
import com.kosta.movie20.controller.review.ReviewUpdateController;
import com.kosta.movie20.controller.review.ReviewUpdateFormController;
import com.kosta.movie20.controller.review.ReviewWriteRegisterController;
import com.kosta.movie20.second.commentcontroller.CommentWriteController;
import com.kosta.movie20.second.commentcontroller.CommentDeleteController;

import com.kosta.movie20.second.score.controller.RegisterScoreController;
import com.kosta.movie20.second.seatcontroller.SeatDeleteReservationController;
import com.kosta.movie20.second.seatcontroller.MeetingListInfoController;
import com.kosta.movie20.second.seatcontroller.MeetingRegisterController;
import com.kosta.movie20.second.seatcontroller.MeetingRegisterFormController;
import com.kosta.movie20.second.seatcontroller.SeatReservationController;
import com.kosta.movie20.second.seatcontroller.SeatReservationFormController;
import com.kosta.movie20.second.seatcontroller.SeatUpdateReservationController;

public class HandlerMapping {
	private static HandlerMapping instance=new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return instance;
	}
	public Controller create(String command){		
		Controller controller = null;
		
		if(command.equals("cmdMainList")){
			controller = new MovieMainListController();
		}else if( command.equals("cmdMovieSearch")) {
			controller = new MovieSearchController();
		}else if(command.equals("login")){
			controller = new MemberLoginController();
		}else if(command.equals("hitdahit")){
			controller = new MovieHitDaHitController();
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
			controller = new MemberLogoutController();
		}else if(command.equals("cmdNoticeList")) {
			controller = new NoticeListController();
		}else if(command.equals("cmdNoticeDetail")) {
			controller = new NoticeDetailController();
		}else if(command.equals("cmdUpdateFormNotice")) {
			controller = new NoticeUpdateFormController();
		}else if(command.equals("cmdWriteFormNotice")) {
			controller = new NoticeWriteFormController();
		}else if(command.equals("cmdNoticeWrite")) {
			controller = new NoticeWriteRegisterController();
		}else if(command.equals("cmdUpdateNotice")) {
			controller = new NoticeUpdateController();
		}else if(command.equals("cmdDeleteNotice")) {
			controller = new NoticeDeleteController();
		}else if(command.equals("cmdMemberSearchForm")) {
			controller = new MemberSearchFormController();
		}else if(command.equals("cmdMemberSearch")) {
			controller = new MemberSearchController();
		}else if(command.equals("cmdDeleteMember")) {
			controller = new MemberDeleteController();
		}else if(command.equals("cmdUpdateAuthority")) {
			controller = new MemberUpdateAuthorityController();
		}else if(command.equals("idCheck")) {			
			controller = new MemberDuplicateIdController();
		}else if(command.equals("register")){
			controller = new MemberRegisterController();
		}else if(command.equals("memberRegisterView")) {
			controller = new MemberRegisterViewController();
		}else if(command.equals("cmdMemberUpdateForm")) {
			controller = new MemberUpdateFormController();
		}else if(command.equals("cmdMemberUpdate")) {
			controller = new MemberUpdateController();
		}else if(command.equals("cmdCheckId")) {
			controller = new MemberCheckIdController();
		}else if(command.equals("upload")) {
			controller =  new MovieUploadController();
		}else if(command.equals("movieRegisterView")) {
			controller = new MovieRegisterViewController();
		}else if(command.equals("movieUpdateForm")) {
			controller = new MovieUpdateFormController();
		}else if(command.equals("movieDelete")) {
			controller = new MovieDeleteController();
		}else if(command.equals("movieUpdate")) {
			controller = new MovieUpdateController();
		}else if(command.equals("genre")) {
			controller = new MovieGenreController();
		}
		/////////////////////////2 차////////////////////////////////
		else if(command.equals("cmdMeetingRegisterForm")) {
			controller = new MeetingRegisterFormController();
		}else if(command.equals("cmdMeetingRegister")) {
			controller = new MeetingRegisterController();
		}else if(command.equals("cmdMeetingListInfo")) {
			controller = new MeetingListInfoController();
		}else if(command.equals("cmddeleteComment")) {
			controller = new CommentDeleteController();
		}else if(command.equals("cmdCommentWrite")) {
			controller = new CommentWriteController();
		}else if(command.equals("cmdSeatReservationForm")) {
			controller = new SeatReservationFormController();
		}else if(command.equals("cmdSeatReservation")) {
			controller = new SeatReservationController();
		}
		////////////////////////////2차 SCORE/////////
		else if(command.equals("cmdRegisterScore")) {
			controller = new RegisterScoreController();
		}else if( command.equals("cmdUpdateSeatReservation")) {
			controller = new SeatUpdateReservationController();
		}else if( command.equals("cmdDeleteSeatReservation")) {
			controller = new SeatDeleteReservationController();
		}
		
		return controller;
	}
	
	
}
