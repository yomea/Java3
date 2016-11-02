package com.deue;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Request> stack = new Stack<Request>();
		
		for(int i = 0; i < 10; i++) {
			final int num = i;
			stack.push(new Request() {

				@Override
				public void print() {
					System.out.println(num);
					
				}
				
				
			});
			
		}
		int size = stack.size();
		for(int i = 0; i < size; i++) {
			stack.pop().print();
			
		}
		
	}
	
}

interface Request {
	
	void print();
	
}
