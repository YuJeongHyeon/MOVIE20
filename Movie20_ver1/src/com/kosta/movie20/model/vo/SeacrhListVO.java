package com.kosta.movie20.model.vo;

import java.util.ArrayList;

import com.kosta.movie20.model.common.PagingBeanSearch;

public class SeacrhListVO {
	private ArrayList<MovieVO> list = new ArrayList<MovieVO>();
	private PagingBeanSearch pb;
	public SeacrhListVO() {
		super();
	}
	public SeacrhListVO(ArrayList<MovieVO> list, PagingBeanSearch pb) {
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
	public PagingBeanSearch getPb() {
		return pb;
	}
	public void setPb(PagingBeanSearch pb) {
		this.pb = pb;
	}


	
}
