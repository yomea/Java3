package com.array.generic;

public class ArrGeneric {
	
	
	public static void main(String[] args) {
		
		Integer[] ints = new Integer[10];
		
		//Cannot create a generic array of List<Integer>
		//编译器就报错了
		//List<Integer>[] list = new List<Integer>[10];
		
		Object[] object = ints;
		
		object[0] = 1;
		
		object[1] = "hello";
		/**
		 * 他会报数组存储错误，而不是类型转换错误
		 * Exception in thread "main" java.lang.ArrayStoreException: java.lang.String
		 * at com.array.generic.ArrGeneric.main(ArrGeneric.java:14)
		 * 实际类型是Integer类型的数组，你把它看成Object加入其它类型的东西，编译器是无法发现的，但运行期出错
		 * 
		 */
		System.out.println((Integer)object[1]);
		
	}
	
}
