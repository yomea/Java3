package com.otherMap;

import java.util.EnumMap;

public class EnumMapTest {
	
	public static void main(String[] args) {
		
		EnumMap<Season, String> enumMap = new EnumMap<Season, String>(Season.class);
		
		enumMap.put(Season.SPRING, "春天");
		enumMap.put(Season.SUMMER, "夏天");
		enumMap.put(Season.AUTUMN, "秋天");
		enumMap.put(Season.WINTER, "冬天");
		
		System.out.println(enumMap.get(Season.SPRING));
		
	}

}


enum Season {
	SPRING, SUMMER, AUTUMN, WINTER;
	
}
