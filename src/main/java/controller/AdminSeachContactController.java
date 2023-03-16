package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDAO;
import util.DefineUtil;

public class AdminSeachContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;   
    public AdminSeachContactController() {
        super();
        contactDAO = new ContactDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String seach = request.getParameter("seach");
		int numberOfItems = contactDAO.numberOfItems();
		
		int numberOfPages = (int) Math.ceil((float) numberOfItems/DefineUtil.NUMBER_PER_PAGE);
		
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
		}
		
		
		
		int numberPage = DefineUtil.NUMBER_PER_PAGE;
		int offset = (currentPage-1)* numberPage;
		
		if(currentPage > numberOfPages || currentPage < 1) {
			
			currentPage = 1;
		}
		
		request.setAttribute("numberOfItems", numberOfItems);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("numberPage", numberPage);
		request.setAttribute("currentPage", currentPage);
		
		ArrayList<Contact> listC = contactDAO.getseachPagination(seach, offset);
		
		if(listC != null && listC.size() > 0) {
			request.setAttribute("listC", listC);
			request.setAttribute("seach", seach);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/contact/seach.jsp?msg=1");
			rd.forward(request, response);
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/contact/noseach.jsp?error=1");
			return;
		}
	}

}
