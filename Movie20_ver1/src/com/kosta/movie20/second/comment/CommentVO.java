package com.kosta.movie20.second.comment;

public class CommentVO {
	private String cno;
	private String content;
	private String writetime;
	private String id;
	private String rno;
	
	
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritetime() {
		return writetime;
	}
	public void setWritetime(String writetime) {
		this.writetime = writetime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	
	
	public CommentVO(String cno, String content) {
		super();
		this.cno = cno;
		this.content = content;
	}
	
	public CommentVO(String content, String id, String rno) {
		super();
		this.content = content;
		this.id = id;
		this.rno = rno;
	}
	public CommentVO(String cno, String content, String writetime, String id, String rno) {
		super();
		this.cno = cno;
		this.content = content;
		this.writetime = writetime;
		this.id = id;
		this.rno = rno;
	}
	public CommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
