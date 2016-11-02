package com.abstractfactory;
/**
 * 电脑，附赠品是鼠标垫
 * @author may
 *
 */
public class Computer extends MainProduct {
	
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
