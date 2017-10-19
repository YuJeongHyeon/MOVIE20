package com.kosta.movie20.second.score.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.kosta.movie20.model.common.DataSourceManager;

public class ScoreDAO {
	private static ScoreDAO masterDAO = new ScoreDAO();
	private DataSource dataSource;
	
	private ScoreDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}// con

	public static ScoreDAO getInstance() {
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
	
	 @SuppressWarnings("null")
	public ScoreVO getCheckScore(int mNo ,String id) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ScoreVO svo = new ScoreVO();
		try{
			con = dataSource.getConnection();
			String sql = "select score from SEMI_SCORE where mNo=? and id=? ";
			pstmt = con.prepareStatement(sql);
			System.out.println(mNo+"+"+id);
			pstmt.setInt(1, mNo);
			pstmt.setString(2, id);
			rs=pstmt.executeQuery();
			svo.setmNo(Integer.toString(mNo));
			svo.setId(id);
			if(rs.next()) {
		//		svo=new ScoreVO();
				svo.setScore(rs.getInt(1));
		//		System.out.println("!!"+rs.getInt(1));
			}else {
		//		System.out.println("!?????");
			}
				
		}finally {
			closeAll(rs, pstmt, con);
		}
		 
		 return svo;
	 }//checkScore
	 public void registerScroreTable(ScoreVO svo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
	//	ScoreVO svo = new ScoreVO();
		try{
			con = dataSource.getConnection();
			String sql = "insert into SEMI_SCORE(mNo,id) values(?,?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(svo.getmNo()));
			pstmt.setString(2, svo.getId());
			pstmt.executeUpdate();
			
		}finally {
			closeAll( pstmt, con);
		}
		 
	 }//registerScroreTable
	 public void registerScore(ScoreVO svo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
	//	ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "update SEMI_SCORE set score=? where mNo=? and id=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, svo.getScore());
			pstmt.setInt(2, Integer.parseInt(svo.getmNo()));
			pstmt.setString(3, svo.getId());
	//		rs = pstmt.executeQuery();
			pstmt.executeUpdate();
			
			 
		}finally {
		//	 closeAll(rs, pstmt, con);
			 closeAll(pstmt, con);
		}
	//	return svo;
	 }
	 public int getAverageScore(String mNo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int averageScore = 0;
		try {
			con = dataSource.getConnection();
			String totalScoreSql="select score from SEMI_SCORE where mNo=? and score!=-1";
			pstmt = con.prepareStatement(totalScoreSql);
			pstmt.setInt(1, Integer.parseInt(mNo));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				averageScore+=rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			String averageSql = "select count(score) from SEMI_SCORE where mNo=? and score!=-1";
			pstmt=con.prepareStatement(averageSql);
			pstmt.setInt(1, Integer.parseInt(mNo));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)!=0) {
				averageScore=averageScore/rs.getInt(1);
				}else {
					averageScore=0;
				}
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		 
		 
		 return averageScore;
	 }//averageScore
	 
	
	

}
