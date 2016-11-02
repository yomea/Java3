package com.reference;

import java.util.WeakHashMap;

public class WeakHashMapTest {
	
	public static void main(String[] args) {
		
		WeakHashMap<String, String> weakHashMap = new WeakHashMap<String, String>();
		
		weakHashMap.put("a", "a");//常量池中的对象不会被回收
		weakHashMap.put("b", "b");
		weakHashMap.put(new String("c"), "c");//堆中的对象会被回收
		weakHashMap.put(new String("d"), "d");
		//通知垃圾回收器准备回收
		System.gc();
		//运行回收
		System.runFinalization();
		
		System.out.println(weakHashMap.size());//运行的结果为2
		
	}

}
