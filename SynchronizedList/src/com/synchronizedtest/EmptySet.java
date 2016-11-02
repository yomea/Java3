package com.synchronizedtest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EmptySet {
	
	public static void main(String[] args) {
		EmptySet.getSet(new HashSet<String>());
	}
	
	public static Set<?> getSet(Set<?> set) {
		
		if(set == null) {
			return Collections.emptySet();
			
		}
		
		return set;
	} 

}
