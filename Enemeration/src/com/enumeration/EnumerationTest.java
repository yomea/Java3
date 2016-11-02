package com.enumeration;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

public class EnumerationTest {
	
	public static void main(String[] args) {
		Vector<String> vector = new Vector<>();
		
		vector.add("11111");
		vector.add("22222");
		vector.add("33333");
		vector.add("44444");
		Enumeration<String> enumeration = vector.elements();
		while(enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
		
		String mailStr = "hehe@qq.com;hehe@163.com;hehe@sina.com;hehe@sohu.com";
		StringTokenizer stringTokenizer = new StringTokenizer(mailStr, ";");
		
		while(stringTokenizer.hasMoreTokens()) {
			
			System.out.println(stringTokenizer.nextToken());
		}
	}

}
