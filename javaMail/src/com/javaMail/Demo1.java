package com.javaMail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Demo1 {

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		Message msg = new MimeMessage(session);
		msg.setText("你好吗？");
		msg.setFrom(new InternetAddress("lili@sohu.com"));

		Transport transport = session.getTransport();
		transport.connect("smtp.sina.com", 25, "hong_mail123", "WUZHENHONG1127");
		transport.sendMessage(msg, new Address[] { new InternetAddress("951645267@qq.com") });

		// transport.send(msg,new Address[]{new
		// InternetAddress("itcast_test@sohu.com")});
		transport.close();

	}

}
