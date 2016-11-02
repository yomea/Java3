package com.builderModel;

public class Test {
	
	
	public static void main(String[] args) {
		
		Builder builder = new AutoMessageBuilder();
		
		Director director = new Director(builder);
		
		AutoMessage autoMessage = (AutoMessage) director.getProduct();
		
		System.out.println(autoMessage.toString());
		
	}

}
