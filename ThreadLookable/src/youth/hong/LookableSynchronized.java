package youth.hong;

public class LookableSynchronized {

	private int num = 1;

	private boolean ready = false;

	private int result = 0;

	private class ThreadTest extends Thread {

		private boolean flag = true;

		public ThreadTest(boolean flag) {
			this.flag = flag;
		}

		@Override
		public void run() {
			if (flag) {
				write();
			} else {
				read();
			}

		}

	}

	/**
	 * synchronized���˽���ͬ���⣬�����Խ����ڴ�Ŀɼ��ԣ�����֤�������߳���ʹ�ù������ʱһ����ȥ���ڴ��м��ع��������
	 * ȷ����ִ���Ը�����ǰ���µġ�
	 */
	private void write() {
		synchronized (this) {
			if (ready) {
				result = num * 3;

			}
		}
		System.out.println("result��ֵ��" + result);
	}

	private synchronized void read() {
		synchronized (this) {
			ready = true;
			num = 2;
		}

	}

	public static void main(String[] args) {

		LookableSynchronized lu = new LookableSynchronized();
		ThreadTest th1 = lu.new ThreadTest(true);
		ThreadTest th2 = lu.new ThreadTest(false);
		th2.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th1.start();
	}

}
