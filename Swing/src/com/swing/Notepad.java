package com.swing;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 简易笔记本
 * @author may
 *
 */
public class Notepad extends JInternalFrame {

	private static final long serialVersionUID = -6148113299360403243L;

	private JMenuBar menuBar = null;//菜单栏
	private JTextArea textArea = null;//输入框
	private JScrollPane scrollPane = null;//带滚动条的面板
	private MyAction myAction = new MyAction();//事件对象
	private String dir = null;//保存打开过或者保存过文件的文件夹
	private String fileDir = null;//保存你打开文件的文件夹
	private boolean ctrlClick = false;//用于检测当前，你是否按下了Ctrl键
	private boolean sClick = false;//用于检测当前，你是否按下了s键

	public Notepad() {
		super("notepad");
		this.setSize(600, 500);//窗口的大小
		menuBar = new JMenuBar();//创建菜单栏
		JMenu menu1 = new JMenu("文件");//创建菜单
		JMenuItem menuItem2 = new JMenuItem("打开");//创建菜单项
		JMenuItem menuItem4 = new JMenuItem("保存");//创建菜单项
		menuItem4.addActionListener(myAction);//绑定事件
		menuItem2.addActionListener(myAction);//绑定事件
		JMenuItem menuItem3 = new JMenuItem("打开文件所在目录");
		menuItem3.addActionListener(myAction);
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		menu1.add(menuItem4);

		JMenu menu2 = new JMenu("版本信息");
		menu2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//定义弹窗后的按钮的文字
				String[] options = {"确定"};
				//创建一个弹窗
				JOptionPane.showOptionDialog(Notepad.this, "version:0.1-snapshoot", "关于", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, "确定");
			}
			
			
		});
		menuBar.add(menu1);
		menuBar.add(menu2);
		this.setJMenuBar(menuBar);
		textArea = new JTextArea();
		//添加键盘检测事件
		textArea.addKeyListener(new keyOption());
		// this.getContentPane().add(menuBar, BorderLayout.NORTH);
		//设置字体
		textArea.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		scrollPane = new JScrollPane(textArea);
		//当文本水平溢出时出现滚动条
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//当文本垂直溢出时出现滚动条
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollPane);
		//居中显示
		//this.setLocationRelativeTo(null);
		//最小化
		this.setIconifiable(true);
		//可关闭
		this.setClosable(true);
		//可改变大小
		this.setResizable(true);
		//销毁窗口
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

	/**
	 * 打开文件选择和保存对话框
	 * @param flag
	 */
	public void openChooseDialog(String flag) {
		BufferedReader reader = null;
		JFileChooser fileChooser = new JFileChooser();
		if(dir != null) {
			//定位上次打开和保存过文件的位置
			fileChooser.setCurrentDirectory(new File(dir));
		}
		
			switch(flag) {
			case "打开" :
				//指定它的父窗口
				fileChooser.showOpenDialog(Notepad.this);
				//定义文件选择模式
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				File file = fileChooser.getSelectedFile();
				if(file != null) {
					try {
						//得到选择文件的路径
						dir = file.getAbsolutePath();
						fileDir = dir;
						dir = dir.substring(0, dir.lastIndexOf("\\") + 1);
						reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
						String str = reader.readLine();
						textArea.setText("");
						//读取文件内容
						while(str != null) {
							textArea.append(str + "\n");
							str = reader.readLine();
							
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						if(reader != null) {
							try {
								reader.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
					}
				}
				
				break;
			case "保存" :
				//打开保存文件的对话框
				fileChooser.showSaveDialog(Notepad.this);
				//得到保存文件后的文件对象
				File saveFile = fileChooser.getSelectedFile();
				if(saveFile != null) {
					//得到保存文件的路径
					String absolutePath = saveFile.getAbsolutePath();
					fileDir = absolutePath;
					FileOutputStream out = null;
					BufferedWriter buffOut = null;
					
					dir = absolutePath.substring(0, absolutePath.lastIndexOf("\\") + 1);
					//保存文件
					try {
						out = new FileOutputStream(absolutePath);
						buffOut = new BufferedWriter(new OutputStreamWriter(out));
						String text = textArea.getText();
						if(text != null) {
							buffOut.write(text);
							
						}
						buffOut.flush();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							if(out != null)  {
								out.close();
								
							}
							if(buffOut != null) {
								buffOut.close();
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
				}
				
				break;
			case "打开文件所在目录":
				if(dir != null) {
					try {
						//打开文件目录
						Desktop.getDesktop().open(new File(dir));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				break;
			}

	}
	
	/**
	 * 事件监听类
	 * @author may
	 *
	 */
	private class MyAction implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem) e.getSource();
			String flag = item.getText();
			switch (flag) {
			case "打开":
				openChooseDialog(flag);
				break;
			case "保存":
				openChooseDialog(flag);
				break;
			case "打开文件所在目录":
				openChooseDialog(flag);
				break;
			}

		}

	}
	/**
	 * 键盘监听内部类
	 * @author may
	 *
	 */
	private class keyOption extends KeyAdapter {
		

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if(17 == keyCode) {
				ctrlClick = true;
			} else if(83 == keyCode) {
				sClick = true;
				
			}
			//判断Ctrl与s键是否按下，按下就开始保存
			if(ctrlClick && sClick) {
				FileOutputStream out = null;
				BufferedWriter buffOut = null;
				
				try {
					if(fileDir != null) {
						out = new FileOutputStream(fileDir);
						buffOut = new BufferedWriter(new OutputStreamWriter(out));
						String text = textArea.getText();
						if(text != null) {
							buffOut.write(text);
							
							
						}
						buffOut.flush();
					} else {
						openChooseDialog("保存");
						
					}
				} catch (Exception ex) {
						ex.printStackTrace();
				} finally {
					try {
						if(out != null)  {
							out.close();
							
						}
						if(buffOut != null) {
							buffOut.close();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
					
					
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if(17 == keyCode) {
				ctrlClick = false;
			} else if(83 == keyCode) {
				sClick = false;
				
			}
		}
		
		
		
		
	} 
	

}
