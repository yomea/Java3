package com.synchronizedtest;

import java.util.Collections;
import java.util.List;

public class SynchronizedSingleton {
	
	public static void main(String[] args) {
		
		List<String> list = Collections.singletonList(new String("a"));
		/**
		 * Exception in thread "main" java.lang.UnsupportedOperationException
		 *	at java.util.AbstractList.add(Unknown Source)
		 *	at java.util.AbstractList.add(Unknown Source)
		 *	at com.synchronizedtest.SynchronizedSingleton.main(SynchronizedSingleton.java:16)
		 * 
		 */
		list.add("b");
		
	}

}
