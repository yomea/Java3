package com.abstractfactory;

public class CreateFactory {
	
	

	public static AbstractFactory createFactory(String name) {
		
		String className = PropertiesUtil.getProperty(name);
		AbstractFactory factory = null;
		try {
			factory = (AbstractFactory) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return factory;
		
	}
	
}
