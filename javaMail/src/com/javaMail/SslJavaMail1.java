package com.javaMail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SslJavaMail1 {
	
	
	
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.qq.com");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			//匿名内部类，继承authenticator
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("951645267", "WUZHENHONG1127");
			}
			
		
		});
		session.setDebug(true);
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("smtp.qq.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("hong_mail123@sina.com"));
		message.setSubject("test");
		message.setSentDate(new Date());
		message.setText("javaMail Test!!!");
		Transport.send(message);
		
		
	}


}
