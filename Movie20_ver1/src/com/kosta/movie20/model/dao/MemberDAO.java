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
		MemberVO vo = null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {	
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name, authority from semi_member where id=? and password=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setAuthority(rs.getString("authority"));
			}
			
		}finally{
			closeAll(rs, pstmt, con);
		}
		
		return vo;
		
	}
	public void registerMember(MemberVO mvo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {	
			con=getConnection();
			String sql="insert into semi_member(id,name,password,nick,address,birth,tel,favoriteGenre,authority) values(?,?,?,?,?,?,?,?,'일반')";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getName());
			pstmt.setString(3, mvo.getPassword());
			pstmt.setString(4, mvo.getNick());
			pstmt.setString(5, mvo.getAddress());
			pstmt.setString(6, mvo.getBirthday());
			pstmt.setString(7, mvo.getTel());
			pstmt.setString(8, mvo.getFavoriteGenre());
			pstmt.executeUpdate();
		}finally{
			closeAll(pstmt, con);
		}
		
		
	}
	public int checkDuplicateId(String id) throws SQLException {
		int check = 0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {	
			con=getConnection();
			String sql="select count(*) from semi_member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()&&rs.getInt(1)==1) {
				check=1;
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return check;
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
