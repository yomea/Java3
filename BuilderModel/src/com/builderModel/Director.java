package com.builderModel;

public class Director {
	private Builder builder = null;
	
	public Director(Builder builder) {
		this.builder = builder;
		this.builder.BuildPart1();
		this.builder.BuildPart2();
		
	}
	
	public Product getProduct() {
		return this.builder.getProduct();
	}		
}
