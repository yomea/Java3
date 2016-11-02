package com.rowset;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetTest {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void test() throws Exception  {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taotao", "root", "root");
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		java.sql.ResultSet result = statement.executeQuery("select * from tb_user");
		connection.setAutoCommit(false);
		result.moveToInsertRow();
		result.updateObject("username", "yes");
		result.updateObject("password", "oh!no");
		result.updateObject("phone", "12345674714");
		result.updateObject("email", "yes@yes");
		
		result.insertRow();
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		System.out.println(databaseMetaData.supportsGetGeneratedKeys());
		connection.commit();
	}
	
	public static void main(String[] args) throws Exception {
		new ResultSetTest().test();
	}
	
}
