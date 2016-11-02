package com.httpWapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.sun.xml.internal.txw2.IllegalAnnotationException;

public class MyHttpResponseWapper extends HttpServletResponseWrapper {
	
	private OutputStream outputStream;
	
	private PrintWriter printWriter;

	public MyHttpResponseWapper(HttpServletResponse response) {
		super(response);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if(printWriter != null) {
			throw new IllegalStateException();
		}
		return super.getOutputStream();
		
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return super.getWriter();
	}
	
	

}
