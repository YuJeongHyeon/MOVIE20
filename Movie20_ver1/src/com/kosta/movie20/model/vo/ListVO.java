package com.kosta.movie20.model.vo;

import java.util.ArrayList;

import com.kosta.movie20.model.common.PagingBeanMovie;
import com.kosta.movie20.model.common.PagingBeanNotice;
import com.kosta.movie20.model.common.PagingBean;

public class ListVO<T> {
	private ArrayList<T> list = new ArrayList<T>();
	private PagingBean pb;
	private PagingBeanMovie mpb;
	private PagingBeanNotice npb;
	public ListVO() {
		super();
	}
	public ListVO(ArrayList<T> list, PagingBean pb) {
		super();
		this.list = list;
		this.pb = pb;
	}
	public ListVO(ArrayList<T> list, PagingBeanMovie mpb) {
		super();
		this.list = list;
		this.mpb = mpb;
	}
	public ListVO(ArrayList<T> list, PagingBeanNotice npb) {
		super();
		this.list = list;
		this.npb = npb;
	}
	public ArrayList<T> getList() {
		return list;
	}
	public void setList(ArrayList<T> list) {
		this.list = list;
	}
	public PagingBean getPb() {
		return pb;
	}
	public void setPb(PagingBean pb) {
		this.pb = pb;
	}
	public PagingBeanMovie getMpb() {
		return mpb;
	}
	public void setMpb(PagingBeanMovie mpb) {
		this.mpb = mpb;
	}
	public PagingBeanNotice getNpb() {
		return npb;
	}
	public void setNpb(PagingBeanNotice npb) {
		this.npb = npb;
	}
	@Override
	public String toString() {
		return "ListVO [list=" + list + ", pb=" + pb + ", mpb=" + mpb + ", npb=" + npb + "]";
	}
	
}
