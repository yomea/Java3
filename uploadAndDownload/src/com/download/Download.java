package com.download;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//loaction定义要保存文件的路径
@MultipartConfig(location="D:/temp")
@WebServlet(loadOnStartup = 1, initParams = { @WebInitParam(name = "test", value = "test") }, urlPatterns = "/download.do")
public class Download extends HttpServlet {

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
		System.out.println(fileName);
		part.write(fileName);
		
	}

}
