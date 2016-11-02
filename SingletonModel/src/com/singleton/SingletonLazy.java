package com.singleton;

public class SingletonLazy {
	
	private static SingletonLazy singletonLazy;
	
	private SingletonLazy() {}
	
	
	public synchronized static SingletonLazy getInstance() {
		
		if(singletonLazy == null) {
			
			singletonLazy = new SingletonLazy();
		}
		
		return singletonLazy;
		
	}

}
