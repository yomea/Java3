package com.pinglun.util;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URL;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerUtil {
	/**
	 * 
	 * @param type
	 * @param path
	 * @param filename
	 * @return
	 */
	public static String freemarker(Object obj, URI path, String filename) {
		StringWriter out = null;
		try {
					Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
	
					cfg.setDirectoryForTemplateLoading(new File(path));
					//cfg.setTemplateLoader(new ClassTemplateLoader(clazz, ""));
					cfg.setDefaultEncoding("UTF-8");
	
					cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
					
					cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_25));
					cfg.setLogTemplateExceptions(false);
					
				
					Template temp = cfg.getTemplate(filename);
					
//					Writer out = new OutputStreamWriter(System.out);
					
					out = new StringWriter();
					
					temp.process(obj, out);
					
//					System.out.println(out);
				} catch (Exception e) {
					e.printStackTrace();
				}

		return out.toString();
	}
	
}
