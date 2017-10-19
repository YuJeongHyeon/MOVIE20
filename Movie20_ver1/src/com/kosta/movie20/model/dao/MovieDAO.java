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
import com.kosta.movie20.second.score.model.ScoreDAO;


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
				// 영화 전체 평점 평균값 세팅
				mvo.setAverageScore(ScoreDAO.getInstance().averageScore(rs.getString(1)));
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
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("select mNo,title,playdate,character,director,genre,  ");
			sql.append("summary,runtime,viewingcheck,hits,grade,picture ");	
			sql.append("from semi_movie ");			
			sql.append("where mNo=? ");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setInt(1,Integer.parseInt(mNo));
			
			rs=pstmt.executeQuery();	
			//목록에서 게시물 content는 필요없으므로 null로 setting
			//select no,title,time_posted,hits,id,name
			while(rs.next()){	
				mvo=new MovieVO();
				mvo.setmNo(rs.getString(1));
				mvo.setTitle(rs.getString(2));
				mvo.setPlaydate(rs.getString(3));
				mvo.setCharacter(rs.getString(4));
				mvo.setDirector(rs.getString(5));
				mvo.setGenre(rs.getString(6));	
				mvo.setSummary(rs.getString(7));	
				mvo.setRuntime(rs.getString(8));	
				mvo.setViewingcheck(rs.getString(9));	
				mvo.setHits(rs.getInt(10));	
				mvo.setGrade(rs.getInt(11));	
				mvo.setPicture(rs.getString(12));
				// 영화 전체 평점 평균값 세팅
				mvo.setAverageScore(ScoreDAO.getInstance().averageScore(rs.getString(1)));
			}			
		}finally {
			closeAll(rs, pstmt, con);
		}
		return mvo;
	}
	public int getReviewListcount(String movieNo) throws SQLException {
		int num=0;		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql="select count(*) from semi_review where mno=?";			
			pstmt=con.prepareStatement(sql);	
			pstmt.setInt(1,Integer.parseInt(movieNo));
			
			
			rs=pstmt.executeQuery();		
			if(rs.next()){
				num=rs.getInt(1);
			}
			//System.out.println("dao getContent:"+bvo);
		}finally{
			closeAll(rs,pstmt,con);
		}
		return num;
	}
	public ArrayList<ReviewVO> movieReviewList(String mNo, PagingBean pb) throws SQLException{
		ArrayList<ReviewVO> rList = new ArrayList<ReviewVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
	
			sql.append("select * from(select row_number() over(order by rNo desc) ");
			sql.append(" as rnum,rNo,content,regdate,title,hits,mno,id ");
			sql.append(" from semi_review where mno=?) ");			
			sql.append(" where mno=? and rnum between ? and ? ");
			sql.append(" ORDER BY rNo DESC ");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setInt(1,Integer.parseInt(mNo));
			pstmt.setInt(2,Integer.parseInt(mNo));
			pstmt.setInt(3,pb.getStartRowNumber());
			pstmt.setInt(4,pb.getEndRowNumber());
			rs=pstmt.executeQuery();	
			//목록에서 게시물 content는 필요없으므로 null로 setting
			//select no,title,time_posted,hits,id,name
			while(rs.next()){		
				ReviewVO rvo=new ReviewVO();
				rvo.setRno(rs.getString(1));
				rvo.setContent(rs.getString(3));
				rvo.setRegdate(rs.getString(4));
				rvo.setTitle(rs.getString(5));
				rvo.setHits(rs.getInt(6));
				rvo.setId(rs.getString(8));				
				
				rList.add(rvo);			
			}
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return rList;
	}
	@SuppressWarnings("null")
	public ReviewVO movieReviewDetail(String rNo) throws SQLException {
		ReviewVO rvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("select rno,title,content,regdate,hits,mno,id  ");	
			sql.append("from semi_review ");			
			sql.append("where rNo=? ");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setInt(1,Integer.parseInt(rNo));
			
			rs=pstmt.executeQuery();	
			
			while(rs.next()){	
				rvo = new ReviewVO();
				rvo.setRno(Integer.toString(rs.getInt(1)));
				rvo.setTitle(rs.getString(2));
				rvo.setContent(rs.getString(3));
				rvo.setRegdate(rs.getString(4));
				rvo.setHits(rs.getInt(5));
				rvo.setMno(rs.getString(6));	
				rvo.setId(rs.getString(7));	
				
				
			}			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return rvo;
	}
	public ArrayList<MovieVO> genreList(String genre,MoviePagingBean mpb) throws SQLException{
		ArrayList<MovieVO> mList = new ArrayList<MovieVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT mNo,picture,genre,hits ");
			sql.append("from (select row_number() over(order by mNo desc) as rnum,mNo,picture,genre,hits from SEMI_MOVIE where genre=?) ");
			sql.append("SEMI_MOVIE ");
			sql.append("where rnum between ? and ? ");
			sql.append("ORDER BY mNo DESC");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setString(1, genre);
			pstmt.setInt(2, mpb.getStartRowNumber());
			pstmt.setInt(3, mpb.getEndRowNumber());
			rs=pstmt.executeQuery();
			while(rs.next()){		
				MovieVO mvo=new MovieVO();
				mvo.setmNo(rs.getString(1));
				mvo.setPicture(rs.getString(2));
				mvo.setGenre(rs.getString(3));
				mvo.setHits(rs.getInt(4));
				// 영화 전체 평점 평균값 세팅
				mvo.setAverageScore(ScoreDAO.getInstance().averageScore(rs.getString(1)));
				mList.add(mvo);
			}		
		}finally {
			closeAll(rs, pstmt, con);
		}
		return mList;
	}
	public int getPostCountByGenre(String genre) throws SQLException {
		int tpc = 0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con = dataSource.getConnection();
			String sql = "select count(*) from semi_movie where genre=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, genre);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tpc = rs.getInt(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return tpc;
	}
	public void reviewWrite(ReviewVO rvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("insert into semi_review(rno,title,content,regdate,mno,id)");
			sql.append("values(semi_review_seq.nextval,?,?,sysdate,?,?)");			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, rvo.getTitle());
			pstmt.setString(2, rvo.getContent());
			pstmt.setString(3, rvo.getMno());
			pstmt.setString(4, rvo.getId());
			pstmt.executeUpdate();
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
	}
	public void reviewDelete(String rNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			
			String sql;
			sql="delete from semi_comment where rNo=?";
						
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1,Integer.parseInt(rNo));
			pstmt.executeUpdate();			
			pstmt.executeUpdate();
			
			String sql2;
			sql2="delete from semi_review where rNo=?";						
			pstmt2 = con.prepareStatement(sql2.toString());
			pstmt2.setInt(1,Integer.parseInt(rNo));
			pstmt2.executeUpdate();
			
			pstmt2.close();
		}finally {
			closeAll(rs, pstmt, con);
		}
	}
	public void reviewUpdate(ReviewVO rvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = dataSource.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" update semi_review set ");
			sql.append(" title=? ,content=? where rNo=? ");			
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, rvo.getTitle());
			pstmt.setString(2, rvo.getContent());
			pstmt.setInt(3, Integer.parseInt(rvo.getMno()));			
			pstmt.executeUpdate();
		}finally {
			closeAll(rs, pstmt, con);
		}
	}
	public ArrayList<MovieVO> searchMovieByName(String name, PagingBeanSearch pb) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MovieVO> movieList =  new ArrayList<MovieVO>();
		System.out.println("name: "+ name);
		System.out.println("pb: "+ pb.getStartRowNumber());
		System.out.println("pb: "+ pb.getEndRowNumber());
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * ");
			sql.append("from( ");
			sql.append("SELECT row_number() over(order by mNo desc) as rnum, ");
			sql.append("mNo, title, to_char(playdate,'YYYY.MM.DD') as playdate, character, director, genre, runtime, viewingcheck, grade, picture ");
			sql.append("FROM semi_movie ");
			sql.append("where title like ? ) ");
			sql.append("where rnum between ? and ?");
			sql.append("order by mNo desc");
			String temp = "%"+name+"%";
			System.out.println("temp: "+temp);
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, temp);
			pstmt.setInt(2, pb.getStartRowNumber());
			pstmt.setInt(3, pb.getEndRowNumber());
			
			
			
			rs = pstmt.executeQuery();
			while(rs.next()){
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
					System.out.println(mvo.toString());
			}
			System.out.println("movieList size: "+ movieList.size());
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
			// 171019 hit다hit에서 영화상세보기를 위해 mNo setting sql 수정
			sql.append("SELECT mNo, hits, picture ");
			sql.append("FROM (select row_number() over(order by mNo desc) as rnum,mNo,hits,picture from semi_movie ) semi_movie ");
			sql.append("WHERE rnum between ? and ? ");
			sql.append("ORDER BY hits desc");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, moviePagingBean.getStartRowNumber());
			pstmt.setInt(2, moviePagingBean.getEndRowNumber());
			rs = pstmt.executeQuery();
			while(rs.next()){
				MovieVO mvo = new MovieVO();
				// 171019 hit다hit에서 영화상세보기를 위해 mNo setting 코딩 수정
				mvo.setmNo(rs.getString(1));
				mvo.setHits(rs.getInt(2));
				mvo.setPicture(rs.getString(3));
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
	public void movieHitsup(String mNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" update semi_movie set ");
			sql.append(" hits=hits+1  where mNo=? ");			
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, Integer.parseInt(mNo));
			pstmt.executeUpdate();			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
	}
	public void reviewHitsup(String rNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" update semi_review set ");
			sql.append(" hits=hits+1  where rNo=? ");			
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, Integer.parseInt(rNo));
			pstmt.executeUpdate();		
			
		}finally {
			closeAll(rs, pstmt, con);
		}
	}
}
