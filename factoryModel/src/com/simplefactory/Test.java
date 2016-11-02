package com.simplefactory;

public class Test {
	
	public static void main(String[] args) {
		Fruit apple = SimpleFactory.createFruit("apple");
		Fruit orangle = SimpleFactory.createFruit("orangle");
		
		apple.grow();
		orangle.grow();
	}
	
}
