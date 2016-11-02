package com.freeMark;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.freeMark.bean.User;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkTest {
	
	public static void main(String[] args) {
		
		Calendar calendar = new GregorianCalendar(1994, 1, 18);
		
		User user = new User("youth", 22, calendar.getTime());
		
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);

		try {
			//设置模板的地址
			cfg.setDirectoryForTemplateLoading(new File("src/ftl"));
		

			cfg.setDefaultEncoding("UTF-8");
			//设置报错处理方式
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	
			cfg.setLogTemplateExceptions(false);
			//取得模板
			Template temp = cfg.getTemplate("Test.ftlh");
			
			Writer out = new OutputStreamWriter(System.out);
			//设置模型数据
			temp.process(user, out);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
