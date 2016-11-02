package com.freemark_web;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freeMark.bean.User;

@WebServlet(value="/freemark")
public class FreeMarkServlet extends HttpServlet {

	private static final long serialVersionUID = 297514503235697175L;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> users = new ArrayList<User>();
		
		for(int i = 0; i < 5; i++) {
			
			Calendar calendar = new GregorianCalendar(1994, 1, 18 + i);
			
			users.add(new User("youth" + i, 22 + i, calendar.getTime()));
			
			
		}
		
		request.setAttribute("users", users);
		//配置文件中要配置FreemarkServlet才能用	
		request.getRequestDispatcher("/WEB-INF/ftl/Test.ftlh").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
