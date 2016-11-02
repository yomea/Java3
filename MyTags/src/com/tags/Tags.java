package com.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Tags extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		
		this.getJspBody().invoke(null);
		
	}

	
	

}
