package com.org.entity;

public class Lawyer {

	private int  id ;
	private String fullName ;
	private String dob ;
	private String email ;
	private String mobNo ;
	private String password ;
	public Lawyer(String fullName, String dob, String email, String mobNo,
			String password) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
	}

	public Lawyer(int id, String fullName, String dob, String email,
			String mobNo, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
	}



	public Lawyer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
}
