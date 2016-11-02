package com.collection.hashMap;

public class Test {
	
	public static void main(String[] args) {
		MyHashMap<Object, Object> ints = new MyHashMap<Object, Object>();
		
		ints.put(new Integer(1), "a");
		ints.put(new Integer(2), "b");
		ints.put(new Integer(3), "c");
		ints.put(new Integer(4), "d");
		ints.put(new Integer(5), "e");
		ints.put(new Integer(5), "b");
		ints.put(new Integer(6), "a");
		ints.put(new Integer(7), "b");
		ints.put(new Integer(8), "c");
		ints.put(new Integer(9), "d");
		ints.put(new Integer(10), "e");
		ints.put(new Integer(11), "b");
		ints.put(new Integer(12), "c");
		ints.put(new Integer(13), "d");
		ints.put(new Integer(14), "e");
		System.out.println(ints.get(new Integer(13)));
		System.out.println(ints.size());
	}

}
