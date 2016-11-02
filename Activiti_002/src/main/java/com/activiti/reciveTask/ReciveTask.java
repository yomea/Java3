package com.activiti.reciveTask;

import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

public class ReciveTask {

	/**
	 * 流程部署
	 * 
	 * @author may
	 *
	 */
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void processDefined() {

		InputStream inputStreambpmn = this.getClass().getResourceAsStream("ReciveTask.bpmn");
		InputStream inputStreampng = this.getClass().getResourceAsStream("ReciveTask.png");

		Deployment deployment = processEngine.getRepositoryService()// 创建流程仓库，放入流程定义,他会默认加载avtiviti.cfg.xml
				.createDeployment()// 创建一个部署对象，用于部署流程定义到仓库
				.name("ReceiveTask")// 定义部署名
				.addInputStream("ReciveTask.bpmn", inputStreambpmn).addInputStream("ReciveTask.png", inputStreampng)
				.deploy();

		System.out.println(deployment.getId());
		System.out.println(deployment.getName());

	}

	/**
	 * 启动流程,并让接收活动向下走
	 */
	@Test
	public void runTimeServer() {
		ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("ReceiveTask");
		//获得对应活动节点的执行对象
		Execution execution1 = processEngine.getRuntimeService().createExecutionQuery().processInstanceId(processInstance.getId()).activityId("receivetask1").singleResult();
		//设置汇总金额
		processEngine.getRuntimeService().setVariable(execution1.getId(), "汇总金额", 20000);
		//将活动任务向下传递
		processEngine.getRuntimeService().signal(execution1.getId());
		//获取会中金额
		Integer money = (Integer) processEngine.getRuntimeService().getVariable(execution1.getId(), "汇总金额");
		//获得对应活动节点的执行对象
		Execution execution2 = processEngine.getRuntimeService().createExecutionQuery().processInstanceId(processInstance.getId()).activityId("receivetask2").singleResult();
		//将活动任务向下传递
		processEngine.getRuntimeService().signal(execution2.getId());
		
		System.out.println("汇总金额：" + money);
		
	}



}
