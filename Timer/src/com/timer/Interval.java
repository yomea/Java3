package com.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Interval {
	
	public static void main(String[] args) {
		
		Timer timer = new Timer();
		//循环定时器
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("hello");
				
			}
		},new Date(), 1000);
		//延时执行
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("world");
				
			}
		}, 2000);
		
	}

}
