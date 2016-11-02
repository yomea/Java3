package com.activiti;

import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

public class ProcessVariable {

	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void deployProcess() {

		InputStream inputStreambpmn = this.getClass().getResourceAsStream("/diagrams/processVariable.bpmn");
		InputStream inputStreampng = this.getClass().getResourceAsStream("/diagrams/processVariable.png");

		Deployment deployment = processEngine.getRepositoryService().createDeployment().name("ProcessVariable")
				.addInputStream("processVariable.bpmn", inputStreambpmn)
				.addInputStream("processVariable.png", inputStreampng).deploy();

		System.out.println(deployment.getName());

	}

	@Test
	public void startProcess() {

		ProcessInstance processInstance = processEngine.getRuntimeService()
				.startProcessInstanceByKey("processVariabel");

		processEngine.getRuntimeService().setProcessInstanceName(processInstance.getId(), "流程变量");

		System.out.println("流程实例id" + processInstance.getId());
		System.out.println("流程实例名" + processInstance.getName());

	}

	@Test
	public void setVariable() {
		
		String taskId = "45002";
		
		Person person = new Person();
		
		person.setUsername("home");
		person.setAge(10);
		
		TaskService taskService = processEngine.getTaskService();
//		taskService.setVariable(taskId, "请假天数", 3);
//		taskService.setVariableLocal(taskId, "回来", "带特产");
//		taskService.setVariable(taskId, "请假理由", "回家探亲");
		
		//这个person需要序列化，否则将不能再改变
		taskService.setVariable(taskId, "个人信息", person);
		
		System.out.println("设置成功！");
							  

	}
	
	@Test
	public void getVariable() {
		TaskService taskService = processEngine.getTaskService();
		
		String taskId = "37504";
		
		String string = (String) taskService.getVariable(taskId, "请假理由");
		
		System.out.println(string);
		
		
	}
	
	@Test
	public void setAnVariable() {
		
		RuntimeService runtimeService = processEngine.getRuntimeService();
		TaskService taskService = processEngine.getTaskService();
		
		
//		runtimeService.setVariable(executionId, variableName, value);//一次只能设置一个变量
//		runtimeService.setVariableLocal(executionId, variableName, value);//设置本地变量
//		runtimeService.setVariables(executionId, variables);//设置多个变量
		
//		taskService.setVariable(taskId, variableName, value);//使用任务id设置变量
//		taskService.setVariables(taskId, variables);
//		taskService.setVariableLocal(taskId, variableName, value);
//		taskService.setVariables(taskId, variables);
		
//		runtimeService.getVariable(executionId, variableName)//使用执行对象的id获取变量
//		runtimeService.getVariable(executionId, variableName, variableClass)//通过类型获取变量
//		runtimeService.getVariables(executionId, variableNames)//通过指定变量名获取变量
//		runtimeService.getVariables(executionId)//获取所有的变量
		
		
//		taskService.getVariable(taskId, variableName)//使用执行对象的id获取变量
//		taskService.getVariable(taskId, variableName, variableClass)//通过类型获取变量
//		taskService.getVariables(taskId, variableNames)//通过指定变量名获取变量
//		taskService.getVariables(taskId)//获取所有的变量
		
		
	}
	
	@Test
	public void completeTask() {
		
		String taskId = "37504";
		
		processEngine.getTaskService().complete(taskId);
		
		System.out.println("任务已提交");
		
	}
	

}
