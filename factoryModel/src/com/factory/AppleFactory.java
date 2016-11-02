package com.factory;

public class AppleFactory implements Factory {

	@Override
	public Fruit createFruit() {
		return new Apple();
	}

}
