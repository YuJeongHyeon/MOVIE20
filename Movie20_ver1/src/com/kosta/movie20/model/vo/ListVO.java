package com.kosta.movie20.model.vo;

import java.util.ArrayList;

import com.kosta.movie20.model.common.PagingBean;

public class ListVO {
	private ArrayList<NoticeVO> nList = new ArrayList<NoticeVO>();
	private ArrayList<ReviewVO> rList = new ArrayList<ReviewVO>();
	private PagingBean pb;
	public ListVO() {
		super();
	}
	public ListVO(ArrayList<NoticeVO> nList, PagingBean pb) {
		super();
		this.nList = nList;
		this.pb = pb;
	}
	public ListVO(ArrayList<NoticeVO> nList, ArrayList<ReviewVO> rList, PagingBean pb) {
		super();
		this.nList = nList;
		this.rList = rList;
		this.pb = pb;
	}
	public ArrayList<NoticeVO> getnList() {
		return nList;
	}
	public void setnList(ArrayList<NoticeVO> nList) {
		this.nList = nList;
	}
	public ArrayList<ReviewVO> getrList() {
		return rList;
	}
	public void setrList(ArrayList<ReviewVO> rList) {
		this.rList = rList;
	}
	public PagingBean getPb() {
		return pb;
	}
	public void setPb(PagingBean pb) {
		this.pb = pb;
	}
	@Override
	public String toString() {
		return "ListVO [nList=" + nList + ", rList=" + rList + ", pb=" + pb + "]";
	}
	
	
}
