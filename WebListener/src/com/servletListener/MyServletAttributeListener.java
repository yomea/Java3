package com.servletListener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("往application中增加属性");

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("往application中移除属性");

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("往application中替换属性");

	}

}
