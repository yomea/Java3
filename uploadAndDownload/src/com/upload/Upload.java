package com.upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//location表示文件缓存的位置
@MultipartConfig(location="D:/temp")
//定义servlet访问方式，对应web.xml
@WebServlet(loadOnStartup = 1, initParams = { @WebInitParam(name = "test", value = "test") }, urlPatterns = "/test.do")
public class Upload extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String test = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		test = config.getInitParameter("test");
		System.out.println(test);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part = req.getPart("file");
		String info = part.getHeader("Content-Disposition");
		String fileName = info.substring(info.indexOf("filename=\"") + 10, info.lastIndexOf("\""));
		//System.out.println(fileName);
		//part.write(fileName);
		resp.setContentType("application/x-msdownload");
		resp.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		InputStream inputStream = part.getInputStream();
		byte[] buff = new byte[1024];
		OutputStream outputStream = resp.getOutputStream();
		while((inputStream.read(buff)) != -1) {
			outputStream.write(buff);
		}
		
	}

}
