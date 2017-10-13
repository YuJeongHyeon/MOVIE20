package com.kosta.movie20.controller.handler;

import com.kosta.movie20.controller.common.Controller;

public class HandlerMapping {
	private static HandlerMapping instance=new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return instance;
	}
	public Controller create(String command){		
		Controller controller = null;
		
		return controller;
	}
	
	
}
