package com.kosta.movie20.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kosta.movie20.model.common.DataSourceManager;
import com.kosta.movie20.model.common.MoviePagingBean;
import com.kosta.movie20.model.common.PagingBean;
import com.kosta.movie20.model.common.PagingBeanSearch;
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
	public ArrayList<MovieVO> movieList(MoviePagingBean mpb) throws SQLException{
		ArrayList<MovieVO> mList = new ArrayList<MovieVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT mNo,picture ");
			sql.append("from (select row_number() over(order by mNo desc) as rnum,mNo,picture from SEMI_MOVIE) ");
			sql.append("SEMI_MOVIE ");
			sql.append("where rnum between ? and ? ");
			sql.append("ORDER BY mNo DESC");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setInt(1, mpb.getStartRowNumber());
			pstmt.setInt(2, mpb.getEndRowNumber());
			rs=pstmt.executeQuery();
			while(rs.next()){		
				MovieVO mvo=new MovieVO();
				mvo.setmNo(rs.getString(1));
				mvo.setPicture(rs.getString(2));
				mList.add(mvo);
			}		
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
	public ArrayList<MovieVO> searchMovieByName(String name, PagingBeanSearch pb) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MovieVO> movieList =  new ArrayList<MovieVO>();
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select *  ");
			sql.append("from( ");
			sql.append("SELECT	row_number() over(order by mNo desc) as rnum, ");
			sql.append("mNo, title, playdate, character, director, genre, runtime, viewingcheck, grade, picture  ");
			sql.append("FROM semi_movie   ");
			sql.append(") ");
			sql.append("where title like ?  and  rnum between ? and ?  ");
			sql.append("order by mNo desc ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%"+name+"%");
			pstmt.setInt(2, pb.getStartRowNumber());
			pstmt.setInt(3, pb.getEndRowNumber());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
					MovieVO mvo = new MovieVO();
					mvo.setmNo(rs.getString("mNo"));
					mvo.setTitle(rs.getString("title"));
					mvo.setPlaydate(rs.getString("playdate"));
					mvo.setCharacter( rs.getString("character"));
					mvo.setDirector(rs.getString("director"));
					mvo.setGenre( rs.getString("genre"));
					mvo.setRuntime(rs.getString("runtime"));
					mvo.setViewingcheck(rs.getString("viewingcheck"));
					mvo.setGrade(rs.getInt("grade"));
					mvo.setPicture(rs.getString("picture"));
					movieList.add(mvo);
			}
			
		} finally {
			closeAll(rs, pstmt, con);
		}
		return movieList;

	}
	public int getTotalSearchMovieCount(String name) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=-1;
		try{
			con=getConnection(); 
			String sql="select count(*) from SEMI_MOVIE where title like ? ";
			pstmt=con.prepareStatement(sql);	
			pstmt.setString(1, "%"+name+"%");
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return count;
	}
	public ArrayList<MovieVO> hitDaHit(MoviePagingBean moviePagingBean) throws SQLException{
		ArrayList<MovieVO> mList = new ArrayList<MovieVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT hits, picture ");
			sql.append("FROM (select row_number() over(order by mNo desc) as rnum,hits,picture from semi_movie ) semi_movie ");
			sql.append("WHERE rnum between ? and ? ");
			sql.append("ORDER BY hits desc");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, moviePagingBean.getStartRowNumber());
			pstmt.setInt(2, moviePagingBean.getEndRowNumber());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				MovieVO mvo = new MovieVO();
				mvo.setHits(rs.getInt(1));
				mvo.setPicture(rs.getString(2));
				mList.add(mvo);
			}
			
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
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////
	public int getTotalPostCount() throws SQLException {
		int tpc = 0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con = dataSource.getConnection();
			String sql = "select count(*) from semi_movie";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tpc = rs.getInt(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return tpc;
	}

}
