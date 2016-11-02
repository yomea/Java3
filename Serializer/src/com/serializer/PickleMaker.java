package com.serializer;

import java.awt.FlowLayout;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class PickleMaker extends JFrame{
	
	private static final long serialVersionUID = -6051888901891549525L;

	public PickleMaker(String text, int size) {
		
		super("Pickle Maker");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 300, 300, 300);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
		JTextField tf = new JTextField(text, size);
		PickleMaker.serialize(tf);
		this.add(tf);
		this.setVisible(true);
		
		
	}
	
	public static void serialize(JTextField tf) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("src/myTextField.ser");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(tf);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fileOutputStream != null) {
					fileOutputStream.close();
				}
				if(objectOutputStream != null) {
					objectOutputStream.close();
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new PickleMaker("test", 8);
		
		
	}

}
