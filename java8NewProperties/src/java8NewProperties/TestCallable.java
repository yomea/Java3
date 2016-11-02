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
		//���string��ʾcall��������ֵ������
		FutureTask<String> ft = new FutureTask<String>(callable);
		new Thread(ft).start();
		//�õ�call()���ص�ֵ
		System.out.println(ft.get());
	}
}