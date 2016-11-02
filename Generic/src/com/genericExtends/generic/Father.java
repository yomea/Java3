package com.genericExtends.generic;

/**
 * 泛型之定义在class的类后面，如：class Father<T, E>
 * 还有方法上,如：public static <A> A getXXX(A a ) 
 * @author may
 *
 * @param <T>
 * @param <E>
 */
public  class Father<T, E> {
	public T Job;
	
	public E wife;
	
	public  T getJob(){ 
		return Job; 
	}
	
	public  E getWife(){
		return wife;
	}
	//<A>声明泛型方法
	public static <A> A getXXX(A a ) {
		return a;
	}
	
	public static void main(String[] args) {
		Father father = new Father();
		print(father);//编译不会报错，因为泛型的擦除不会进行类型的检查
		Father<Object, Mother> father2 = new Father<Object, Mother>();
		//print(father2);//编译出错，类型不匹配
	}
	
	public static void print(Father<Job, Mother> father) {
		
		System.out.println(father);
	}
	
	//内部类继承的父类的泛型在外部类定义了，那么内部类不会强迫声明<T>
	private class Son6 extends Person<T>{
	}
	//内部类继承的父类的泛型在外部类没定义了，它不认识这个符号那么内部类就会强迫声明<U>
	private class Son7<U> extends Person<U>{
	}
	
}
/**
 * 泛型的擦除，就是不写泛型，与Object类似，但不等同与Object，这种做法
 * 期间将不会对它进行泛型检查
 * @author may
 *
 */
class Son extends Father {

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
 * 父类继续保留了泛型，那么子类也要保留,因为我们new对象的时候
 * 使用的是Son2，而不是Father了，这时候father的T就就应当由子类来决定了类型了
 * @author may
 *
 * @param <T>
 */
//class Son2<U> extends Father<U, Mother> {
class Son2<T> extends Father<T, Mother> {


	/*@Override
	public U getJob() {
		// TODO Auto-generated method stub
		return super.getJob();
	}*/
	
	@Override
	public T getJob() {
		// TODO Auto-generated method stub
		return super.getJob();
	}

	@Override
	public Mother getWife() {
		// TODO Auto-generated method stub
		return super.getWife();
	}

}
/**
 * 父类没有保留泛型，那么子类也不会保留
 * @author may
 *
 */
class Son3 extends Father<Job, Mother> {

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
class Son4<T, E, A, B> extends Father<T, E> {

	@Override
	public T getJob() {
		// TODO Auto-generated method stub
		return super.getJob();
	}

	@Override
	public E getWife() {
		// TODO Auto-generated method stub
		return super.getWife();
	}
	
	
	
}

/*
 * 扩充
 */
class Son5<T, E> extends Father<Job, Mother> {
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

