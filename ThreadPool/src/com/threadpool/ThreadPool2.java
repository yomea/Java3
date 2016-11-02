package com.threadpool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool2 {

	public static void main(String[] args) throws Exception {

		Test2 test1 = new Test2(1);
		Test2 test2 = new Test2(2);
		Test2 test3 = new Test2(3);
		Test2 test4 = new Test2(4);
		Test2 test5 = new Test2(5);

		Thread thread1 = new Thread(test1);
		Thread thread2 = new Thread(test2);
		Thread thread3 = new Thread(test3);
		Thread thread4 = new Thread(test4);
		Thread thread5 = new Thread(test5);

		List<Runnable> list = new ArrayList<Runnable>();

		list.add(thread1);
		list.add(thread2);
		list.add(thread3);
		list.add(thread4);
		list.add(thread5);

		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5, true, list));
		System.out.println(executor.getMaximumPoolSize());
		Iterator<Runnable> iterator = executor.getQueue().iterator();
		while(iterator.hasNext()){
			
			executor.execute(iterator.next());
			System.out.println(executor.getActiveCount());
			
		}
		System.out.println(executor.getActiveCount());

	}

}

class Test2 implements Runnable {

	private int num;

	public Test2(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		System.out.println("hello" + num);

	}

}
