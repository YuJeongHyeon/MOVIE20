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

	public ArrayList<NoticeVO> noticeList() {
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {

		}

		return list;
	}// noticeList

	public void movieRegister(MovieVO mvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {

		}
	}// movieRegister

	public void movieDelete(String mNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {

		}
	}// movieDelete

	public void movieUpdate(String mNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {

		}
	}// movieUpdate

	public void noticeWrite(NoticeVO nvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {

		}
	}// noticeWrite

	public void noticeDelete(String nNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {

		}
	}// noticeDelete

	public void noticeUpdate(String nNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {

		}
	}// noticeUpdate
}