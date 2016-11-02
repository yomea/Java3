package com.freemarker.actions;


import com.json.bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FreemarkerAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = -441711631477466535L;
	
	private User user = new User();
	
	
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

}
