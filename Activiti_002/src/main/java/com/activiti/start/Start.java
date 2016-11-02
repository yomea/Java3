package com.activiti.start;

import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

public class Start {

	/**
	 * 流程部署
	 * 
	 * @author may
	 *
	 */
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void processDefined() {

		InputStream inputStreambpmn = this.getClass().getResourceAsStream("start.bpmn");
		InputStream inputStreampng = this.getClass().getResourceAsStream("start.png");

		Deployment deployment = processEngine.getRepositoryService()// 创建流程仓库，放入流程定义,他会默认加载avtiviti.cfg.xml
				.createDeployment()// 创建一个部署对象，用于部署流程定义到仓库
				.name("start")// 定义部署名
				.addInputStream("start.bpmn", inputStreambpmn).addInputStream("start.png", inputStreampng).deploy();

		System.out.println(deployment.getId());
		System.out.println(deployment.getName());

	}

	/**
	 * 启动流程
	 */
	@Test
	public void runTimeServer() {
		ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("start");
		System.out.println(processInstance.getId());//

		System.out.println(processInstance.getProcessDefinitionId());//

		ProcessInstance pi = processEngine.getRuntimeService().createProcessInstanceQuery()
				.processInstanceId(processInstance.getId()).singleResult();

		if (pi == null) {

			HistoricProcessInstance historicProcessInstance = processEngine.getHistoryService().createHistoricProcessInstanceQuery()
					.processInstanceId(processInstance.getId()).singleResult();
			
			System.out.println(historicProcessInstance.getId());
			System.out.println("我已经成为历史了");

		}

	}

}
