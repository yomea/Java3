package com.activiti;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ProcessDefinTest {

	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void processDefined() {

		System.out.println(processEngine);

		Deployment deployment = processEngine.getRepositoryService()// 创建流程仓库，放入流程定义,他会默认加载avtiviti.cfg.xml
				.createDeployment()// 创建一个部署对象，用于部署流程定义到仓库
				.name("helloworld部署定義")// 定义部署名
				.addClasspathResource("diagrams/HelloWorld.bpmn")// 加载
				.addClasspathResource("diagrams/HelloWorld.png")// 一次只能加载一个文件
				.deploy();// 部署

		System.out.println("部署id：" + deployment.getId());
		System.out.println("部署名：" + deployment.getName());

	}

	@Test
	public void processDefined_zip() {

		System.out.println(processEngine);

		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("diagrams/helloworld.zip");

		ZipInputStream zipInputStream = new ZipInputStream(inputStream);

		Deployment deployment = processEngine.getRepositoryService()// 创建流程仓库，放入流程定义,他会默认加载avtiviti.cfg.xml
				.createDeployment()// 创建一个部署对象，用于部署流程定义到仓库
				.name("helloworld部署定義")// 定义部署名
				.addZipInputStream(zipInputStream).deploy();// 部署

		System.out.println("部署id：" + deployment.getId());
		System.out.println("部署名：" + deployment.getName());

	}

	/**
	 * 查询部署
	 */

	@Test
	public void queryDeployment() {

		List<Deployment> list = processEngine.getRepositoryService().createDeploymentQuery().orderByDeploymentId().asc()// 按部署名升序排序
				// .deploymentId(deploymentId)//通过流程部署id查询
				// .deploymentName(name)//通过流程部署名来查询
				// .deploymentNameLike(nameLike)//通过流程部署名模糊查询
				.list();// 返回一个list集合
		// .listPage(firstResult, maxResults)//分页查询
		// .count()//查询到的记录数

		if (list != null && list.size() > 0) {

			for (Deployment deployment : list) {
				System.out.println("部署id：" + deployment.getId());
				System.out.println("部署名：" + deployment.getName());
				System.out.println("部署时间：" + deployment.getDeploymentTime());
				System.out.println("###############################");
			}

		}

	}

	/**
	 * 查询流程定义
	 */

	@Test
	public void queryProcessDef() {

		List<ProcessDefinition> list = processEngine.getRepositoryService().createProcessDefinitionQuery()
				// .orderByProcessDefinitionName().asc()//按流程定义名升序排序
				// .deploymentId(deploymentId)//通过流程部署id查询
				// .deploymentIds(deploymentIds)//通过流程部署id列表来查询
				// .processDefinitionId(processDefinitionId)//通过流程查询
				// .processDefinitionKeyLike(processDefinitionKeyLike)
				// .processDefinitionKey(processDefinitionKey)

				.list()// 返回一个list集合
		// .listPage(firstResult, maxResults)//分页查询
		// .count()//查询到的记录数
		;
		if (list != null && list.size() > 0) {

			for (ProcessDefinition processDefinition : list) {
				System.out.println("部署id：" + processDefinition.getDeploymentId());
				System.out.println("流程定义id：" + processDefinition.getId());
				System.out.println("流程的key：" + processDefinition.getKey());
				System.out.println("流程定义名：" + processDefinition.getName());
				System.out.println("资源bpmn名：" + processDefinition.getResourceName());
				System.out.println("流程定义版本：" + processDefinition.getVersion());
				System.out.println("###############################");
			}
		}

	}

	/**
	 * 删除流程定义
	 */

	@Test
	public void delProcessDef() {

		String deploymentId = "10001";
		/**
		 * 删除还没有启动的流程，如果删除启动的流程就会报错
		 */
		/*
		 * processEngine.getRepositoryService() .deleteDeployment(deploymentId);
		 */
		/**
		 * 级联删除，不管有没有启动，老子就是要删除你
		 */
		processEngine.getRepositoryService().deleteDeployment(deploymentId, true);

		System.out.println("删除成功！");

	}

	/**
	 * 查看流程图
	 * 
	 * @throws IOException
	 */
	@Test
	public void viewProcessPic() throws IOException {

		String deploymentId = "15001";

		// 获取部署的资源所有的名称
		List<String> names = processEngine.getRepositoryService().getDeploymentResourceNames(deploymentId);

		String resourceName = null;
		// 找出以png结尾的资源名
		if (names != null && names.size() > 0) {

			for (String string : names) {

				if (string.endsWith(".png")) {
					resourceName = string;
					break;
				}

			}

		}

		InputStream inputStream = processEngine.getRepositoryService().getResourceAsStream(deploymentId, resourceName);

		File file = new File("D:/" + resourceName);

		FileUtils.copyInputStreamToFile(inputStream, file);

	}

	/**
	 * 
	 * 查询最新版本的流程定义
	 */
	@Test
	public void findNewVersionProcessDefinition() {

		List<ProcessDefinition> list = processEngine.getRepositoryService().createProcessDefinitionQuery()
				.orderByProcessDefinitionVersion().asc().list();

		Map<String, ProcessDefinition> map = new LinkedHashMap<String, ProcessDefinition>();

		if (list != null && list.size() > 0) {

			for (ProcessDefinition processDefinition : list) {

				map.put(processDefinition.getKey(), processDefinition);

			}

		}

		List<ProcessDefinition> processDefinitions = new ArrayList<ProcessDefinition>(map.values());

		if (processDefinitions != null && processDefinitions.size() > 0) {

			for (ProcessDefinition processDefinition : processDefinitions) {
				System.out.println("部署id：" + processDefinition.getDeploymentId());
				System.out.println("流程定义id：" + processDefinition.getId());
				System.out.println("流程的key：" + processDefinition.getKey());
				System.out.println("流程定义名：" + processDefinition.getName());
				System.out.println("资源bpmn名：" + processDefinition.getResourceName());
				System.out.println("流程定义版本：" + processDefinition.getVersion());
				System.out.println("###############################");
			}
		}

	}

	/**
	 * 删除所有相同key的不用版本
	 */

	@Test
	public void delSimKey() {
		List<ProcessDefinition> list = processEngine.getRepositoryService().createProcessDefinitionQuery()
				.processDefinitionKey("HelloWorld").list();

		if (list != null && list.size() > 0) {
			for (ProcessDefinition processDefinition : list) {
				processEngine.getRepositoryService().deleteDeployment(processDefinition.getDeploymentId(), true);

			}

		}

	}

	/**
	 * 查询流程是否结束
	 */

	@Test
	public void isProcessInstanceOver() {

		String processInstanceId = "22505";

		ProcessInstance processInstance = processEngine.getRuntimeService()
							  .createProcessInstanceQuery()
							  .processInstanceId(processInstanceId)
							  .singleResult();
		
		if(processInstance == null) {
			System.out.println("流程结束！");
		} else {
			System.out.println("流程未结束！");
		}

		
		
	}
	
	/**
	 * 查询历史任务
	 */
	@Test
	public void queryHistoryTask() {
		
		
		List<HistoricTaskInstance> list = processEngine.getHistoryService()
							  .createHistoricTaskInstanceQuery()
							  .list();
		
		if(list != null && list.size() > 0) {
			
			for (HistoricTaskInstance historicTaskInstance : list) {
				
				System.out.println(historicTaskInstance.getName());
				
			}
			
		}
	}
	
	/**
	 * 查询历史流程
	 */
	@Test
	public void queryHistoryProcess() {
		
		
		List<HistoricProcessInstance> list = processEngine.getHistoryService()
							  .createHistoricProcessInstanceQuery()
							  .list();
		
		if(list != null && list.size() > 0) {
			
			for (HistoricProcessInstance historicProcessInstance : list) {
				
				System.out.println(historicProcessInstance.getStartTime());
				
			}
			
		}
	}

}
