package com.collection.hashMap;

public class MyEntry {
	
	private Object key;//键
	
	private Object value;//值
	
	public MyEntry(Object key, Object value) {
		this.key = key;
		this.value = value;
		
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	

}
