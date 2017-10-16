package com.kosta.movie20.model.vo;

import java.util.ArrayList;

import com.kosta.movie20.model.common.MoviePagingBean;
import com.kosta.movie20.model.common.PagingBean;

public class ListVO<T> {
	private ArrayList<T> list = new ArrayList<T>();
	private PagingBean pb;
	private MoviePagingBean mpb;
	public ListVO() {
		super();
	}
	public ListVO(ArrayList<T> list, MoviePagingBean mpb) {
		super();
		this.list = list;
		this.mpb = mpb;
	}
	public ListVO(ArrayList<T> list, PagingBean pb) {
		super();
		this.list = list;
		this.pb = pb;
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
	public MoviePagingBean getMpb() {
		return mpb;
	}
	public void setMpb(MoviePagingBean mpb) {
		this.mpb = mpb;
	}
	@Override
	public String toString() {
		return "ListVO [list=" + list + ", pb=" + pb + ", mpb=" + mpb + "]";
	}
	
	
}
