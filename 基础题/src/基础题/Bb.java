package 基础题;

public class Bb extends Object {
	
	static {
		System.out.println("Load B");
	}
	
	public Bb() {
		super();
		System.out.println("create B");
	}
	
	public static void main(String[] args) {
		new AA();
	}
	

}

class  AA extends Bb{
	static {
		System.out.println("Load AA");
	}
	
	public AA () {
		System.out.println("create AA");
	}
	
	
}

