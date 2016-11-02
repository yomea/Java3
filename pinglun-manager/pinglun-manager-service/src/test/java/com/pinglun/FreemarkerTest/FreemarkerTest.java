package com.pinglun.FreemarkerTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pinglun.util.FreemarkerUtil;

public class FreemarkerTest {
	public static void main(String[] args) throws Exception {
		User user = new User();
		LatestProduct latestProduct = new LatestProduct();
		user.setLatestProduct(latestProduct);
		List<User> contents = new ArrayList<User>();
		contents.add(user);
		contents.add(user);
		Map map = new HashMap<>();
		map.put("list", contents);
		System.out.println(FreemarkerTest.class.getClassLoader().getResource("").toURI());
		String string = FreemarkerUtil.freemarker(map,FreemarkerTest.class.getClassLoader().getResource("").toURI(),"test.ftlh");
		
		System.out.println(string);
	}
}
