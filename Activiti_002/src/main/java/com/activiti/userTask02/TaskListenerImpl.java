package com.activiti.userTask02;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class TaskListenerImpl implements TaskListener {

	private static final long serialVersionUID = 1L;

	public void notify(DelegateTask delegateTask) {
		
		delegateTask.setAssignee("赵敏");

	}

}
