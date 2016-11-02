package 基础题;

public class CloneTest implements Cloneable {
	
	public static void main(String[] args) throws Exception {
		CloneTest cloneTest1 = new CloneTest();
		
		CloneTest cloneTest2 = (CloneTest) cloneTest1.clone();
		
		System.out.println(cloneTest1 == cloneTest2);
		
	}

}
