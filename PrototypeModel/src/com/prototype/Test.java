package com.prototype;

public class Test {
	
	public static void main(String[] args) {
		
		Person person1 = new Person("youth", 22, new Dog("阿黄", "黄色"));
		
		Person person2 = (Person) person1.shallowClone();
		//浅复制的dog对象仍然是原来的对象
		System.out.println(person1.getDog() == person2.getDog());
		
		Person person3 = (Person) person1.deepClone();
		//深复制的dog对象是不是同一个对象，两者为克隆关系
		System.out.println(person1.getDog() == person3.getDog());
		System.out.println("本尊：" + person1.getDog());
		System.out.println("克隆：" + person3.getDog());
		
		
	}

}
