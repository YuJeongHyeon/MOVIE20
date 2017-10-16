package com.kosta.movie20.model.vo;

import java.util.ArrayList;

import com.kosta.movie20.model.common.MoviePagingBean;
import com.kosta.movie20.model.common.PagingBean;

@SuppressWarnings("rawtypes")
public class MainListVO<T> {
	private ArrayList<T> list = new ArrayList<T>();
	private PagingBean pb;
	private MoviePagingBean mpb;
	public MainListVO() {
		super();
	}
	
	public MainListVO(ArrayList<T> list, PagingBean pb) {
		super();
		this.list = list;
		this.pb = pb;
	}

	public MainListVO(ArrayList<T> list, MoviePagingBean mpb) {
		super();
		this.list = list;
		this.mpb = mpb;
	}

	public MainListVO(ArrayList<T> list, PagingBean pb, MoviePagingBean mpb) {
		super();
		this.list = list;
		this.pb = pb;
		this.mpb = mpb;
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
		return "MainListVO [list=" + list + ", pb=" + pb + ", mpb=" + mpb + "]";
	}
	
	
}
