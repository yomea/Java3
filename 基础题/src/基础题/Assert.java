package 基础题;

public class Assert {
	
	public static void main(String[] args) {
		assert 1 + 1 == 2;
		System.out.println("assert ok!");
		
		assert 1 + 1 == 3 : "assert error!";
		System.out.println("assert ok!");
	}

}
