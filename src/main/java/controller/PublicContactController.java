package controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDAO;

public class PublicContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;
    public PublicContactController() {
        super();
        contactDAO = new ContactDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/public/contact.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String emailto = request.getParameter("emailto");
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		String website = request.getParameter("website");
//		
//		SendMail.send(emailto, name, email, password, website, message);
//        //System.out.println("Mail send successfully");
//        
		Contact item = new Contact(0, name, emailto, website, message);
		
		
		String username = "thodhnt@gmail.com";
	   	  Properties properties = new Properties();
	   	  properties.setProperty("mail.smtp.auth","true");
	   	  properties.setProperty("mail.smtp.starttls.enable", "true");
	   	  properties.setProperty("mail.smtp.host", "smtp.gmail.com");
	   	  properties.setProperty("mail.smtp.port", "587");
	   	  Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
	   		  protected PasswordAuthentication getPasswordAuthentication() {
	   			  String username ="thodhnt@gmail.com";
	   			  String password="zaesriodpkxtglwe";
	   			  return new PasswordAuthentication(username, password);	    			  
	   		  }  
	   	  });
	   	 try {
	   		 MimeMessage mess = new MimeMessage(session);
		    	  mess.setFrom(new InternetAddress(username));
				  mess.setRecipient(Message.RecipientType.TO, new InternetAddress(emailto));
				  mess.setSubject("Nội dung thư");
				  mess.setText("Ten: "+name+ "\nmess:" + message);
				  //send mess
				  Transport.send(mess);
				  System.out.println("send succesfull!!!");
					
				 
			} catch (Exception e) {
				// TODO: handle exception
			}
		if(contactDAO.addItem(item) > 0) {
			response.sendRedirect(request.getContextPath()+"/contact?msg=1");
			return;
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("/public/contact.jsp?error=1");
			rd.forward(request, response);
		}
		
		
		
	}

}
