package com.collection.hashSet;

import java.util.HashMap;

/**
 * HashSet底层是用HashMap实现的，是无序的
 * @author may
 *
 * @param <K>
 */
public class MyHashSet<K> {
	
	private HashMap<K, Object> map = null;
	
	//map的值是固定的
	private final static Object PRESENT = new Object();
	
	public boolean add(K obj) {
		map.put(obj, PRESENT);
		return true;
		
	}
	
	public boolean remove(K obj) {
		map.remove(obj);
		
		return true;
	}
	
}
