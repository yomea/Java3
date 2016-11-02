package 基础题;

class Xiaoming implements Runnable {

	Xiaohong hong;

	public void setHong(Xiaohong hong) {
		this.hong = hong;
	}

	public synchronized void hello() {
		System.out.println("nihao");
		hong.Iloveyou();
	}

	public synchronized void Iloveyou() {
		System.out.println("Iloveyou");
	}

	@Override
	public void run() {
		hong.hello();

	}

}

class Xiaohong implements Runnable {

	Xiaoming ming;

	public void setMing(Xiaoming ming) {
		this.ming = ming;
	}

	public synchronized void hello() {
		System.out.println("nihao,too");
		ming.Iloveyou();
	}

	public synchronized void Iloveyou() {
		System.out.println("Iloveyou,too");
	}

	@Override
	public void run() {
		ming.hello();
	}

}

public class DeadLocked {

	public static void main(String[] args) {
		Xiaoming xiaoming = new Xiaoming();
		
		Xiaohong xiaohong = new Xiaohong();
		
		xiaoming.setHong(xiaohong);
		xiaohong.setMing(xiaoming);
		
		new Thread(xiaoming).start();
		
		new Thread(xiaohong).start();

	}

}
