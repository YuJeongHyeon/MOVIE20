package com.kosta.movie20.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kosta.movie20.model.common.DataSourceManager;
import com.kosta.movie20.model.common.PagingBean;
import com.kosta.movie20.model.vo.MovieVO;
import com.kosta.movie20.model.vo.ReviewVO;


public class MovieDAO {
	private static MovieDAO dao=new MovieDAO();	
	private DataSource dataSource;
	private MovieDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static MovieDAO getInstance(){
		return dao;
	}
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close(); 
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		closeAll(pstmt,con);
	}	
	public ArrayList<MovieVO> movieList() throws SQLException{
		ArrayList<MovieVO> mList = new ArrayList<MovieVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		
		return mList;
	}
	public MovieVO movieDetail(String mNo) throws SQLException {
		MovieVO mvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return mvo;
	}
	public ArrayList<ReviewVO> movieReviewList(String mNo, PagingBean pb) throws SQLException{
		ArrayList<ReviewVO> rList = new ArrayList<ReviewVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return rList;
	}
	public ReviewVO movieReviewDetail(String rNo) throws SQLException {
		ReviewVO rvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		return rvo;
	}
	public ArrayList<MovieVO> genreList(String genre, PagingBean pb) throws SQLException{
		ArrayList<MovieVO> mList = new ArrayList<MovieVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return mList;
	}
	public void reviewWrite(ReviewVO rvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
	}
	public void reviewDelete(String rNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
	}
	public void reviewUpdate(String rNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
	}
	public ArrayList<MovieVO> searchMovieByName(String name) throws SQLException{
		ArrayList<MovieVO> mList = new ArrayList<MovieVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return mList;
	}
	public ArrayList<MovieVO> hitDaHit() throws SQLException{
		ArrayList<MovieVO> mList = new ArrayList<MovieVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return mList;
	}
	public ArrayList<MovieVO> addClickList(String mNo) throws SQLException{
		ArrayList<MovieVO> mList = new ArrayList<MovieVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return mList;
	}
	
	
	
	

}
