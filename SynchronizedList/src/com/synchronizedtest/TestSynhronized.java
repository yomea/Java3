package com.synchronizedtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSynhronized {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("a");
		
		list.add("b");
		
		List<String> list2 = Collections.unmodifiableList(list);
		
		/**
		 * Exception in thread "main" java.lang.UnsupportedOperationException
		 *	at java.util.Collections$UnmodifiableCollection.add(Unknown Source)
		 *	at com.synchronizedtest.TestSynhronized.main(TestSynhronized.java:19)
		 */
		
		list2.add("c");
		
		
		
	}

}
