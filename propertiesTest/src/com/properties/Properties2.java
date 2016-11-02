package com.properties;

import java.io.FileOutputStream;
import java.util.Properties;

public class Properties2 {

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		props.setProperty("jdbc.driverClassName", "com.mysql.cj.jdbc.Driver");
		props.setProperty("jdbc.url",
				"jdbc:mysql://localhost:3306/taotao?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
		props.setProperty("jdbc.username", "root");
		props.setProperty("jdbc.password", "root");
		FileOutputStream fileOutputStream = new FileOutputStream("db.properties");
		props.store(fileOutputStream, "properties create configure");
		System.out.println(Properties2.class.getResource("").getPath());
		props.storeToXML(new FileOutputStream("src/DB.xml"), "properties create configure", "utf-8");
	}

}
