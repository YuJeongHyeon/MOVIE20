package com.kosta.movie20.model.vo;

public class ReviewVO {
	private String rno;
	private String title;
	private String content;
	private String regdate;
	private int hits;
	private String mno;
	private String id;
	public ReviewVO() {
		super();
	}
	public ReviewVO(String rno, String title, String content, String regdate, int hits, String mno, String id) {
		super();
		this.rno = rno;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hits = hits;
		this.mno = mno;
		this.id = id;
	}
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ReviewVO [rno=" + rno + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", hits="
				+ hits + ", mno=" + mno + ", id=" + id + "]";
	}
	
}
