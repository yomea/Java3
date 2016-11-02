package com.freemark_web;

import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freeMark.bean.User;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

@WebServlet(value="/freemark")
public class FreeMarkServlet extends HttpServlet {

	private static final long serialVersionUID = 297514503235697175L;
	
	private Configuration cfg = null;
	
	@Override
	public void init() throws ServletException {
		
		cfg = new Configuration(Configuration.VERSION_2_3_25);

	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Calendar calendar = new GregorianCalendar(1994, 1, 18);
		
		User user = new User("youth", 22, calendar.getTime());
		
		try {
			//设置模板的地址
			//cfg.setDirectoryForTemplateLoading(new File("src/ftl"));
			cfg.setServletContextForTemplateLoading(request.getServletContext(), "/WEB-INF/ftl/");
		

			cfg.setDefaultEncoding("UTF-8");
			//设置报错处理方式
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	
			cfg.setLogTemplateExceptions(false);
			//取得模板
			Template temp = cfg.getTemplate("Test.ftlh");
			
			Writer out = response.getWriter();
			//设置模型数据
			temp.process(user, out);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
