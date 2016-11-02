package com.collection.arrayList;

import java.util.Iterator;

public class Test {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		MyArrayList<Object> ints = new MyArrayList<Object>();
		
		ints.add(new Integer(1));
		ints.add(new Integer(2));
		ints.add(new Integer(3));
		ints.add(new Integer(4));
		ints.add(new Integer(5));
		ints.add(new Integer(6));
		/*Number[] a = new Number[3];
		ints.toArray(a);
		System.out.println(ints.toArray(a)[0]);
		System.out.println(ints.toArray()[0]);*/
		Object iterator1 = ints.iterator();
		//Iterator<Object> iterator = ints.iterator()不能直接赋值给Iterator<Integer>
		//泛型不能强转，正所谓能放子类的容器不一定能放父类，能放父类的容器，一定能放子类
		Iterator<Integer> iterator = (Iterator<Integer>) iterator1;
		for (;iterator.hasNext();) {
			System.out.println(iterator.next() + "--iterator");
		}
		ints.set(1, new Integer(10));
		/*System.out.println(ints.size());
		ints.remove(new Integer(2));
		System.out.println(ints.size());
		System.out.println(ints.get(4) + "----");
		System.out.println(ints.size());*/
		
		for (Object object : ints) {
			System.out.println(object);
		}
		
	}

}
