package com.activiti.exclusiveGateWay;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class ExclusiveGateFlow {

	/**
	 * 流程部署
	 * 
	 * @author may
	 *
	 */
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void processDefined() {

		InputStream inputStreambpmn = this.getClass().getResourceAsStream("exclusiveGateWay.bpmn");
		InputStream inputStreampng = this.getClass().getResourceAsStream("exclusiveGateWay.png");

		Deployment deployment = processEngine.getRepositoryService()// 创建流程仓库，放入流程定义,他会默认加载avtiviti.cfg.xml
				.createDeployment()// 创建一个部署对象，用于部署流程定义到仓库
				.name("exclusiveGateWay")// 定义部署名
				.addInputStream("exclusiveGateWay.bpmn", inputStreambpmn).addInputStream("exclusiveGateWay.png", inputStreampng)
				.deploy();

		System.out.println(deployment.getId());
		System.out.println(deployment.getName());

	}

	/**
	 * 启动流程
	 */
	@Test
	public void runTimeServer() {
		ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("exclusiveGateWay");
		System.out.println(processInstance.getId());// 

		System.out.println(processInstance.getProcessDefinitionId());// 

	}

	/**
	 * 查看个人任务表
	 */

	@Test
	public void taskServer() {
		String assignee = "王小五";

		List<Task> tasks = processEngine.getTaskService()// 任务server
				.createTaskQuery()// 创建任务查询
				.taskAssignee(assignee)// 告知要查询谁的任务
				// .taskCandidateGroup(candidateGroup)//如果是组任务，通过组来查询任务
				// .taskCandidateUser(candidateUser)//通过组员来查询任务
				// .processDefinitionId(processDefinitionId)//通过流程定义的id来查询任务
				// .orderByProcessDefinitionId().asc()
				.list();// 列出张三的所有任务

		if (tasks != null && tasks.size() > 0) {
			for (Task task : tasks) {
				System.out.println("##########################################");
				System.out.println("任务id：" + task.getId());
				System.out.println("任务名：" + task.getName());
				System.out.println("任务创建时间：" + task.getCreateTime());
				System.out.println("任务办理人：" + task.getAssignee());
				System.out.println("任务流程实例id：" + task.getProcessInstanceId());
				System.out.println("任务执行的id：" + task.getExecutionId());
				System.out.println("任务流程定义id：" + task.getProcessDefinitionId());
				System.out.println("##########################################");
			}
		}

	}

	/**
	 * 完成任务
	 */
	@Test
	public void completeTask() {

		String taskId = "67504";

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("money", 200);
		
		processEngine.getTaskService().complete(taskId,map);// 完成任务

	}
	
	@Test
	public void delProcessdefinition() {
		
		String deploymentId = "50001";
		
		processEngine.getRepositoryService()
							  .deleteDeployment(deploymentId, true);
							  
		System.out.println("删除成功！");
		
	}

}
