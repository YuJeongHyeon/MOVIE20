package com.kosta.movie20.controller.handler;

import com.kosta.movie20.controller.common.Controller;
//import com.kosta.movie20.controller.member.LoginController;
import com.kosta.movie20.controller.movie.HitDaHitController;
import com.kosta.movie20.controller.movie.MainMovieListController;
import com.kosta.movie20.controller.movie.MovieSearchController;

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
//			controller = new LoginController();
		}else if(command.equals("hitdahit")){
			controller = new HitDaHitController();
		}
		
		return controller;
	}
	
	
}
