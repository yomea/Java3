package com.deue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack<E> {
	
	private  Deque<E> deque = null;
	private int size;
	
	
	public MyStack(int size) {
		this.size = size;
		deque = new ArrayDeque<E>(size);
	}
	
	public static void main(String[] args) {
		MyStack<String> myStack = new MyStack<String>(10);
		myStack.push("www.baidu.com");
		myStack.push("www.soso.com");
		myStack.push("www.163.com");
		for(int i = 0; i < 3; i++) {
			System.out.println(myStack.pop());
			
		}
	}
	
	public boolean push(E obj) {
		if(size == deque.size()) {
			
			return false;
		}
		deque.offerLast(obj);
		
		return true;
		
	}

	public E pop() {
		return deque.pollLast();
		
	}
}
