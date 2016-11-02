package com.servletListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
	
	

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("我是tomcat，我被关闭了");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("我是tomcat，我启动啦！");

	}

}
