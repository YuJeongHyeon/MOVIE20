package com.kosta.movie20.model.vo;

public class NoticeVO {
	private String nno;
	private String title;
	private String content;
	private String regdate;
	private int hits;
	private String masterId;
	public NoticeVO() {
		super();
	}
	public NoticeVO(String nno, String title, String content, String regdate, int hits, String masterId) {
		super();
		this.nno = nno;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hits = hits;
		this.masterId = masterId;
	}
	public String getNno() {
		return nno;
	}
	public void setNno(String nno) {
		this.nno = nno;
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
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	@Override
	public String toString() {
		return "NoticeVO [nno=" + nno + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", hits="
				+ hits + ", masterId=" + masterId + "]";
	}
	

}
