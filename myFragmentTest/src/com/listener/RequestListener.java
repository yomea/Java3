package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("请求结束！");

	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		ServletContext application = event.getServletContext();
		Integer count = (Integer) application.getAttribute("count");
		if(null == count) {
			count = 0;
			application.setAttribute("count", count + 1);
		} else {
			application.setAttribute("count", count + 1);
		}
		
		System.out.println("请求的次数为：" + (count + 1));

	}

}
