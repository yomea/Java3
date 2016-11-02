package com.defaultAdapterModel;

/**
 * 只想实现a方法，其他的不想实现
 * @author may
 *
 */
public class Adaptee extends TargetAdapter {

	@Override
	public void a() {
		System.out.println("我只对a方法兴趣，我不想去实现一大堆的方法！");
	}

	
	
}
