package com.otherMap;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {
	
	public static void main(String[] args) {
		
		IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();
		
		identityHashMap.put("a", "a");
		identityHashMap.put("a", "a");//由于存在了一个地址相同的a，所以这个视为重复元素
		identityHashMap.put(new String("a"), "a");
		identityHashMap.put("a", "a");
		System.out.println(identityHashMap.size());//运行结果为2
		
		
	}

}
