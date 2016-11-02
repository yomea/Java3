package com.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 创建activiti流程表
 * @author may
 *
 */
public class CreateActivitiTableForXml {

	public static void main(String[] args) {

		
		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
		
		System.out.println("processEngine:" + processEngine);

	}

}
