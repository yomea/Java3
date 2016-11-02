package com.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Prototype, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5730267042366141834L;

	private String name;
	
	private int age;
	
	private Dog dog;
	
	public Person(String name, int age, Dog dog) {
		this.name = name;
		this.age = age;
		this.dog = dog;
		
	}
	
	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	/**
	 * 深复制，会将dog引用的对象也复制一份
	 */
	
	@Override
	public Prototype deepClone() {
		//创建数组输出流，将对象存到内存中
		ByteArrayOutputStream byteArrayOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		ByteArrayInputStream byteArrayInputStream = null;
		ObjectInputStream objectInputStream = null;
		Person person = null;
		try {
			byteArrayOutputStream = new ByteArrayOutputStream();
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			//将对象存入内存，并复制一份留在堆中
			objectOutputStream.writeObject(this);
			byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			//读取内存，将对象取出
			person = (Person) objectInputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(byteArrayOutputStream != null) {
					
					byteArrayOutputStream.close();
				}
				
				if(objectOutputStream != null) {
					
					objectOutputStream.close();
				}
				
				if(byteArrayInputStream != null) {
					
					byteArrayInputStream.close();
				}

				if(objectInputStream != null) {
					
					objectInputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		}
		return person;
	}

	/**
	 * 浅复制，复制dog对象的引用
	 */
	@Override
	public Prototype shallowClone() {
		Prototype obj = null;
		try {
			obj = (Person)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return obj;
		
	}

		
		

}
