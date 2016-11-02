package com.json.bean;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

public class User {
	
	private String username;
	
	private int age;
	
	private Date date;
	
	public User() {}
	
	public User(String username, int age, Date date) {
		this.username = username;
		this.age = age;
		this.date = date;
		
	}
	
	@JSON(name="name")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JSON(serialize=false)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@JSON(format="yyyy-MM-dd")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
