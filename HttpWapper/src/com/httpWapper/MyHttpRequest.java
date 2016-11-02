package com.httpWapper;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpRequest extends HttpServletRequestWrapper {

	public MyHttpRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String result = null;
		try {
			result = new String(this.getRequest().getParameter(name).getBytes("ISO8859-1"),"UTF-8");
			//StringEcspUtil.ecspHtml(result);在commons-lang3包中定义
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}
