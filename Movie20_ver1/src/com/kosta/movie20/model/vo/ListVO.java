package com.kosta.movie20.model.vo;

import java.util.ArrayList;

import com.kosta.movie20.model.common.PagingBean;

public class ListVO {
	private ArrayList<MovieVO> list = new ArrayList<MovieVO>();
	private PagingBean pb;
	public ListVO() {
		super();
	}
	public ListVO(ArrayList<MovieVO> list, PagingBean pb) {
		super();
		this.list = list;
		this.pb = pb;
	}
	@Override
	public String toString() {
		return "ListVO [list=" + list + ", pb=" + pb + "]";
	}
	public ArrayList<MovieVO> getList() {
		return list;
	}
	public void setList(ArrayList<MovieVO> list) {
		this.list = list;
	}
	public PagingBean getPb() {
		return pb;
	}
	public void setPb(PagingBean pb) {
		this.pb = pb;
	}


	
}
