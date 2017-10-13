package com.kosta.movie20.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kosta.movie20.model.vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance=new MemberDAO();
	//외부에서 생성못하게 private 처리 
	private MemberDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	//외부에 현 객체레퍼런스를 공유 
	public static MemberDAO getInstance(){
		return instance;
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		closeAll(null, pstmt,con);
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,
			Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","scott","tiger");
	}
	
	public MemberVO login(MemberVO mvo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {	
			
		}finally{
			closeAll(rs, pstmt, con);
		}
		
		return null;
		
	}
	public void registerMember(MemberVO mvo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {	
			
		}finally{
			closeAll( pstmt, con);
		}
		
		
	}
	public int checkDuplicateId(String id) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {	
			
		}finally{
			closeAll(rs, pstmt, con);
		}
		return 0;
		
		
	}
	public void memberDelete(String id) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {	
			
		}finally{
			closeAll(pstmt, con);
		}
		
		
	}
	public void memberUpdate(String id) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {	
			
		}finally{
			closeAll(pstmt, con);
		}
		
		
	}
}
