package 基础题;

public class Break {
	
	public static void main(String[] args) {
		
		out:
			for(int i = 0; i < 10; i++) {
				for(int a = 0; a < 10; a++) {
					if(a == 9) {
						System.out.println(i);
						break out;
					}
				}
			}
		
	}

}
