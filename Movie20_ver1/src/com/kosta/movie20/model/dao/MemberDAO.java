package com.kosta.movie20.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.kosta.movie20.model.common.DataSourceManager;
import com.kosta.movie20.model.vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance=new MemberDAO();
	private DataSource dataSource;
	//외부에서 생성못하게 private 처리 
	private MemberDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
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
		return dataSource.getConnection();
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
