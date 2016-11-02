package com.activiti.groupUser;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricIdentityLink;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class GroupUser {

	/**
	 * 流程部署
	 * 
	 * @author may
	 *
	 */
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void processDefined() {

		InputStream inputStreambpmn = this.getClass().getResourceAsStream("GroupUser.bpmn");
		InputStream inputStreampng = this.getClass().getResourceAsStream("GroupUser.png");

		Deployment deployment = processEngine.getRepositoryService()// 创建流程仓库，放入流程定义,他会默认加载avtiviti.cfg.xml
				.createDeployment()// 创建一个部署对象，用于部署流程定义到仓库
				.name("GroupUser")// 定义部署名
				.addInputStream("GroupUser.bpmn", inputStreambpmn).addInputStream("GroupUser.png", inputStreampng)
				.deploy();

		System.out.println(deployment.getId());
		System.out.println(deployment.getName());

	}

	@Test
	public void createGroup() {

		IdentityService identityService = processEngine.getIdentityService();

		// 创建用户角色
		Group group1 = new GroupEntity("总经理");
		Group group2 = new GroupEntity("部门经理");
		// group1.setType("Candidate");

		identityService.saveGroup(group1);
		identityService.saveGroup(group2);

	}

	@Test
	public void createUser() {
		IdentityService identityService = processEngine.getIdentityService();
		// 创建用户
		User user1 = new UserEntity("呵呵");
		user1.setEmail("呵呵@qq.xom");
		user1.setFirstName("呵");
		user1.setLastName("呵");
		user1.setPassword("xxoo");

		User user2 = new UserEntity("里斯");
		user2.setEmail("里斯@qq.xom");
		user2.setFirstName("诺克");
		user2.setLastName("克里斯");
		user2.setPassword("ooxx");

		User user3 = new UserEntity("夏尔美");
		user3.setEmail("OrCHestra@qq.xom");
		user3.setFirstName("大蛇");
		user3.setLastName("夏尔美");
		user3.setPassword("吱吱吱吱");

		identityService.saveUser(user1);
		identityService.saveUser(user2);
		identityService.saveUser(user3);

	}

	@Test
	public void createMembership() {
		IdentityService identityService = processEngine.getIdentityService();
		// 建立角色与用户之间的关系
		identityService.createMembership("呵呵", "总经理");

		identityService.createMembership("里斯", "部门经理");

		identityService.createMembership("夏尔美", "部门经理");
	}
	

	/**
	 * 删除用户和角色
	 */
	@Test
	public void delUserAndGroup() {

		IdentityService identityService = processEngine.getIdentityService();
		identityService.deleteMembership("呵呵", "总经理");
		identityService.deleteMembership("里斯", "部门经理");
		identityService.deleteMembership("夏尔美", "部门经理");
		identityService.deleteGroup("总经理");
		identityService.deleteGroup("部门经理");
		identityService.deleteUser("呵呵");
		identityService.deleteUser("里斯");
		identityService.deleteUser("夏尔美");
	}

	/**
	 * 启动流程
	 */
	@Test
	public void runTimeServer() {

		ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("groupTask");
		System.out.println(processInstance.getId());//

		System.out.println(processInstance.getProcessDefinitionId());//

	}

	/**
	 * 查看组任务表
	 */

	@Test
	public void taskServer() {
		String candidateUser = "a";

		List<Task> tasks = processEngine.getTaskService()// 任务server
				.createTaskQuery()// 创建任务查询
				// .taskCandidateGroup(candidateGroup)//如果是组任务，通过组来查询任务
				.taskCandidateUser(candidateUser)// 通过组员来查询任务
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

		processEngine.getTaskService().complete(taskId, map);// 完成任务

	}

	@Test
	public void delProcessdefinition() {

		String deploymentId = "50001";

		processEngine.getRepositoryService().deleteDeployment(deploymentId, true);

		System.out.println("删除成功！");

	}

	/**
	 * 查询组任务成员
	 */
	@Test
	public void queryGroupPerson() {

		String taskId = "122504";

		List<IdentityLink> list = processEngine.getTaskService().getIdentityLinksForTask(taskId);

		if (list != null && list.size() > 0) {

			for (IdentityLink identityLink : list) {

				System.out.println(identityLink.getUserId() + "      " + identityLink.getType() + "      "
						+ identityLink.getTaskId());

			}

		}

	}

	/**
	 * 查询历史组任务成员
	 */
	@Test
	public void queryHistoryGroupPerson() {

		String processInstanceId = "122501";

		List<HistoricIdentityLink> list = processEngine.getHistoryService()
				.getHistoricIdentityLinksForProcessInstance(processInstanceId);

		if (list != null && list.size() > 0) {

			for (HistoricIdentityLink historicIdentityLink : list) {

				System.out.println(historicIdentityLink.getUserId() + "      " + historicIdentityLink.getType()
						+ "      " + historicIdentityLink.getProcessInstanceId());

			}

		}

	}

	/**
	 * 拾取任务，将组任务分给个人任务
	 */
	@Test
	public void claim() {

		String taskId = "122504";

		processEngine.getTaskService().claim(taskId, "小七");

	}

	/**
	 * 回退组任务（注意：前提是这个任务原本是个组任务）
	 */
	@Test
	public void rollbackGroupTask() {

		String taskId = "122504";

		processEngine.getTaskService().setAssignee(taskId, null);

	}

	/**
	 * 向组任务中添加办理人
	 */
	@Test
	public void addCandidateUser() {

		String taskId = "122504";

		processEngine.getTaskService().addCandidateUser(taskId, "哈喽");

	}

	/**
	 * 向组任务中删除办理人
	 */
	@Test
	public void deleteCandidateUser() {

		String taskId = "122504";

		processEngine.getTaskService().deleteCandidateUser(taskId, "b");

	}

}
