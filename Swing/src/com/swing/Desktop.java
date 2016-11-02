package com.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.swing.plane.PanelGame;
import com.swing.sunModel.SunModel;
/**
 * 获取文件的图标
	FileSystemView fileSystemView = FileSystemView.getFileSystemView();
	ImageIcon icon = (ImageIcon) fileSystemView.getSystemIcon(file);
	BufferedImage i = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
	i.getGraphics().drawImage(icon.getImage(), 0, 0, null);
	File out = new File("src/lib/hello.png");
	try {
		ImageIO.write(i, "png", out);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 * @author may
 *
 */
public class Desktop extends JFrame {
	
	
	private static final long serialVersionUID = 3899092629742973479L;
	
	private JDesktopPane desktop = null;//定义桌面面板
	private JLabel backgroundImage = null;//定义桌面背景
	private MouseOption mouseOption = new MouseOption();//鼠标监听对象

	public Desktop(String title) {
		super(title);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//得到系统屏幕的大小
		Dimension dimension = toolkit.getScreenSize();
		//设置布局管理为BorderLayout
		this.setLayout(new BorderLayout());
		int width = (int)dimension.getWidth();
		int height = (int)dimension.getHeight() - 100;
		this.setSize(width, height);
		desktop = new JDesktopPane();
		backgroundImage = new JLabel();
		//创建一个空的的图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		BufferedImage ad = null;
		try {
			//读取背景图
			ad = ImageIO.read(this.getClass().getResource("/lib/rapeFlower.jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//将背景图按比例缩放重新画到之前创建的空图片
		g.drawImage(ad, 0, 0, width, height, null);
		//转化为Icon类图片
		ImageIcon img = new ImageIcon(image);
		backgroundImage.setIcon(img);
		//设置存放背景图的背景标签的位置和大小
		backgroundImage.setBounds(new Rectangle(0, 0, width, height));
		
		//创建按钮
		JButton myCompute = new JButton();
		myCompute.setIcon(new ImageIcon(this.getClass().getResource("/lib/computer.png")));
		myCompute.setBounds(20, 20, 48, 48);
		//设置按钮为透明
		myCompute.setContentAreaFilled(false);
		//除去边框
		myCompute.setBorderPainted(false);
		//添加事件监听
		myCompute.addMouseListener(mouseOption );
		//设置它的文本标识
		myCompute.setText("compute");
		//添加到桌面，并且比设置它的层次，比背景图更高一个层次，否侧会被背景图遮住，看不见
		desktop.add(myCompute, Integer.MIN_VALUE + 1);
		
		JButton myNotebook= new JButton();
		myNotebook.setIcon(new ImageIcon(this.getClass().getResource("/lib/notebook.png")));
		myNotebook.setBounds(20, 88, 48, 48);
		myNotebook.setContentAreaFilled(false);
		myNotebook.setBorderPainted(false);
		myNotebook.addMouseListener(mouseOption);
		myNotebook.setText("notebook");
		desktop.add(myNotebook, Integer.MIN_VALUE + 1);
		
		
		JButton myPanel= new JButton();
		myPanel.setIcon(new ImageIcon(this.getClass().getResource("/lib/paper_plane.png")));
		myPanel.setBounds(20, 156, 48, 48);
		myPanel.setContentAreaFilled(false);
		myPanel.setBorderPainted(false);
		myPanel.addMouseListener(mouseOption);
		myPanel.setText("panel");
		desktop.add(myPanel, Integer.MIN_VALUE + 1);
		
		JButton mySunModel = new JButton();
		mySunModel.setIcon(new ImageIcon(this.getClass().getResource("/lib/earth.net.png")));
		mySunModel.setBounds(20, 224, 48, 48);
		mySunModel.setContentAreaFilled(false);
		mySunModel.setBorderPainted(false);
		mySunModel.addMouseListener(mouseOption);
		mySunModel.setText("sunModel");
		desktop.add(mySunModel, Integer.MIN_VALUE + 1);
		
				
		desktop.add(backgroundImage, new Integer(Integer.MIN_VALUE));
		
		
		this.getContentPane().add(desktop, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	private class MouseOption extends MouseAdapter {
		private int count;
		private Timer timer = new Timer();
		private String str = null;
		
		private class MyTimerTask extends TimerTask {
			JButton button = null;
			
			
			public MyTimerTask(JButton button) {
				this.button = button;
				
			}
			
			


			@Override
			public void run() {
				//超过0.4s且点击了一次
				if(count == 1) {
					count = 0;
				}
				//在0.4s内点击两次
				if(count == 2) {
					//由于这里的字符串使用的是直接赋值的字面量方式，所以可以直接使用等号来判断是否相等
					switch(str) {
					case "fileChooser" : 
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
						fileChooser.showOpenDialog(Desktop.this);
						File file = fileChooser.getSelectedFile();
						if(file != null) {
							
							System.out.println(file.getAbsolutePath());
							
						}
						break;
					case "notebook" : 
						//调用windows系统自带的notepad
						/*try {
							Runtime.getRuntime().exec("notepad");
						} catch (IOException e) {
							e.printStackTrace();
						}*/
						//调用自个写的一个特简易的记事本程序
						Notepad notepad = new Notepad();
						desktop.add(notepad);
						notepad.toFront();
						
						break;
					case "compute" :
						//打开windows的文件管理器
						try {
							java.awt.Desktop.getDesktop().open(new File(System.getProperty("user.home")));
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "panel" : 
						//启动飞机大战游戏
						new PanelGame();
						break;
						
					case "sunModel" :
						//启动太阳系模型，虽然没啥用，用来装B
						new SunModel();
						break;
					}
					
					button.setContentAreaFilled(false);
					count = 0;
				}
				
			}
			
			
		}
		
		/**
		 * 添加鼠标点击事件
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setContentAreaFilled(true);
			str = button.getText();
			count ++;//用于记录点击次数
			//定制双击事件，使用定时器，每次点击后，延时0.4
			timer.schedule(new MyTimerTask(button), 400);
			
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		new Desktop("桌面");
	}
	

}
