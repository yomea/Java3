package com.json.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.json.bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class JsonAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = -441711631477466535L;
	
	private User user = new User();
	
	private List<User> list = new ArrayList<User>();
	
	@Override
	public String execute() throws Exception {
		return "world";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getList() {
		list.add(new User("youth", 22, new Date()));
		list.add(new User("hong", 22, new Date()));
		list.add(new User("yomea", 22, new Date()));
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
	
	
	

}
