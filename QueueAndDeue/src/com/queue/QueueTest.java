package com.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest {
	
	
	public static void main(String[] args) {
		
		Queue<request> queque = new ArrayDeque<request>();
		
		for(int i = 0; i < 10; i++) {
			final int num = i;//在程序退出时释放内存。
			queque.offer(new request() {
				
				@Override
				public void print() {
					System.out.println(num);
					
				}
				
			});
			
		}
		System.out.println("队列的大小：" + queque.size());
		
		for(int i = 0; i < 10; i++) {
		
			queque.poll().print();
			
		}
		System.out.println("队列的大小：" + queque.size());
		
	}

}

interface request {
	void print();
	
}
