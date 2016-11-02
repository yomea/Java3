package com.freeMark.bean;

import java.util.Date;

public class User {
	
	private String username;
	
	private int age;
	
	private Date date;
	
	public User(String username, int age, Date date) {
		
		this.username  = username;
		this.age = age;
		this.date = date;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
