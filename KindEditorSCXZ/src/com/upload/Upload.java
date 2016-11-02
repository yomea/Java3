package com.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(location = "D:\\newworkspace20160818\\KindEditorSCXZ\\WebContent\\images")
@WebServlet(urlPatterns = "/uploadImg")
public class Upload extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	Collection<Part> parts = req.getParts();
		/**
		 * 由于富文本是使用多次请求进行上传操作的，所以不存在一次请求有多个文件同时上传的问题
		 */
		String filename = "";
		//富文本上传时的文件域名
		Part part = req.getPart("imgFile");
		String info = part.getHeader("Content-Disposition");
		System.out.println(info);
		filename = info.substring(info.indexOf("filename=\"") + 10, info.lastIndexOf("\""));
		/*for (Part part : parts) {
			String info = part.getHeader("Content-Disposition");
			filename = info.substring(info.indexOf("filename=\"" + 10), info.lastIndexOf("\""));
			part.write(filename);
		}*/
		part.write(filename);
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.write("{\"error\":0, \"url\":\"/KindEditorSCXZ/images/" + filename + "\"}");
	}

}
