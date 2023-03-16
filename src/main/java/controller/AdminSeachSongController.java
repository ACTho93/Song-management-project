package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Category;
import model.bean.Song;
import model.bean.User;
import model.dao.CategoryDAO;
import model.dao.SongDAO;
import util.DefineUtil;


public class AdminSeachSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SongDAO songDAO;
    public AdminSeachSongController() {
        super();
        songDAO = new SongDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html");
		  request.setCharacterEncoding("UTF-8");
		  
		  HttpSession session = request.getSession();
		  User userLogin = (User) session.getAttribute("userLogin");
		  
		  String seach = request.getParameter("seach"); 
		  int numberOfItems = songDAO.numberOfItemsseach(seach);
			
			
			int numberOfPages = (int) Math.ceil((float) numberOfItems/ DefineUtil.NUMBER_PER_PAGE);
			
			int currentPage = 1;
			try {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}catch (NumberFormatException e) {
			}
			
			// nếu như người dùng truỳn vào lớn hon tổn số trang 
			if(currentPage > numberOfPages || currentPage < 1 ) {
				currentPage = 1;
			}
			
			int numberPage = DefineUtil.NUMBER_PER_PAGE;
			int offset = (currentPage - 1 ) * numberPage;

			
			request.setAttribute("numberOfPages", numberOfPages);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("numberOfItems", numberOfItems);
			request.setAttribute("numberPage", numberPage);
			
			
		 
			//CategoryDAO categoryDAO = new CategoryDAO();
		    ArrayList<Song> items = songDAO.getseachsongPagination(seach, offset);
			
		  
		  if(items != null && items.size() > 0) {
			  request.setAttribute("items", items); 
			  request.setAttribute("seach", seach);
			  RequestDispatcher rd = request.getRequestDispatcher("/admin/song/seach.jsp?msg=1");
			  rd.forward(request, response); 
			  return; 
		  }else {
			  response.sendRedirect(request.getContextPath()+ "/admin/song/noseach.jsp?error=1"); 
			  return; 
		  }
		  
		  
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
	}

}
