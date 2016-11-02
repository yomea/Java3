package com.genericInterface.generic;

public  interface Father<T, E> {
	//T Job;泛型不可以使用在属性上，因为接口的属性是static的，static的变量属于这个类的
	//所有对象的属性，大家都可以访问到它，要是每个对象定义的泛型不同，如Father<job, mother>与Father<Object, Mother>
	//那么这个静态的属性就不知道是Job类型还是Object类型

	
	//E wife;
	
	public  T getJob();
	
	public  E getWife();
	
}
/**
 * 泛型的擦除，就是不写泛型，与Object类似，但不等同与Object，这种做法
 * 期间将不会对它进行泛型检查
 * @author may
 *
 */
class Son implements Father {

	@Override
	//泛型的擦除，会把原来的T看做是Object，所以说类似于Object
	public Object getJob() {
		return null;
	}

	@Override
	public Object getWife() {
		return null;
	}
	
	
	
	
}
/**
 * 父类继续保留了泛型，那么子类也要保留
 * @author may
 *
 * @param <T>
 */
class Son2<T> implements Father<T, Mother> {

	@Override
	public T getJob() {
		return null;
	}

	@Override
	public Mother getWife() {
		return null;
	}

}
/**
 * 父类没有保留泛型，那么子类也不会保留
 * @author may
 *
 */
class Son3 implements Father<Job, Mother> {

	@Override
	public Job getJob() {
		return null;
	}

	@Override
	public Mother getWife() {
		return null;
	}

}
/**
 * 可以扩充
 * @author may
 *
 * @param <T>
 * @param <E>
 * @param <A>
 * @param <B>
 */
class Son4<T, E, A, B> implements Father<T, E> {

	@Override
	public T getJob() {
		return null;
		
	}

	@Override
	public E getWife() {
		return null;
		
	}
	
	
	
}

/*
 * 扩充
 */
class Son5<T, E> implements Father<Job, Mother> {
	T t = null;

	@Override
	public Job getJob() {
		return null;
	}

	@Override
	public Mother getWife() {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T set(E e) {
		t = (T) e;
		return t;
	}

}

