package com.simplefactory;

import java.io.IOException;
import java.util.Properties;

public class FruitList {

	private static Properties props;
	
	static {
		props = new Properties();
		try {
			//classpath加载文件需要/,如果你使用的是class Loader就不需要/
			//props.load(FruitList.class.getClassLoader().getResourceAsStream("fruitList.properties"));
			props.load(FruitList.class.getResourceAsStream("/fruitList.properties"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static String getProperty(String name) {
		
		return props.getProperty(name);
		
	}
	
}
