package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDAO;
public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDAO categoryDAO;   
    public AdminAddCatController() {
        super();
        categoryDAO = new CategoryDAO();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		String nhap = request.getParameter("nhap");
		
		Category item = new Category(0, nhap);
		if(categoryDAO.AddCatAdmin(item) > 0) {
			response.sendRedirect(request.getContextPath()+ "/admin/cats?msg=1");
			return;
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/add.jsp?error=1");
			rd.forward(request, response);
		}
		
		
		
		
	}

}
