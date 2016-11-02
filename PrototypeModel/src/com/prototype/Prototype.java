package com.prototype;

public interface Prototype extends Cloneable {
	
	Prototype deepClone();
	
	Prototype shallowClone();
	
}
