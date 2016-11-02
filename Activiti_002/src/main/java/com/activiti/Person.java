package com.activiti;

import java.io.Serializable;

public class Person implements Serializable {
	
	
	private static final long serialVersionUID = -2398326441351083175L;

	private String username;
	
	private int age;

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
	
	

}
