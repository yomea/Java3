package com.Composite.Transient;

public class Test {
	
	public static void main(String[] args) {
		
		Component panel = new Panel("panel");
		Component button = new Button("button");
		Component textField = new TextField("textField");
		panel.add(button);
		panel.add(textField);
		panel.remove(button);
		//button.add(component);编译不出错，但毫无意义
		System.out.println(panel.getComponents());
		
	}

}
