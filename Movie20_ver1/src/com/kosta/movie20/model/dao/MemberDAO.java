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
			sql.append("select id, name, authority, password from semi_member where id=? and password=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPassword());
			rs = pstmt.executeQuery();
			
			
			if(rs.next()){
				if(rs.getString("id").equals(mvo.getId()) && rs.getString("password").equals(mvo.getPassword()) ) {
					vo = new MemberVO();
					vo.setId(rs.getString("id"));
					vo.setName(rs.getString("name"));
					vo.setAuthority(rs.getString("authority"));
				}
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
	

	public MemberVO searchMember(String id) throws SQLException {
		MemberVO vo = null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {	
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id,name,password,nick,address,to_char(birth,'YYYY.MM.DD') as birth,tel,favoritegenre,authority from semi_member where id=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setNick(rs.getString("nick"));
				vo.setAddress(rs.getString("address"));
				vo.setBirthday(rs.getString("birth"));
				vo.setTel(rs.getString("tel"));
				vo.setFavoriteGenre(rs.getString("favoritegenre"));				
				vo.setAuthority(rs.getString("authority"));
			}
			
		}finally{
			closeAll(rs, pstmt, con);
		}
		
		return vo;		
		
	}
	public void updateMember(MemberVO membervo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = dataSource.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" update semi_member set ");
			sql.append(" name=?,password=?,nick=?,address=?,");
			sql.append(" tel=?,favoriteGenre=? where id=? ");			
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, membervo.getName());
			pstmt.setString(2, membervo.getPassword());
			pstmt.setString(3, membervo.getNick());	
			pstmt.setString(4, membervo.getAddress());	
			pstmt.setString(5, membervo.getTel());
			pstmt.setString(6, membervo.getFavoriteGenre());
			pstmt.setString(7, membervo.getId());
			pstmt.executeUpdate();
		}finally {
			closeAll(rs, pstmt, con);
		}
		
	}
}
