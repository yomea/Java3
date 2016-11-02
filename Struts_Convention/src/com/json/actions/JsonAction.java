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
	
	//零配置，引入convention包，默认在含actions，action，Struts，strut的包下查找action
	//还有Action结尾的类，实现了Action接口的类，它的url映射如com.json.actions.JsonAction
	//-->>/json
	
	@Override
	public String execute() throws Exception {
		return "world";
	}
	//http://localhost:8888/Struts_Convention/config-browser/actionNames.action
	//查看详细信息，包括URL和bean信息
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
