package com.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 创建activiti流程表
 * @author may
 *
 */
public class CreateActivitiTableForJavaCode {

	public static void main(String[] args) {

		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
				.createStandaloneProcessEngineConfiguration();

		processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		processEngineConfiguration.setJdbcUrl(
				"jdbc:mysql://localhost:3306/activiti?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
		processEngineConfiguration.setJdbcUsername("root");
		processEngineConfiguration.setJdbcPassword("root");

		/**
		 * Checks the version of the DB schema against the library when the
		 * process engine is being created and throws an exception if the
		 * versions don't match.
		 * 如果表不在就不能创建表
		 */
		// public static final String DB_SCHEMA_UPDATE_FALSE = "false";

		/**
		 * Creates the schema when the process engine is being created and drops
		 * the schema when the process engine is being closed.
		 * 先删表，再创建
		 */
		// public static final String DB_SCHEMA_UPDATE_CREATE_DROP =
		// "create-drop";

		/**
		 * Upon building of the process engine, a check is performed and an
		 * update of the schema is performed if it is necessary.
		 * 数据库中没有这个表就创建表
		 */
		// public static final String DB_SCHEMA_UPDATE_TRUE = "true";

		processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		
		System.out.println("processEngine:" + processEngine);

	}

}
