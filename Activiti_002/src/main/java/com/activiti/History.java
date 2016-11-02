package com.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.junit.Test;

public class History {
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	/**
	 * 查询历史task
	 * 
	 */
	
	@Test
	public void queryTask() {
		
		String processInstanceId = "22505";		
		List<HistoricTaskInstance> list = processEngine.getHistoryService()
							  .createHistoricTaskInstanceQuery()
							  .processInstanceId(processInstanceId)
							  .list();
		
		if(list != null && list.size() > 0) {
			for (HistoricTaskInstance historicTaskInstance : list) {
				
				System.out.println(historicTaskInstance.getAssignee());
				System.out.println(historicTaskInstance.getName());
				
			}
			
			
		}
		
	}
	
	/**
	 * 查询流程历史
	 */
	
	@Test
	public void queryHistoryProcess() {
		
		String processInstanceId = "27501";
		
		List<HistoricProcessInstance> list = processEngine.getHistoryService()
							  .createHistoricProcessInstanceQuery()
							  .processInstanceId(processInstanceId)
							  .list();
		
		if(list != null && list.size() > 0) {
			
			for (HistoricProcessInstance historicProcessInstance : list) {
				
				System.out.println(historicProcessInstance.getId());
				System.out.println(historicProcessInstance.getStartTime());
				
			}
			
		}
		
	}
	
	/**
	 * 查询变量历史
	 */
	
	@Test
	public void queryHistoryVariable() {
		
		String processInstanceId = "37501";
		
		List<HistoricVariableInstance> list = processEngine.getHistoryService()
								  .createHistoricVariableInstanceQuery()
								  .processInstanceId(processInstanceId)
								  .list();
		
		if(list != null && list.size() > 0) {
			
			for (HistoricVariableInstance historicVariableInstance : list) {
				
				System.out.println(historicVariableInstance.getId());
				
				System.out.println(historicVariableInstance.getVariableName());
				
				System.out.println(historicVariableInstance.getVariableTypeName());
				
			}
		}
			
			
		
	}

}
