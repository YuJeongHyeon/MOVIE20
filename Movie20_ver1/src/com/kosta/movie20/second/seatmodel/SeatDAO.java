package com.kosta.movie20.second.seatmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kosta.movie20.model.common.DataSourceManager;
import com.kosta.movie20.model.common.NoticePagingBean;
import com.kosta.movie20.model.dao.MasterDAO;
import com.kosta.movie20.model.vo.MemberVO;
import com.kosta.movie20.model.vo.MovieVO;
import com.kosta.movie20.model.vo.NoticeVO;

public class SeatDAO {
	private static SeatDAO seatDAO = new SeatDAO();
	private DataSource dataSource;
	
	private SeatDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}// con

	public static SeatDAO getInstance() {
		return seatDAO;
	}// getInstance
	
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}//getConnection
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}// closeAll

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(pstmt, con);
	}// closeAll

/////////////////////////////////////////////////////////////////////////////////////////////////2차 코드 작성////////////////////	
	public void meetingRegister(String meetingDate, int mNo, String location) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into SEMI_MEETING(meetingDate, mNo,location) values(?,?,?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, meetingDate);
			pstmt.setInt(2, mNo);
			pstmt.setString(3, location);
			pstmt.executeUpdate();
	
		} finally {
			closeAll( pstmt, con);
		}
	}//meetingRegister
	public ArrayList<MeetingVO> getMeetingListInfo() throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MeetingVO> list = new ArrayList<MeetingVO>();
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select me.meetingDate, me.location, mv.mNo, mv.title, mv.runtime, mv.picture ");
			sql.append("FROM SEMI_MEETING me, SEMI_MOVIE mv  ");
			sql.append("WHERE me.mNo = mv.mNo ");
			
			pstmt = con.prepareStatement(sql.toString());
		
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MeetingVO mevo = new MeetingVO();
				mevo.setMeetingDate(rs.getString(1));
				mevo.setLocation(rs.getString(2));
				mevo.setmNo(rs.getString(3));
				mevo.setTitle(rs.getString(4));
				mevo.setRuntime(rs.getString(5));
				mevo.setPicture(rs.getString(6));
				list.add(mevo);
			}
	
		} finally {
			closeAll( rs,pstmt, con);
		}
		return list;
	}//meetingRegister
	public MeetingVO meetingInfoByDate(String meetingDate) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MeetingVO mvo= null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from SEMI_MEETING WHERE meetingDate = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, meetingDate);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mvo = new MeetingVO();
				mvo.setMeetingDate(rs.getString(1));
				mvo.setmNo(rs.getString(2));
				mvo.setLocation(rs.getString(3));
				
			}
			
		} finally {
			closeAll( pstmt, con);
		}
		return mvo;
	}//meetingInfoByDate
	public void seatReservationById(String meetingDate,String seatNum, String id) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("insert into semi_seat(meetingdate,seatNum,id) ");
			sql.append("values(?,?,?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, meetingDate);
			pstmt.setString(2, seatNum);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
			
		} finally {
			closeAll( pstmt, con);
		}

	}//seatReservationById
	public void updateSeatReservationById(String id, String seatNum, String meetingDate) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("update semi_seat set seatNum = ?  ");
			sql.append("WHERE meetingdate = ? and id = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, seatNum);
			pstmt.setString(2, meetingDate);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
			
		} finally {
			closeAll( pstmt, con);
		}

	}//updateSeatReservationById
	public String getSeatNumById(String id, String meetingDate) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String seatNum=null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select seatNum from semi_seat WHERE meetingDate =? and id=?");

			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, meetingDate);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				seatNum = rs.getString(1);
			}

		} finally {
			closeAll(rs,  pstmt, con);
		}
		return seatNum;
	}//updateSeatReservationById
	
	public void deleteSeatReservation(String id, String seatNum, String meetingDate) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("delete semi_seat ");
			sql.append("WHERE id=? and meetingDate = ? and seatNum = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, meetingDate);
			pstmt.setString(3, seatNum);
			pstmt.executeUpdate();
			
		} finally {
			closeAll( pstmt, con);
		}

	}//updateSeatReservationById
}
