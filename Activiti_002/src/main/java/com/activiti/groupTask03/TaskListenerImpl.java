package com.activiti.groupTask03;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class TaskListenerImpl implements TaskListener {

	private static final long serialVersionUID = 1L;

	public void notify(DelegateTask delegateTask) {
		//通过当前用户的外键找到他的上司，从数据库取出来，设置个人任务的办理人
		delegateTask.addCandidateUser("郭靖");
		delegateTask.addCandidateUser("黄蓉");

	}

}
