package com.treeSet;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
	
	public static void main(String[] args) {
		//在加入元素时才排序
		Set<Integer> treeSet = new TreeSet<Integer>();
		
		treeSet.add(1);
		treeSet.add(10);
		treeSet.add(16);
		treeSet.add(4);
		treeSet.add(3);
		
		Set<Opacity> opacity = new TreeSet<Opacity>();
		opacity.add(new Opacity(100));
		opacity.add(new Opacity(34));
		opacity.add(new Opacity(12));
		
		System.out.println(treeSet);
		System.out.println(opacity);
		//修改后不会排序，而且出现了重复
		opacity.iterator().next().setOpacity(100);
		
		System.out.println(opacity);
		
	}

}
