package Assignment_Components;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailSender implements SendMail {
	@Override
	public void send(ArrayList<ArrayList<String>> arr) {
		try {
			// TODO Auto-generated method stub
			Properties data = new Properties();
			FileReader read = new FileReader("gmailDatas.properties");
			data.load(read);
			String to = data.getProperty("recepient");
			String from = data.getProperty("username");
			String password = data.getProperty("password");
			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "465");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.socketFactory.port", "465");
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
			});
			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				message.setSubject("Invoice Details");
				TextConverter textConverter=TextConverter.createObject();
				String mesg = textConverter.convert(arr);
				message.setText(mesg);
				Transport.send(message);

				System.out.println("Mail Sent...");

			} catch (MessagingException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
		}
	}
}
