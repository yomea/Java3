package com.swingTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
/**
 * 椭圆运动
 * @author may
 *
 */
public class MyGame6 extends JFrame {

	private static final long serialVersionUID = 6719627071124599012L;
	
	private int x = 100;
	private int y = 100;
	private double degree = 1;
	
	
	private BufferedImage bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);

	public MyGame6() {
		this.setSize(500,500);
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		new Thread(new MyThread()).start();
		bufferedImage.getGraphics().fillRect(0, 0, 500, 500);
		
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics gg = bufferedImage.getGraphics();
		Color c = g.getColor();
		gg.fillRect(0, 0, 500, 500);
		gg.setColor(Color.red);
		gg.fillOval(x, y, 30, 30);
		gg.setColor(c);
		x = 100 + (int) (100 * Math.cos(degree));
		y = 100 + (int) (100 * Math.sin(degree));
		
		degree += 1;
		
		
		g.drawImage(bufferedImage, 0, 0, null);
	}
	
	
	public static void main(String[] args) {
		new MyGame6();
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
