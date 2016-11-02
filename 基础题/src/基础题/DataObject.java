package 基础题;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class DataObject implements Serializable {
	
	public static int i = 0;
	
	public transient String word = "";
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public void setI(int i) {
		DataObject.i = i;
	}
	
	public static void main(String[] args) throws Exception {
		DataObject dataObject = new DataObject();
		dataObject.setWord("123");
		dataObject.setI(2);
		File file = new File("D:\\temp\\heheda.txt");
		OutputStream outputStream = new FileOutputStream(file);
		InputStream inputStream = new FileInputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(dataObject);
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		DataObject obj = (DataObject) objectInputStream.readObject();
		System.out.println(obj.word);
		System.out.println(obj.i);
		outputStream.close();
		objectOutputStream.close();
		objectInputStream.close();
		
	}
	
	
	

}
