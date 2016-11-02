package com.genericExtends.generic;

public class Test {
	
	public static void main(String[] args) {
		
		Father<Job, Mother> father = new Son5<Job, Mother>();
		 Son5<Job, Mother> father0 = new Son5<Job, Mother>();
		 Father f = father0;
		//Son5<Object, Object> son = (Son5<Job, Mother>) father;出错，泛型必须相同
		
		Son5<Object, Object> son1 = (Son5<Object, Object>) father;
		//Son5<Object, Object> son0 =  father0;
		Son5<?, ? extends Object> son2 = (Son5<Job, Mother>) father;
	}

}
