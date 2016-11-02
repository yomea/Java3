package com.collection.linkedList;

public class Test {
	
	public static void main(String[] args) {
		MyLinkedList<Object> ints = new MyLinkedList<Object>();
		
		ints.add(new Integer(1));
		ints.add(new Integer(2));
		ints.add(new Integer(3));
		ints.add(new Integer(4));
		ints.add(new Integer(5));
		ints.add(new Integer(6));
		ints.set(2, new Integer(10));
		//ints.remove(new Integer(2));
		System.out.println(ints.size());
		System.out.println(ints.get(2));
		
	}

}
