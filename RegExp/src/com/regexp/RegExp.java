package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
	
	public static void main(String[] args) {
		String input = "hello class youth";
		Pattern pattern = Pattern.compile("(o[\\s])class([\\s]y)");
		Matcher matcher = pattern.matcher(input);
		boolean flag = matcher.matches();//匹配全串
		boolean result = matcher.find();//是否有匹配的子字符串
		String find = matcher.group();//全串group(1)匹配第一个组，group(2)匹配第二个组
		System.out.println(flag);
		System.out.println(result);
		System.out.println(find);
		
		
	}
	
}
