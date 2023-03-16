package model.bean;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

public class SendMail {

	 public static void send(String emailto, String name, 
             final String email,final String password, String website, String message)
	 { 
	
//		    Properties props = new Properties();
//			 props.put("mail.smtp.host", "smtp.gmail.com");
//		     props.put("mail.smtp.port", "587");		
//		     props.put("mail.smtp.auth", "true");
//		     props.put("mail.smtp.starttls.enable", "true");
//		     props.put("mail.smtp.starttls.required", "true");
//		     props.put("mail.smtp.ssl.protocols", "TLSv1.2");
//			
//			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() 
//			  	  {
//			  	 	 return new PasswordAuthentication(email,password);
//			  	  }
//			});
//			
//			try {
//				
//				MimeMessage messages = new MimeMessage(session);
//				messages.setFrom(new InternetAddress(email));
//				
//				messages.addRecipient(Message.RecipientType.TO,new InternetAddress(emailto));
//				messages.setSubject(name);
//				messages.setSubject(website);
//				messages.setText(message);
//				
//				Transport.send(messages);
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		 
//		 String to = emailto;
//   	  Properties properties = new Properties();
//   	  properties.setProperty("mail.smtp.auth","true");
//   	  properties.setProperty("mail.smtp.starttls.enable", "true");
//   	  properties.setProperty("mail.smtp.host", "smtp.gmail.com");
//   	  properties.setProperty("mail.smtp.port", "587");
//   	  Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
//   		  protected PasswordAuthentication getPasswordAuthentication() {
//   			  String username="thodhnt@gmail.com";
//   			  String password="zaesriodpkxtglwe";
//   			  return new PasswordAuthentication(username, password);	    			  
//   		  }  
//   	  });
//   	 try {
//   		 MimeMessage mess = new MimeMessage(session);
//	    	  mess.setFrom(new InternetAddress(email));
//			  mess.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			  mess.setSubject("Forget Password");
//			  mess.setText("Code:");
//			  //send mess
//			  Transport.send(mess);
//			  System.out.println("send succesfull!!!");
//				System.out.println("OK");
//				return;
//			 
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
 }
}
