package com.kosta.movie20.model.vo;

public class NoticeVO {
	private String nNo;
	private String title;
	private String content;
	private String regdate;
	private int hits;
	private String important;
	private String masterId;
	public NoticeVO() {
		super();
	}
	public NoticeVO(String title, String content, String important, String masterId) {
		super();
		this.title = title;
		this.content = content;
		this.important = important;
		this.masterId = masterId;
	}
	public NoticeVO(String nNo, String title, String content, String important, String masterId) {
		super();
		this.nNo = nNo;
		this.title = title;
		this.content = content;
		this.important = important;
		this.masterId = masterId;
	}
	public NoticeVO(String nNo, String title, String content, String regdate, int hits, String important,
			String masterId) {
		super();
		this.nNo = nNo;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hits = hits;
		this.important = important;
		this.masterId = masterId;
	}
	public String getnNo() {
		return nNo;
	}
	public void setnNo(String nNo) {
		this.nNo = nNo;
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
	public String getImportant() {
		return important;
	}
	public void setImportant(String important) {
		this.important = important;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	@Override
	public String toString() {
		return "NoticeVO [nNo=" + nNo + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", hits="
				+ hits + ", important=" + important + ", masterId=" + masterId + "]";
	}
	
	
	
}
