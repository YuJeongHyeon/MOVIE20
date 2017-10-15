package com.kosta.movie20.model.vo;

import java.util.ArrayList;

import com.kosta.movie20.model.common.MoviePagingBean;
import com.kosta.movie20.model.common.PagingBean;

@SuppressWarnings("rawtypes")
public class MainListVO {
	private ArrayList list = new ArrayList();
	private PagingBean pb;
	private MoviePagingBean mpb;
	public MainListVO() {
		super();
	}
	public MainListVO(ArrayList list, MoviePagingBean mpb) {
		super();
		this.list = list;
		this.mpb = mpb;
	}
	public MainListVO(ArrayList list, PagingBean pb) {
		super();
		this.list = list;
		this.pb = pb;
	}
	public ArrayList getList() {
		return list;
	}
	public void setList(ArrayList list) {
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
