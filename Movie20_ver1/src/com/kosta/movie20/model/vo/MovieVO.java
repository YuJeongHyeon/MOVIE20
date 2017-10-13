package com.kosta.movie20.model.vo;

import java.util.ArrayList;

public class MovieVO {
	ArrayList<ReviewVO> rlist = new ArrayList<ReviewVO>();
	private String mno;
	private String title;
	private String summary;
	private String character;
	private String director;
	private String genre;
	private String runtime;
	private String viewingcheck;
	private String playdate;
	private int hits;
	private int grade;
	private String picture;
	private String masterId;
	public MovieVO() {
		super();
	}
	public MovieVO(ArrayList<ReviewVO> rlist, String mno, String title, String summary, String character,
			String director, String genre, String runtime, String viewingcheck, String playdate, int hits, int grade,
			String picture, String masterId) {
		super();
		this.rlist = rlist;
		this.mno = mno;
		this.title = title;
		this.summary = summary;
		this.character = character;
		this.director = director;
		this.genre = genre;
		this.runtime = runtime;
		this.viewingcheck = viewingcheck;
		this.playdate = playdate;
		this.hits = hits;
		this.grade = grade;
		this.picture = picture;
		this.masterId = masterId;
	}
	public ArrayList<ReviewVO> getRlist() {
		return rlist;
	}
	public void setRlist(ArrayList<ReviewVO> rlist) {
		this.rlist = rlist;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getViewingcheck() {
		return viewingcheck;
	}
	public void setViewingcheck(String viewingcheck) {
		this.viewingcheck = viewingcheck;
	}
	public String getPlaydate() {
		return playdate;
	}
	public void setPlaydate(String playdate) {
		this.playdate = playdate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	@Override
	public String toString() {
		return "MovieVO [rlist=" + rlist + ", mno=" + mno + ", title=" + title + ", summary=" + summary + ", character="
				+ character + ", director=" + director + ", genre=" + genre + ", runtime=" + runtime + ", viewingcheck="
				+ viewingcheck + ", playdate=" + playdate + ", hits=" + hits + ", grade=" + grade + ", picture="
				+ picture + ", masterId=" + masterId + "]";
	}
	

}