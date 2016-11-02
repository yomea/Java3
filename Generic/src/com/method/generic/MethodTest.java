package com.method.generic;

public class MethodTest {
	
	/**
	 * 泛型方法
	 * @param a
	 * @return
	 */
	public <T> T print(T a) {
		
		return a;
	}
	
	
	/**
	 * 泛型静态方法
	 * @param a
	 * @return
	 */
	public static <T> T printArr(T a) {
		return a;
		
		
	}
	
	@SafeVarargs//编译期注解
	public static <T> T[] printArr(T... a) {
		return a;
		
		
	}
	
	
	public static void main(String[] args) {
		int[] b = new int[]{1,2,3,4,5,6,7};
		int[] a = printArr(b);
		int[][] c = printArr(b,b);
		System.out.println(a[3]);
		System.out.println(c[1][3]);
	}
	

}
