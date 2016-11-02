package com.swingTest;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * 画几何图形
 * @author may
 *
 */
public class MyGame extends JFrame {

	private static final long serialVersionUID = 6719627071124599012L;

	public MyGame() {
		this.setSize(500,500);
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(100, 100, 200, 200);
		g.drawRect(100, 100, 200, 200);
		Color c = g.getColor();
		g.setColor(Color.red);
		g.drawOval(100, 100, 200, 200);
		g.setColor(c);
	}
	
	public static void main(String[] args) {
		new MyGame();
	}
}
