package com.kosta.movie20.second.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kosta.movie20.model.common.DataSourceManager;
import com.kosta.movie20.model.vo.ReviewVO;

public class CommentDAO {
	private static CommentDAO dao=new CommentDAO();	
	private DataSource dataSource;
	private CommentDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static CommentDAO getInstance(){
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
	
	
	
	public ArrayList<CommentVO> commentList(String rNo) throws SQLException{
		ArrayList<CommentVO> cList = new ArrayList<CommentVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
	
			sql.append("select cNo,Content,writeTime,id,rNo from ");
			sql.append(" semi_comment ");						
			sql.append(" where rNo=? ");
			sql.append(" ORDER BY cNo DESC ");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setInt(1,Integer.parseInt(rNo));
			
			rs=pstmt.executeQuery();	
			//목록에서 게시물 content는 필요없으므로 null로 setting
			//select no,title,time_posted,hits,id,name
			while(rs.next()){		
				CommentVO cvo=new CommentVO();
				cvo.setCno(rs.getString(1));
				cvo.setContent(rs.getString(2));
				cvo.setWritetime(rs.getString(3));
				cvo.setId(rs.getString(4));
				cvo.setRno(rs.getString(5));
							
				cList.add(cvo);
						
			}
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return cList;
	}
	
	public void commentWrite(CommentVO cvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into semi_comment(cno,content,writetime,id,rno) ");
			sql.append(" values(semi_review_seq.nextval,?,sysdate,?,?) ");			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1,cvo.getContent());			
			pstmt.setString(2,cvo.getId());
			pstmt.setInt(3, Integer.parseInt(cvo.getRno()));
			pstmt.executeUpdate();
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
	}
	
	public void commentDelete(String cNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			
			String sql;
			sql="delete from semi_comment where cNo=?";
						
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1,Integer.parseInt(cNo));
			pstmt.executeUpdate();
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
	}
	public void commentUpdate(CommentVO cvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		try {
			con = dataSource.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" update semi_comment set ");
			sql.append(" content=? where cNo=? ");			
			System.out.println(cvo.getCno()+" "+cvo.getContent());
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, cvo.getContent());
			pstmt.setInt(2, Integer.parseInt(cvo.getCno()));			
			pstmt.executeUpdate();
		}finally {
			closeAll(rs, pstmt, con);
		}
	}
}
