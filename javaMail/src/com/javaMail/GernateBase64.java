package com.javaMail;

import java.util.Base64;
import java.util.Scanner;

public class GernateBase64 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入用户名");
		String usernamestr = in.next();
		
		System.err.println(Base64.getEncoder().encodeToString(usernamestr.getBytes()));
		System.out.println("请输入密码");
		String passwordstr = in.next(); 
		
		System.err.println(Base64.getEncoder().encodeToString(passwordstr.getBytes()));
		in.close();
	}
	
}
