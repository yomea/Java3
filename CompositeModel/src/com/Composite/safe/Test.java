package com.Composite.safe;

public class Test {
	
	public static void main(String[] args) {
		
		Panel panel = new Panel("panel");
		Button button = new Button("button");
		TextField textField = new TextField("textField");
		panel.add(button);
		panel.add(textField);
		panel.remove(button);
		//button.add()编译出错
		
		System.out.println(panel.getComponents());
		
	}

}
