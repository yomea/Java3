package com.abstractfactory;

/**
 * 烧烤，附赠品是水
 * @author may
 *
 */
public class Barbecue extends MainProduct {

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
