package com.reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用在gc发生时，被弱引用的对象内存就会被回收
 * @author may
 *
 */
public class Reference {
	
	public static void main(String[] args) {
		
		String str = "Hello World";
		
		String str2 = new String("youth");
		
		WeakReference<String> weakReference = new WeakReference<String>(str);
		WeakReference<String> weakReference2 = new WeakReference<String>(str2);
		str = null;
		//如果这里不设置成null，由于存在str2这个强引用在，就不会被回收
		str2 = null;
		System.out.println(weakReference.get());
		System.out.println(weakReference2.get());
		System.gc();
		System.runFinalization();
		//由于String常量是强引用类型，所以不会被回收。
		System.out.println(weakReference.get());
		//这个是new出来的String所以会被回收
		System.out.println(weakReference2.get());
	}

}
