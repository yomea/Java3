package java8NewProperties;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("java8");
		
		return "HelloWorld!";
	}
	
	public static void main(String[] args) throws Exception {
		TestCallable callable = new TestCallable();
		//这个string表示call方法返回值得类型
		FutureTask<String> ft = new FutureTask<String>(callable);
		new Thread(ft).start();
		//拿到call()返回的值
		System.out.println(ft.get());
	}
}