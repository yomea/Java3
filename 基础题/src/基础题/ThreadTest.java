package 基础题;

public class ThreadTest implements Runnable {

	@Override
	public void run() {
		
		System.out.println("我是守护进程！");
		
	}
	
	
	public static void main(String[] args) throws Exception {
		Thread thread = new Thread(new ThreadTest());
		thread.setDaemon(true);
		System.out.println();
		thread.start();
		//thread.setDaemon(true);必须放在start前
	}
	
	

}
