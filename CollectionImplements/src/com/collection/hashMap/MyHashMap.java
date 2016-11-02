package com.collection.hashMap;

import java.util.LinkedList;

/**
 * hashmap是由数组和链表一起构成的
 * 由于使用的是hashCode，顺序不能保证，它是无顺序的。
 * @author may
 *
 * @param <E>
 * @param <U>
 */
public class MyHashMap<E, U> {
	
	private Object[] elementData = null;
	
	private int size;
	
	private int cacaptiy = 10;
	
	public MyHashMap() {
		
		elementData = new Object[cacaptiy];
	}
	
	
	
	@SuppressWarnings("unchecked")
	public boolean put(E key, U value) {
		int hashCode = Math.abs(key.hashCode());
		MyEntry entry = new MyEntry(key, value);
		LinkedList<MyEntry> linkedList = (LinkedList<MyEntry>) elementData[hashCode % cacaptiy]; 
		//key的hashCode可能会重复,需要做判断
		if(linkedList != null) {
			boolean flag = false;
			for(int i = 0; i < linkedList.size(); i++) {
				if(linkedList.get(i).getKey().equals(key)) {
					
					linkedList.get(i).setValue(value);
					flag = true;//return;
					break;
				}
			} 
			if(!flag) {
				
				linkedList.add(entry);
				size ++;
			}
			
		} else {
			linkedList = new LinkedList<MyEntry>();
			linkedList.add(entry);
			if(size == cacaptiy) {
				esureCacaptiy(cacaptiy);
			}
			elementData[hashCode % cacaptiy] = linkedList;
			size ++;
		}
		
		
		return true;
	}
	
	public void esureCacaptiy(int increment) {
		Object[] obj = new Object[cacaptiy + increment];
		cacaptiy = cacaptiy + increment;
		System.arraycopy(elementData, 0, obj, 0, elementData.length);
		elementData = obj;
	}
	
	@SuppressWarnings("unchecked")
	public U get(E key) {
		int hashCode = key.hashCode();
		LinkedList<MyEntry> linkedList = (LinkedList<MyEntry>) elementData[hashCode % cacaptiy]; 
		if(linkedList != null) {
			
			for(int i = 0; i < linkedList.size(); i++) {
				if(linkedList.get(i).getKey().equals(key)) {
					
					return (U) linkedList.get(i).getValue();
					
				}
				
			}
			
		}
		
		return null;
		
	}
	
	public int size() {
		
		return size;
	}
	

}
