package com.properties;

import java.io.FileInputStream;
import java.util.Properties;

public class Properties3 {

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		props.loadFromXML(new FileInputStream("src/DB.xml"));
		System.out.println(props.getProperty("jdbc.driverClassName"));
	}

}
