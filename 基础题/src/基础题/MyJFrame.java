package 基础题;

import java.awt.BorderLayout;



import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class MyJFrame extends JFrame {
	
	private JTextField tf_username = null;
	
	private JTextField tf_phone = null;
	
	private JButton button = null;
	
	private JPanel jPanel;
	
	
	public MyJFrame(String title) {
		
		super(title);
		
	}
	
	private void launchJFrame() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 60));
		this.setLocation(450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		jPanel = new JPanel(new GridLayout(3, 1, 0, 30));
		tf_username = new JTextField(8);
		tf_phone = new JTextField(8);
		button = new JButton("Done");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = tf_username.getText();
				String phone = tf_phone.getText();
				System.out.println(username + "--" + phone);
			}
		});
		this.add(jPanel);
		jPanel.add(tf_username);
		jPanel.add(tf_phone);
		jPanel.add(button);
		this.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		MyJFrame myJFrame = new MyJFrame("frame");
		myJFrame.launchJFrame();
	}
	
	
	

}
