package com.factory;

public class Test {
	
	public static void main(String[] args) {
		Fruit apple = new AppleFactory().createFruit();
		Fruit orangle = new OrangleFactory().createFruit();
		
		apple.grow();
		orangle.grow();
	}
	
}
