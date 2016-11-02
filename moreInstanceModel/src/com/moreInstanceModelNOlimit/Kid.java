package com.moreInstanceModelNOlimit;

public class Kid {

	public static void main(String[] args) {

		Fruit apple = Fruit.getFruit("苹果");
		Fruit orange = Fruit.getFruit("橘子");
		Fruit bananer = Fruit.getFruit("香蕉");

		System.out.println(apple.getName() + "--" + orange.getName() + "--" + bananer.getName());
	}

}
