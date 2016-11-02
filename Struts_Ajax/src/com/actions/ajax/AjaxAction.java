package com.actions.ajax;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxAction extends ActionSupport {

	private static final long serialVersionUID = -3574151734437301658L;
	
	@Override
	public String execute() throws Exception {
		
		return "world";
		
	}

}
