package com.abstractfactory;

public class Water extends FreeProduct {
	//品牌名
	private String name;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	
	
}
