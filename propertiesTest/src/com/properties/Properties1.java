package com.properties;

import java.util.Properties;

public class Properties1 {
	
	public static void main(String[] args) throws Exception  {
		
		Properties props = new Properties();
		props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/properties/db.properties"));
		System.out.println(props.getProperty("jdbc.driverClassName"));
	}

}
