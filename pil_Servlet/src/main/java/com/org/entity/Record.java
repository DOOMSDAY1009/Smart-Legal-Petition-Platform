package com.org.entity;
public class Record {
	
	private int id;
	private int userId;
	private String fullName;
	private String gender;
	private String age;
	private String recordDate;
	private String email;
	private String phNo;
	private String title;
	private int lawyerId;
	private String text;
	private String status;
	
	public Record(int userId, String fullName, String gender, String age, String recordDate, String email,
			String phNo, String title, int lawyerId, String text, String status) {
		
		this.userId = userId;
		this.fullName = fullName;
		this.gender = gender;
		this.age = age;
		this.recordDate = recordDate;
		this.email = email;
		this.phNo = phNo;
		this.title = title;
		this.lawyerId = lawyerId;
		this.text = text;
		this.status = status;
	}

	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getrecordDate() {
		return recordDate;
	}

	public void setrecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public int getLawyerId() {
		return lawyerId;
	}

	public void setLawyerId(int lawyerId) {
		this.lawyerId = lawyerId;
	}

	public String gettext() {
		return text;
	}

	public void settext(String text) {
		this.text = text;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}


