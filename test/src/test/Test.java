package test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	private String name;
	private String password;
	private int age;
	
	
	
	@Override
	public String toString() {
		return "Test [name=" + name + ", password=" + password + ", age=" + age + "]";
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public static void main(String[] args) {
		System.out.println("helloWorld!");
		List<String> string = new ArrayList<String>();
		string.add("com");
		string.add("taotao");
		List<?> list = string;
		//list.add("string");报错了!!!
		
		System.out.println(list.get(0).getClass());
	}
	
	
}
