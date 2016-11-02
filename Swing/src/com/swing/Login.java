package com.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * java中最常用的三种布局管理器 ，布局管理器中的控件将失去setSize与setBound的功能,不过放到队列动画中还是，
 * 并且延时240ms以上才有效 1、BorderLayout
 * --》分为东西南北中，具有自动伸缩的能力，也就是你的控件是多大，相当于html中的内联元素
 * 就会扩张到多大，直到所有的控件充满你设置的JFrame空间位置，东，向西伸缩，高度默认充满父控件，中，向四周伸缩，
 * 四周没有被占用空间，将会向四周充满
 * 西，向东伸缩，，高度充满父控件，南，向北伸缩，宽度充满父控件，北，向南伸缩。宽度充满父控件 2、GridLayout --
 * 》网格布局，根据行列数和水平以及垂直间距来自动平均分配空间 3、FlowLayout --
 * 》流布局，可以设置它从什么位置开始布局，空间为控件默认的大小，相当于html中的内联元素
 * 
 * @author may
 *
 */

public class Login extends JFrame {

	private static final long serialVersionUID = 5083131604476590600L;

	private JPanel main;// 主体
	private JPanel header;// 头部panel
	private JPanel body;// 窗体
	// 布局管理的每个空位只能放一个控件，所以需要放JPanel
	private JPanel username;// 用户名输入栏
	private JPanel password;// 用户密码输入栏
	private JLabel name_label;
	private JTextField name_text;
	private JLabel pass_label;
	private JLabel header_text;
	private JPanel login;
	private JButton submit;
	private JPasswordField pass_text;
	private JLabel tip;

	public Login() {
		this.setSize(320, 250);
		// 窗口不能变
		this.setResizable(false);
		// 头部panel，类似html页面的div
		header = new JPanel();
		
		header_text = new JLabel("<html>登陆界面</html>");
		// 设置水平居中
		header_text.setHorizontalAlignment(JLabel.CENTER);
		// 设置字体
		header_text.setFont(new Font("宋体", Font.BOLD, 18));
		// 设置背景色
		// 在布局管理器中设置控件的大小是无效的
		// header_text.setSize(300, 20);
		// 设置手型
		header.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		// 设置边框
		header.setBorder(new LineBorder(new Color(242, 242, 242)));
		header.add(header_text);
		// 设置登陆体5行1列，垂直10像素
		body = new JPanel(new GridLayout(5, 1, 0, 10));
		body.setBackground(Color.white);
		// 设置水平布局，默认水平居中开始
		username = new JPanel(new FlowLayout(FlowLayout.CENTER));
		username.setBackground(Color.white);
		// 用户名
		name_label = new JLabel("<html>账 号:</html>");
		// 用户名输入框
		name_text = new JTextField(15);
		username.add(name_label);
		username.add(name_text);
		// 密码输入
		pass_label = new JLabel("密 码:");
		pass_text = new JPasswordField(15);
		password = new JPanel();
		password.setBackground(Color.white);
		password.add(pass_label);
		password.add(pass_text);
		// 登陆
		submit = new JButton("登陆");
		submit.setBackground(Color.green);
		submit.setFont(new Font("宋体", Font.BOLD, 15));
		submit.setForeground(Color.white);
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = name_text.getText().trim();
				String password = new String(pass_text.getPassword()).trim();
				if("".equals(username)) {
					 //对话框
					JOptionPane.showMessageDialog(Login.this, "请输入账号！！！", "警告", JOptionPane.WARNING_MESSAGE, new ImageIcon(this.getClass().getResource("/lib/warning.png")));
				} else if("".equals(password)) {
					String[] options = {"好的","不好","取消"};
					int flag = JOptionPane.showOptionDialog(Login.this, "请输入密码！！！", "警告", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon(this.getClass().getResource("/lib/warning.png")), options, "好的");
					if(1 == flag) {
						System.exit(0);
						
					}
				}
				
			}
		});
		login = new JPanel(new FlowLayout());
		login.setBackground(Color.white);
		login.add(submit);
		// 空白panel，只是为了占位
		JPanel jpanel1 = new JPanel();
		jpanel1.setBackground(Color.white);
		body.add(jpanel1);
		body.add(username);
		body.add(password);
		body.add(login);
		tip = new JLabel("注册新用户|忘记密码？");
		tip.setHorizontalAlignment(JLabel.RIGHT);
		tip.setVerticalAlignment(JLabel.NORTH);
		body.add(tip);
		main = new JPanel(new BorderLayout());
		main.add(body);
		main.setBackground(Color.white);
		main.add(header, BorderLayout.NORTH);
		this.getContentPane().add(main, BorderLayout.CENTER);
		// 设置为水平居中
		this.setLocationRelativeTo(null);
		// 设置点击关闭按钮时，关闭窗体，推出程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Login();
	}

}
