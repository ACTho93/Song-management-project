package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDAO;
import util.AuthUtil;

public class AdminEditContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;   
    public AdminEditContactController() {
        super();
        contactDAO = new ContactDAO();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
	
		int cid = 0;
		try {
			cid =Integer.parseInt(request.getParameter("cid"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/contacts?error=1");
			return;
		}
		
		Contact itemContact = contactDAO.getItem(cid);
		if(itemContact != null) {
			request.setAttribute("itemContact", itemContact);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/contact/edit.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+ "/admin/contacts?error=2");
			return;
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		int cid = 0;
		try {
			cid =Integer.parseInt(request.getParameter("cid"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/contacts?error=1");
			return;
		}
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String webside = request.getParameter("webside");
		String message = request.getParameter("message");
		
		Contact item = new Contact(cid, name, email, webside, message);
		
		if(contactDAO.editContactAdmin(item) > 0) {
			response.sendRedirect(request.getContextPath()+ "/admin/contacts?msg=3");
			return;
		} else {
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/contact/edit.jsp?error=2");
			rd.forward(request, response);
			return;
		}
		
		
		
		
	}

}
