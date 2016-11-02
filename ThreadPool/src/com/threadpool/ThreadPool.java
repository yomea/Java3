package com.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadPool {

	public static void main(String[] args) throws Exception {
		
		Test test1 = new Test(1);
		Test test2 = new Test(2);
		Test test3 = new Test(3);
		Test test4 = new Test(4);
		Test test5 = new Test(5);
		
		FutureTask<Integer> futureTask1 = new FutureTask<Integer>(test1);
		FutureTask<Integer> futureTask2 = new FutureTask<Integer>(test2);
		FutureTask<Integer> futureTask3 = new FutureTask<Integer>(test3);
		FutureTask<Integer> futureTask4 = new FutureTask<Integer>(test4);
		FutureTask<Integer> futureTask5 = new FutureTask<Integer>(test5);
		
		Thread thread1 = new Thread(futureTask1);
		Thread thread2 = new Thread(futureTask2);
		Thread thread3 = new Thread(futureTask3);
		Thread thread4 = new Thread(futureTask4);
		Thread thread5 = new Thread(futureTask5);
		
		List<Runnable> list = new ArrayList<Runnable>();
		
		List<Callable<Integer>> list1 = new ArrayList<Callable<Integer>>();
		
		
		list1.add(test1);
		list1.add(test2);
		list1.add(test3);
		list1.add(test4);
		list1.add(test5);
		
		
		list.add(thread1);
		list.add(thread2);
		list.add(thread3);
		list.add(thread4);
		list.add(thread5);
		
		ExecutorService executorService = Executors.newFixedThreadPool(5, Executors.defaultThreadFactory());
		executorService.invokeAll(list1);
		
		/*for (Runnable runnable : list) {
			executorService.execute(runnable);
		}*/
		
		executorService.shutdown();
	}

}

class Test implements Callable<Integer> {

	private int num;

	public Test(int num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		
		System.out.println("hello" + num);
		
		return num;
	}

}
