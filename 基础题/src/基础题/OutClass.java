package 基础题;

public class OutClass {
	
	private String name = "youth";
	
	public OutClass(String name) {
		OutClass.this.name = name;
	}
	
	public class InnerClass{
		
		public InnerClass(String name) {
			OutClass.this.name = name;
		}
		
	}
		
}
