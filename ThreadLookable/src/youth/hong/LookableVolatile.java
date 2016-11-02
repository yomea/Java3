package youth.hong;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LookableVolatile {

	private Lock lock = new ReentrantLock();
	
	private volatile int num = 0;

	public int getNum() {
		return num;
	}
	
	public void increase() {
		//����
		lock.lock();
		try {
			num++;
			
		} finally {
			//����
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		LookableVolatile lookableVolatile = new LookableVolatile();
		for(int i = 0; i < 500; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					lookableVolatile.increase();
					
				}
				
			}).start();
		
		}
		
		while(Thread.activeCount() > 1) {
			/**
			 * ȷ�����е����߳�ִ���꣬�ڴ�ӡ������
			 */
			
		}
		
		/**
		 * ʵ��֤��volatileֻ��֤�ɼ��ԣ����ܱ�֤ԭ���ԣ�������Ҫ����
		 */
		System.out.println("num:" + lookableVolatile.num);
	}
	
}
