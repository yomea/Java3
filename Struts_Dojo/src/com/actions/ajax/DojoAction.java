package com.actions.ajax;

import com.opensymphony.xwork2.ActionSupport;

public class DojoAction extends ActionSupport {

	private static final long serialVersionUID = -3574151734437301658L;
	
	public String test(){
		
		return "input";
		
	}
	
	public String hello(){
		
		return "world";
		
	}

}
