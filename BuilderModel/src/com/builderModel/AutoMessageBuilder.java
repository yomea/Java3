package com.builderModel;

public class AutoMessageBuilder implements Builder {
	
	private AutoMessage message = new AutoMessage();

	@Override
	public void BuildPart1() {
		message.setFrom("客户");
	}

	@Override
	public void BuildPart2() {
		message.setContent("你的网页出错了");
	}

	@Override
	public Product getProduct() {
		
		return message;
	}

}
