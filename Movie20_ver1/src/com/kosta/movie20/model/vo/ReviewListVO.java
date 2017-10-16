package com.kosta.movie20.model.vo;

import java.util.ArrayList;

import com.kosta.movie20.model.common.PagingBean;

public class ReviewListVO {
	private ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
	private PagingBean pb;
	public ReviewListVO() {
		super();
	}
	public ReviewListVO(ArrayList<ReviewVO> list, PagingBean pb) {
		super();
		this.list = list;
		this.pb = pb;
	}
	@Override
	public String toString() {
		return "ListVO [list=" + list + ", pb=" + pb + "]";
	}
	public ArrayList<ReviewVO> getList() {
		return list;
	}
	public void setList(ArrayList<ReviewVO> list) {
		this.list = list;
	}
	public PagingBean getPb() {
		return pb;
	}
	public void setPb(PagingBean pb) {
		this.pb = pb;
	}


	
}
