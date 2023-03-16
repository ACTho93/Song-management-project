package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDAO;

public class AdminAddContacttController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;
    public AdminAddContacttController() {
        super();
        contactDAO = new ContactDAO();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/admin/contact/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String wedside = request.getParameter("wedside");
		String message = request.getParameter("message");
		
		Contact item = new Contact(0, name, email, wedside, message);
		
		if(contactDAO.addcontact(item) > 0 ) {
			response.sendRedirect(request.getContextPath()+ "/admin/contacts?msg=2");
			return;
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/contact/add.jsp?error=1");
			rd.forward(request, response);
		}
		
		
		
		
	}

}
