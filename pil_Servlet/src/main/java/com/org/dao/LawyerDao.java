package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.org.entity.Lawyer;
import com.org.helper.ConnectionHelper;

public class LawyerDao {

	private Connection con = ConnectionHelper.getConObj() ;
	
	public boolean registerLawyer(Lawyer d) {
		boolean f = false ;
		
		try {
			String sql = "INSERT INTO lawyer(full_name , dob , email ,mobno , password) VALUES(? , ? , ? , ? , ?)" ;
			PreparedStatement ps = con.prepareStatement(sql) ;
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getEmail());
			ps.setString(4, d.getMobNo());
			ps.setString(5, d.getPassword());
			
			int i = ps.executeUpdate() ;
			if(i==1) {
				f= true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return f ;
	}
	
	public List<Lawyer> getAllLawyers(){
		List<Lawyer> list = new ArrayList<Lawyer>() ;
		Lawyer d = null ;
		try {
			
			String sql = "select * from lawyer order by id desc" ;
			PreparedStatement ps = con.prepareStatement(sql) ;
			ResultSet rs = ps.executeQuery() ;
			
			while(rs.next()) {
				
				d = new Lawyer() ;
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setEmail(rs.getString(4));
				d.setMobNo(rs.getString(5));
				d.setPassword(rs.getString(6));
				list.add(d) ;
			}
			
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		
		return list ;
	}
	
	public Lawyer getLawyersById(int id){
		
		Lawyer d = null ;
		try {
			
			String sql = "select * from lawyer WHERE id = "+id ;
			PreparedStatement ps = con.prepareStatement(sql) ;
			ResultSet rs = ps.executeQuery() ;
			
			if(rs.next()) {
				
				d = new Lawyer() ;
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setEmail(rs.getString(4));
				d.setMobNo(rs.getString(5));
				d.setPassword(rs.getString(6));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		
		return d ;
	}
	
	public boolean updateLawyer(Lawyer d) {
		boolean f = false ;
		
		try {
			String sql = "update lawyer set full_name = ? , dob = ? , email = ? ,mobno = ? , password = ? where id = ?" ;
			PreparedStatement ps = con.prepareStatement(sql) ;
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getEmail());
			ps.setString(4, d.getMobNo());
			ps.setString(5, d.getPassword());
			ps.setInt(6, d.getId());
			
			int i = ps.executeUpdate() ;
			if(i==1) {
				f= true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return f ;
	}
	
	public boolean deleteLawyer(int id) {
		boolean  f = false ;
		
		try {
			String sql = "DELETE FROM lawyer WHERE id = "+id ;
			PreparedStatement ps = con.prepareStatement(sql) ;
			int i = ps.executeUpdate() ;
			if(i==1)
			{
				f = true  ;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f ;
	}
	
	public Lawyer login(String email , String password) {
		Lawyer d = null ;
		
		try {
			String sql = "SELECT * FROM lawyer WHERE email = ? AND password = ?" ;
			PreparedStatement ps = con.prepareStatement(sql) ;
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery() ;
			
			if(rs.next()) {
				d = new Lawyer() ;
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setEmail(rs.getString(4));
				d.setMobNo(rs.getString(5));
				d.setPassword(rs.getString(6));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	public int countLawyer() {
		int i = 0;
		try {
			String sql = "select * from lawyer";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countRecord() {
		int i = 0;
		try {
			String sql = "select * from record";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countRecordByDocotrId(int did) {
		int i = 0;
		try {
			String sql = "select * from record where lawyer_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countUSer() {
		int i = 0;
		try {
			String sql = "select * from user";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countSpecialist() {
		int i = 0;
		try {
			String sql = "select * from specialist";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public boolean checkOldPassword(int userid, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from lawyer where id=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean changePassword(int userid, String newPassword) {
		boolean f = false;

		try {
			String sql = "update lawyer set password=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean editLawyerProfile(Lawyer d) {
		boolean f = false;

		try {
			String sql = "update lawyer set full_name=?,dob=?,email=?,mobno=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getEmail());
			ps.setString(4, d.getMobNo());
			ps.setInt(5, d.getId());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	
}

	
	


