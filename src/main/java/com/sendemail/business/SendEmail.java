package com.sendemail.business;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public void send(String from, String to, String subject, String text, String pass) throws IOException {

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS less vulnerability against SSL
		System.out.println("Inicia sesion en Gmail como " + from + ":");

		final String EMAIL = from;
		final String PASSWORD = pass;
		System.out.println(EMAIL + " " + PASSWORD);
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL, PASSWORD);
			}
		});

		try {
			System.out.println("entratry");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);
			System.out.println("Sent");

		} catch (MessagingException err) {
			err.printStackTrace();
		}
	}

}
