package com.singleton;

public class Test {
	
	public static void main(String[] args) {
		
		SingletonHungry singletonHungry1 = SingletonHungry.getInstance();
		SingletonHungry singletonHungry2 = SingletonHungry.getInstance();
		
		System.out.println(singletonHungry1 == singletonHungry2);
		
		
		SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
		SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
		
		System.out.println(singletonLazy1 == singletonLazy2);
		
	}

}
