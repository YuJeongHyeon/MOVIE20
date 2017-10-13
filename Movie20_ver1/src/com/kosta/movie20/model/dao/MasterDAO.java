package com.kosta.movie20.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kosta.movie20.model.common.DataSourceManager;
import com.kosta.movie20.model.vo.MovieVO;
import com.kosta.movie20.model.vo.NoticeVO;


public class MasterDAO {
	private static MasterDAO masterDAO = new MasterDAO();
	private DataSource dataSource;
	
	private MasterDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}// con

	public static MasterDAO getInstance() {
		return masterDAO;
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

	public ArrayList<NoticeVO> noticeList() throws SQLException {
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {
			closeAll(rs, pstmt, con);
		}

		return list;
	}// noticeList

	public void movieRegister(MovieVO mvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {
			closeAll(rs, pstmt, con);
		}
	}// movieRegister

	public void movieDelete(String mNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {
			closeAll(rs, pstmt, con);
		}
	}// movieDelete

	public void movieUpdate(String mNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {
			closeAll(rs, pstmt, con);
		}
	}// movieUpdate

	public void noticeWrite(NoticeVO nvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {
			closeAll(rs, pstmt, con);
		}
	}// noticeWrite

	public void noticeDelete(String nNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {
			closeAll(rs, pstmt, con);
		}
	}// noticeDelete

	public void noticeUpdate(String nNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {
			closeAll(rs, pstmt, con);
		}
	}// noticeUpdate
}
