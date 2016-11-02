package com.abstractfactory;

public class Customer {

	public static void main(String[] args) {
		AbstractFactory factory = CreateFactory.createFactory("ComputerFactory");
		MainProduct mainProduct = factory.createMainProduct();
		mainProduct.setName("华硕笔记本电脑");
		FreeProduct freeProduct = factory.createFreeProduct();
		freeProduct.setName("超级鼠标垫");
		System.out.println("你购买了" + mainProduct.getName() + "附赠你" + freeProduct.getName() + "一个");
		
		
		
	}
	
}
