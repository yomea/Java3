package com.factory;

public class OrangleFactory implements Factory {

	@Override
	public Fruit createFruit() {
		return new Orangle();
	}

}
