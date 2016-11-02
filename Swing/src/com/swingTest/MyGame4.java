package com.swingTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
/**
 * 台球运动
 * @author may
 *
 */
public class MyGame4 extends JFrame {

	private static final long serialVersionUID = 6719627071124599012L;
	
	private int x = 0;
	private int y = 30;
	private double degree = 3.14 / 3;
	
	private double speed = 10;
	
	private BufferedImage bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);

	public MyGame4() {
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
		x += (int) (speed * Math.cos(degree));
		y += (int) (speed * Math.sin(degree));
		if(speed > 0) {
			speed -= 0.05;
		}
		
		
		if(x > 500-30 || x < 0) {
			degree = Math.PI - degree;
		}
		if(y < 10 || y > 500 - 30) {
			degree = -degree;
		}
		
		g.drawImage(bufferedImage, 0, 0, null);
	}
	
	
	public static void main(String[] args) {
		new MyGame4();
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
