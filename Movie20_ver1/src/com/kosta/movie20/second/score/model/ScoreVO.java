package com.kosta.movie20.second.score.model;

public class ScoreVO {
	private String mNo;
	private String id;
	private int score;
	public ScoreVO() {
		super();
	}
	public ScoreVO(String mNo, String id, int score) {
		super();
		this.mNo = mNo;
		this.id = id;
		this.score = score;
	}
	public String getmNo() {
		return mNo;
	}
	public void setmNo(String mNo) {
		this.mNo = mNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "ScoreVO [mNo=" + mNo + ", id=" + id + ", score=" + score + "]";
	}

}
