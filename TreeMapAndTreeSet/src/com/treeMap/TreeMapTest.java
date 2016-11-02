package com.treeMap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
	
	public static void main(String[] args) {
		//在加入元素时才排序
		Map<Opacity, String> map = new TreeMap<Opacity, String>();
		Opacity opacity = new Opacity(23);
		map.put(opacity, "hello");
		map.put(new Opacity(234), "hello");
		map.put(new Opacity(45), "hello");
		map.put(new Opacity(100), "hello");
		
		System.out.println(map);
		//修改后会出现重复，并且不会再排序
		opacity.setOpacity(100);
		
		System.out.println(map);
	
		
	}

}
