package com.abstractfactory;

/**
 * 鼠标垫，电脑的附赠品
 * @author may
 *
 */
public class Mousepad extends FreeProduct {
	
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
