package 基础题;

public class Startic {
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("基础题.hehe");
	}
	

}

class hehe{
	static {
		System.out.println("hehe");
	}
}
