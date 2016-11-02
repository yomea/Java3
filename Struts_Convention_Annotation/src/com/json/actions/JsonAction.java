package com.json.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.json.bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage(value="json-default")
/*@Action(value="/convention")
@Result(type="json", name="world")
@ResultPath(value="/WEB-INF/jsp")
@Result(location="json.jsp", name="world")
//会忽略@ResultPath(value="/WEB-INF/jsp")
@Result(location="/json.jsp", name="world")*/
@Results(value={
		@Result(type="json", name="world"),
		@Result(type="json", name="world")
		
})
public class JsonAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = -441711631477466535L;
	
	private User user = new User();
	
	@Actions(value={
			@Action(value="/convention", params={"username","youth","age","22"}),
			@Action(value="/hehe")
			
	})
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

	
	
	

}
