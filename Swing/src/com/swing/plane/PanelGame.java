package com.swing.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.swing.util.ImageLoadUtil;

/**
 * 主类
 * @author may
 *
 */
public class PanelGame extends Frame {

	private static final long serialVersionUID = 6719627071124599012L;
	//我方飞机场
	private List<Panel> Goodpanels = new ArrayList<Panel>();
	//敌军飞机场
	private List<Panel> panels = new ArrayList<Panel>();
	//公共的子弹工厂
	private List<Shell> shells = new ArrayList<Shell>(); 
	//随机
	private Random random = new Random();
	//战场背景
	private static Image image = ImageLoadUtil.loadImage("/lib/bg.jpg");
	//缓冲图
	private BufferedImage buffImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);	
	//爆炸
	private List<Explode> explodes = new ArrayList<Explode>();
	//杀敌数
	public int killEnemyCount = 0;
	//死亡次数
	public int deadCount = 0;
	
	public PanelGame() {
		this.setSize(500,500);
		this.setLocation(300, 100);
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				PanelGame.this.dispose();
			}
			
		});
		//在显示（画窗口前new出来，否则会报空指针异常）
		//panel = new Panel(100,100, false);
		this.addKeyListener(new keyCtrl());
		this.createGoodPanels(1);
		this.setVisible(true);
		new Thread(new MyThread()).start();
		
	}
	
	
	
	public void createPanels(int num) {
		for(int i = 0; i < num; i++) {
			panels.add(new Panel(this, true));
		}
		
	}
	
	public void createGoodPanels(int num) {
		if(Goodpanels.size() <= 0) {
			
			for(int i = 0; i < num; i++) {
				Goodpanels.add(new Panel(452, 250, false, this));
			}
			
		}
	}
	
	
	
	public List<Explode> getExplodes() {
		return explodes;
	}



	public List<Shell> getShells() {
		return shells;
	}



	public List<Panel> getPanels() {
		return panels;
	}
	
	
	

	public List<Panel> getGoodpanels() {
		return Goodpanels;
	}



	@Override
	public void paint(Graphics g) {
		g.drawImage(buffImage, 0, 0, null);
	}
	
	@Override
	public void update(Graphics g) {
		Graphics warG = buffImage.getGraphics();
		warG.fillRect(0, 0, 500, 500);
		warG.drawImage(image, 0, 0, 500, 500, null);
		Color c = warG.getColor();
		warG.setColor(Color.gray);
		warG.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		warG.drawString("击毁敌机：" + killEnemyCount, 10, 50);
		warG.drawString("死亡次数：" + deadCount, 10, 80);
		
		for(int i = 0; i < Goodpanels.size(); i++) {
			Goodpanels.get(i).draw(warG);
			warG.drawString("生命值：" + Goodpanels.get(i).lifeValue, 10, (i+1)*30 + 80);
		}
		warG.setColor(c);
		for(int i = 0; i < panels.size(); i++) {
			panels.get(i).draw(warG);
		}
		for(int i = 0; i < shells.size(); i++) {
			shells.get(i).draw(warG);
		}
		for(int i = 0; i < explodes.size(); i++) {
			explodes.get(i).draw(warG);
		}
		paint(g);
		warG.setColor(c);
		if(this.getPanels().size() < 3) {
			this.createPanels(random.nextInt(6) + 1);
			
		}
	}
	
	
	
	
	public List<Panel> getPanel() {
		return Goodpanels;
	}



	public static void main(String[] args) {
		new PanelGame();
	}
	
	private class keyCtrl extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if(keyCode == KeyEvent.VK_F1) {
				createGoodPanels(1);
				
			}
			
			for(int i = 0; i < Goodpanels.size(); i++) {
				
				Goodpanels.get(i).keyPressed(e);
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			for(int i = 0; i < Goodpanels.size(); i++) {
				
				Goodpanels.get(i).keyReleased(e);
			}
		}
		
		
		
	}
	
	private class MyThread implements Runnable {

		@Override
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}
