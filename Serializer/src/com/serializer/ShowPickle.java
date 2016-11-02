package com.serializer;

import java.awt.FlowLayout;
import java.beans.Beans;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class ShowPickle extends JFrame {
	
	private static final long serialVersionUID = -4111331886628693071L;

	public ShowPickle(String srcComponet) {
		
		this.setBounds(200, 300, 300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextField tf = getSerializeComponet(srcComponet);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
		this.add(tf);
		this.setVisible(true);
		
		
	}
	
	public static JTextField getSerializeComponet(String srcComponet) {
		
		JTextField tf = null;
		
		try {
			tf = (JTextField) Beans.instantiate(ShowPickle.class.getClassLoader(), srcComponet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tf;
	}
	
	public static void main(String[] args) {
		new ShowPickle("myTextField");
	
	}

}
