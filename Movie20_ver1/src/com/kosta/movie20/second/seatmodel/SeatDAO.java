package com.kosta.movie20.second.seatmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kosta.movie20.model.common.DataSourceManager;
import com.kosta.movie20.model.common.NoticePagingBean;
import com.kosta.movie20.model.dao.MasterDAO;
import com.kosta.movie20.model.vo.MemberVO;
import com.kosta.movie20.model.vo.MovieVO;
import com.kosta.movie20.model.vo.NoticeVO;

public class SeatDAO {
	private static SeatDAO seatDAO = new SeatDAO();
	private DataSource dataSource;
	
	private SeatDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}// con

	public static SeatDAO getInstance() {
		return seatDAO;
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
	public int getTotalPostCount() throws SQLException {
		int tpc = 0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con = dataSource.getConnection();
			String sql = "select count(*) from semi_notice";
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
	// 후에 셀렉 컬럼 중 important 제거 
		public ArrayList<NoticeVO> ImportNoticeList() throws SQLException {
			ArrayList<NoticeVO> nList = new ArrayList<NoticeVO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				StringBuilder sql=new StringBuilder();
				sql.append("SELECT nNo,title,regdate,hits,important ");
				sql.append("from (select row_number() over(order by nNo desc) as rnum,nNo,title,regdate,hits,important from SEMI_NOTICE) SEMI_NOTICE ");
				sql.append("where important='중요' ");
				sql.append("ORDER BY nNo ASC");
				pstmt=con.prepareStatement(sql.toString());	
				rs=pstmt.executeQuery();
				while(rs.next()){		
					NoticeVO nvo = new NoticeVO();
					nvo.setnNo(rs.getString(1));
					nvo.setTitle(rs.getString(2));
					nvo.setRegdate(rs.getString(3));
					nvo.setHits(rs.getInt(4));
					nvo.setImportant(rs.getString(5));
					nList.add(nvo);
				}	
				
			}finally {
				closeAll(rs, pstmt, con);
			}

			return nList;
		}
		// 후에 셀렉 컬럼 중 important 제거 
		@SuppressWarnings("null")
		public ArrayList<NoticeVO> noticeList(NoticePagingBean npb) throws SQLException {
			ArrayList<NoticeVO> nList = new ArrayList<NoticeVO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				StringBuilder sql=new StringBuilder();
				sql.append("SELECT nNo,title,regdate,hits,important ");
				sql.append("from (select row_number() over(order by nNo desc) as rnum,nNo,title,regdate,hits,important from SEMI_NOTICE) SEMI_NOTICE ");
				sql.append("where rnum between ? and ? ");
				sql.append("ORDER BY nNo DESC");
				pstmt=con.prepareStatement(sql.toString());	
				pstmt.setInt(1, npb.getStartRowNumber());
				pstmt.setInt(2, npb.getEndRowNumber());
				rs=pstmt.executeQuery();
				while(rs.next()){		
					NoticeVO nvo = new NoticeVO();
					nvo.setnNo(rs.getString(1));
					nvo.setTitle(rs.getString(2));
					nvo.setRegdate(rs.getString(3));
					nvo.setHits(rs.getInt(4));
					nvo.setImportant(rs.getString(5));
					nList.add(nvo);
				}	
			} finally {
				closeAll(rs, pstmt, con);
			}

			return nList;
		}// noticeList

	public void movieRegister(MovieVO mvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {
			closeAll(rs, pstmt, con);
		}
	}// movieRegister

	public void movieDelete(String mNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {
			closeAll(rs, pstmt, con);
		}
	}// movieDelete
	public NoticeVO noticeDetail(String nNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeVO nvo = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT title,content,regdate,hits,important,id ");
			sql.append("from SEMI_NOTICE ");
			sql.append("where nNo=? ");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setString(1, nNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				nvo = new NoticeVO();
				nvo.setnNo(nNo);
				nvo.setTitle(rs.getString("title"));
				nvo.setContent(rs.getString("content"));
				nvo.setRegdate(rs.getString("regdate"));
				nvo.setHits(rs.getInt("hits"));
				nvo.setImportant(rs.getString("important"));
				nvo.setMasterId(rs.getString("id"));
			}
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		return nvo;
	}//noticeDetail
	public void updateHit(String nNo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con = dataSource.getConnection(); 
			String sql="update SEMI_NOTICE set hits=hits+1 where nNo=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, nNo);	
			pstmt.executeUpdate();			
		}finally{
			closeAll(pstmt,con);
		}
	}//updateHit
	public void movieUpdate(String mNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

		} finally {
			closeAll(rs, pstmt, con);
		}
	}// movieUpdate

	public NoticeVO noticeWrite(NoticeVO nvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int no = 0;
		try {
			con = dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("insert into SEMI_NOTICE(nNo,title,content,regdate,important,id) ");
			sql.append("values(SEMI_NOTICE_seq.nextval,?,?,sysdate,?,?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, nvo.getTitle());
			pstmt.setString(2, nvo.getContent());
			pstmt.setString(3, nvo.getImportant());
			pstmt.setString(4, nvo.getMasterId());
			pstmt.executeQuery();
			pstmt.close();
			pstmt=con.prepareStatement("select SEMI_NOTICE_seq.currval from dual");
			rs=pstmt.executeQuery();
			if(rs.next()) {
			no = rs.getInt(1);
			nvo.setnNo(Integer.toString(no));	
			System.out.println(no);
			}
			pstmt.close();
			rs.close();
			String sql2 = "select regdate,id from SEMI_NOTICE where nNo=?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				nvo.setRegdate(rs.getString(1));
				nvo.setMasterId(rs.getString(2));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return nvo;
	}// noticeWrite

	public void noticeDelete(String nNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("delete from SEMI_NOTICE ");
			sql.append("where nNo=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, nNo);
			pstmt.executeUpdate();
		} finally {
			closeAll( pstmt, con);
		}
	}// noticeDelete

	public void noticeUpdate(NoticeVO nvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("update SEMI_NOTICE ");
			sql.append("set title=? ,content=? ,id=? ,important=? where nNo=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, nvo.getTitle());
			pstmt.setString(2, nvo.getContent());
			pstmt.setString(3, nvo.getMasterId());
			pstmt.setString(4, nvo.getImportant());
			pstmt.setString(5, nvo.getnNo());
			pstmt.executeUpdate();
		} finally {
			closeAll( pstmt, con);
		}
	}// noticeUpdate
	
	public void updateMemberAuthorityById(String id ,String authority) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update semi_member set authority =? WHERE id=? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, authority);
			pstmt.setString(2, id);
			
			pstmt.executeUpdate();
	
			
		} finally {
			closeAll( pstmt, con);
		}
	}//reviseMemberAuthorityByName
	
	public MemberVO findMemberById(String id) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		MemberVO mvo = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT id, name, nick, address, to_char(birth,'YYYY.MM.DD') as birth, tel, favoriteGenre, authority ");
			sql.append("FROM semi_member ");
			sql.append("WHERE id=? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setName(rs.getString("name"));
				mvo.setNick(rs.getString("nick"));
				mvo.setAddress(rs.getString("address"));
				mvo.setBirthday(rs.getString("birth"));
				mvo.setTel(rs.getString("tel"));
				mvo.setFavoriteGenre(rs.getString("favoriteGenre"));
				mvo.setAuthority(rs.getString("authority"));
			}
			
		} finally {
			closeAll( rs, pstmt, con);
		}
		return mvo;
	}//findMemberById
	
	public void deleteMemberById(String id) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete semi_member WHERE id=? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);

			pstmt.executeUpdate();

		} finally {
			closeAll( pstmt, con);
		}
	}//deleteMemberById
/////////////////////////////////////////////////////////////////////////////////////////////////2차 코드 작성////////////////////	
	public void meetingRegister(String meetingDate, int mNo, String location) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into SEMI_MEETING(meetingDate, mNo,location) values(?,?,?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, meetingDate);
			pstmt.setInt(2, mNo);
			pstmt.setString(3, location);
			pstmt.executeUpdate();
	
		} finally {
			closeAll( pstmt, con);
		}
	}//meetingRegister
	public ArrayList<MeetingVO> getMeetingListInfo() throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MeetingVO> list = new ArrayList<MeetingVO>();
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select me.meetingDate, me.location, mv.mNo, mv.title, mv.runtime, mv.picture ");
			sql.append("FROM SEMI_MEETING me, SEMI_MOVIE mv  ");
			sql.append("WHERE me.mNo = mv.mNo ");
			
			pstmt = con.prepareStatement(sql.toString());
		
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MeetingVO mevo = new MeetingVO();
				mevo.setMeetingDate(rs.getString(1));
				mevo.setLocation(rs.getString(2));
				mevo.setmNo(rs.getString(3));
				mevo.setTitle(rs.getString(4));
				mevo.setRuntime(rs.getString(5));
				mevo.setPicture(rs.getString(6));
				list.add(mevo);
			}
	
		} finally {
			closeAll( rs,pstmt, con);
		}
		return list;
	}//meetingRegister
}
