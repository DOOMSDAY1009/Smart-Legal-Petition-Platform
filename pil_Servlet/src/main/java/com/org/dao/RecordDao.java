package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.org.entity.Record;
import com.org.helper.ConnectionHelper;

public class RecordDao {

	private Connection con = ConnectionHelper.getConObj() ;
	
	public boolean addRecord(Record a) {
		boolean f = false ;
		
		try {
			
			String sql = "INSERT INTO record(user_id , fullname , gender , age , appoint_data , email , phno , title , lawyer_id , text , status) VALUES(?,?,?,?,?,?,?,?,?,?,?)" ;
			PreparedStatement ps = con.prepareStatement(sql) ;
			ps.setInt(1, a.getUserId());
			ps.setString(2, a.getFullName());
			ps.setString(3, a.getGender());
			ps.setString(4, a.getAge());
			ps.setString(5, a.getrecordDate());
			ps.setString(6, a.getEmail());
			ps.setString(7, a.getPhNo());
			ps.setString(8, a.gettitle());
			ps.setInt(9, a.getLawyerId());
			ps.setString(10, a.gettext());
			ps.setString(11, a.getStatus());
			
			int res = ps.executeUpdate() ;
			if(res==1) {
				f= true ;
			}
			
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		
		
		return f ;
	}
	
	public List<Record> getAllRecordByLoginUser(int userId) {
		List<Record> list = new ArrayList<Record>();
		Record ap = null;

		try {

			String sql = "select * from record where user_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Record();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setrecordDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.settitle(rs.getString(9));
				ap.setLawyerId(rs.getInt(10));
				ap.settext(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public List<Record> getAllRecordByLawyerLogin(int lawyerId) {
		List<Record> list = new ArrayList<Record>();
		Record ap = null;

		try {

			String sql = "select * from record where lawyer_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, lawyerId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Record();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setrecordDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.settitle(rs.getString(9));
				ap.setLawyerId(rs.getInt(10));
				ap.settext(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public List<Record> getAllRecordsForAllUsers(int id) {
	    List<Record> list = new ArrayList<Record>();
	    Record ap = null;

	    try {
	        // SQL query to fetch all records for all users
	        String sql = "SELECT * FROM record";
	        PreparedStatement ps = con.prepareStatement(sql);

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            ap = new Record();
	            ap.setId(rs.getInt(1));
	            ap.setUserId(rs.getInt(2));
	            ap.setFullName(rs.getString(3));
	            ap.setGender(rs.getString(4));
	            ap.setAge(rs.getString(5));
	            ap.setrecordDate(rs.getString(6));
	            ap.setEmail(rs.getString(7));
	            ap.setPhNo(rs.getString(8));
	            ap.settitle(rs.getString(9));
	            ap.setLawyerId(rs.getInt(10));
	            ap.settext(rs.getString(11));
	            ap.setStatus(rs.getString(12));
	            list.add(ap);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	public Record getRecordById(int id) {

		Record ap = null;

		try {

			String sql = "select * from record where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Record();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setrecordDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.settitle(rs.getString(9));
				ap.setLawyerId(rs.getInt(10));
				ap.settext(rs.getString(11));
				ap.setStatus(rs.getString(12));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ap;
	}

	public boolean updateCommentStatus(int id, int doctId, String comm) {
		boolean f = false;
		try {
			String sql = "update record set status=? where id=? and lawyer_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, comm);
			ps.setInt(2, id);
			ps.setInt(3, doctId);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Record> getAllRecord() {
		List<Record> list = new ArrayList<Record>();
		Record ap = null;

		try {

			String sql = "select * from record order by id desc";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Record();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setrecordDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.settitle(rs.getString(9));
				ap.setLawyerId(rs.getInt(10));
				ap.settext(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
	
