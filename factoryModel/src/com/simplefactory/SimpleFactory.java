package com.simplefactory;

public class SimpleFactory {
	
	public static Fruit createFruit(String name) {
		
		String className = FruitList.getProperty(name);
		
		Fruit fruit = null;
		
		try {
			fruit = (Fruit) Class.forName(className).newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fruit;
		
	}
	
}
