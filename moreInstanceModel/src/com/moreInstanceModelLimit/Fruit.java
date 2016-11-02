package com.moreInstanceModelLimit;
/**
 * 有上限多例模式
 * 其实与单例模式的写法差不多，只不过多例模式可以去更多的实例
 * @author may
 *
 */
public class Fruit {
	
	private String name;
	private static Fruit apple = new Fruit("苹果");
	private static Fruit orange = new Fruit("橘子");

	private Fruit(String name) {
		
		this.name = name;
	}
	
	public static Fruit getFruit(String name) {
		return name.equals("苹果") ? apple : name.equals("橘子") ? orange : null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
