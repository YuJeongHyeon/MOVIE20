package com.kosta.movie20.second.seatmodel;

public class SeatVO {
	private String seatNum;
	private String id;
	@Override
	public String toString() {
		return "SeatNumVO [seatNum=" + seatNum + ", id=" + id + "]";
	}
	public SeatVO(String seatNum, String id) {
		super();
		this.seatNum = seatNum;
		this.id = id;
	}
	public SeatVO() {
		super();
	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
