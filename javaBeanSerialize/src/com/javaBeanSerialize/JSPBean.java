package com.javaBeanSerialize;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class JSPBean implements Serializable {
	
	private static final long serialVersionUID = -7534999257710537273L;
	
	private String name;
	private String introduct;
	
	public JSPBean(String name, String introduct) {
		this.name = name;
		this.introduct = introduct;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduct() {
		return introduct;
	}
	public void setIntroduct(String introduct) {
		this.introduct = introduct;
	}
	
	public static void main(String[] args) {
		try {
			FileOutputStream out = new FileOutputStream("myJavaBean.ser");
			ObjectOutputStream obj = new ObjectOutputStream(out);
			obj.writeObject(new JSPBean("youth", "niu"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
