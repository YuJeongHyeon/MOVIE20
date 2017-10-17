package com.kosta.movie20.second.seatmodel;

import java.util.ArrayList;

public class MeetingVO {

		private String meetingDate;
		private String mNo;
		private String title;
		private String runtime;
		private String location;
		private String picture;
		private ArrayList<SeatNumVO> seatNumList = new ArrayList<SeatNumVO>();
		public MeetingVO(String meetingDate, String mNo, String title, String runtime, String location, String picture,
				ArrayList<SeatNumVO> seatNumList) {
			super();
			this.meetingDate = meetingDate;
			this.mNo = mNo;
			this.title = title;
			this.runtime = runtime;
			this.location = location;
			this.picture = picture;
			this.seatNumList = seatNumList;
		}
		public MeetingVO() {
			super();
		}
		@Override
		public String toString() {
			return "MeetingVO [meetingDate=" + meetingDate + ", mNo=" + mNo + ", title=" + title + ", runtime="
					+ runtime + ", location=" + location + ", picture=" + picture + ", seatNumList=" + seatNumList
					+ "]";
		}
		public String getMeetingDate() {
			return meetingDate;
		}
		public void setMeetingDate(String meetingDate) {
			this.meetingDate = meetingDate;
		}
		public String getmNo() {
			return mNo;
		}
		public void setmNo(String mNo) {
			this.mNo = mNo;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getRuntime() {
			return runtime;
		}
		public void setRuntime(String runtime) {
			this.runtime = runtime;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		public ArrayList<SeatNumVO> getSeatNumList() {
			return seatNumList;
		}
		public void setSeatNumList(ArrayList<SeatNumVO> seatNumList) {
			this.seatNumList = seatNumList;
		}
		
		
		
}
