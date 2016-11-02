package com.swing.sunModel;

import java.awt.Graphics;

/**
 * 行星的抽象类
 * @author may
 *
 */
public interface Star {
	
	public int getX();
	
	public int getY();
	
	public int getWidth();
	
	public int getHeight();
	
	public void draw(Graphics g);

}
