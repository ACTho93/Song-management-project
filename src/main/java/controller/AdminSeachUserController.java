package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.dao.UsersDAO;
import util.DefineUtil;

@WebServlet("/AdminSeachUserController")
public class AdminSeachUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsersDAO usersDAO; 
    public AdminSeachUserController() {
        super();
        usersDAO=new UsersDAO();  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		String seach = request.getParameter("seach");
		
        int numberOfItems = usersDAO.numberOfItemsseach(seach);
		
		int numberOfPages = (int) Math.ceil((float) numberOfItems/ DefineUtil.NUMBER_PER_PAGE);
		
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}catch (NumberFormatException e) {
		}
		
		// nếu nư người dùng truỳn vào lớn hon tổn số trang 
		if(currentPage > numberOfPages || currentPage < 1 ) {
			currentPage = 1;
		}
		
		int numberPage = DefineUtil.NUMBER_PER_PAGE;
		int offset = (currentPage - 1 ) * numberPage;
		
		ArrayList<User> listU = usersDAO.getseachPagination(offset, seach);
		
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("numberOfItems", numberOfItems);
		request.setAttribute("numberPage", numberPage);
		
		if(listU != null && listU.size() > 0) {
			request.setAttribute("listU", listU);
			request.setAttribute("seach", seach);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/user/seach.jsp?msg=1");
			rd.forward(request, response);
			return;
			
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/user/noseach.jsp?error=1");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}

}
