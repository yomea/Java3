package com.moreInstanceModelNOlimit;

import java.util.HashMap;
import java.util.Map;

/**
 * 有上限多例模式
 * 其实与单例模式的写法差不多，只不过多例模式可以去更多的实例
 * @author may
 *
 */
public class Fruit {
	
	private String name;
	private static Map<String, Fruit> basket = new HashMap<String, Fruit>();

	private Fruit(String name) {
		
		this.name = name;
	}
	
	public static Fruit getFruit(String name) {
		
		if(basket.containsKey(name)) {
			
			return basket.get(name);
		} else {
			Fruit fruit = new Fruit(name);
			basket.put(name, fruit);
			
			return fruit;
			
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
