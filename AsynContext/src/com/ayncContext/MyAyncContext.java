package com.ayncContext;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="*.do", asyncSupported=true)
public class MyAyncContext extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AsyncContext asyncContext = req.startAsync();
		new Thread(new MyThread(asyncContext)).start();
		System.out.println(asyncContext);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	private class MyThread implements Runnable{
		
		AsyncContext context = null;
		
		public MyThread(AsyncContext context) {
			this.context = context;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(10000);
				System.out.println(context);
				context.getResponse().getWriter().write("<h1 align='center'>hello world!</h1>");
				context.complete();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	

}
