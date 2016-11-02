package com.swingTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

/**
 * 斜线运动
 * @author may
 *
 */
public class MyGame2 extends JFrame {

	private static final long serialVersionUID = 6719627071124599012L;
	
	private int x;
	private int y;
	
	private BufferedImage bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);

	public MyGame2() {
		this.setSize(500,500);
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		new Thread(new MyThread()).start();
		bufferedImage.getGraphics().fillRect(0, 0, 500, 500);
		
	}
	
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		//重刷屏幕，覆盖之前画的
		g.drawImage(bufferedImage, 0, 0, null);
		g.setColor(Color.red);
		g.fillOval(x, y, 200, 200);
		g.setColor(c);
		x += 3;
		y += 3;
	}
	
	public static void main(String[] args) {
		new MyGame2();
	}
	public class MyThread implements Runnable {

		@Override
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}
