package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.Song;
import model.dao.CategoryDAO;
import model.dao.SongDAO;
import util.DefineUtil;

public class PublicCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;
	private SongDAO songDAO;
       
    public PublicCatController() {
        super();
        categoryDAO = new CategoryDAO();
        songDAO = new SongDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/404");
			return;
		}
		
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
		}
		Category category = categoryDAO.getItem(id);
		if(category == null) {
			response.sendRedirect(request.getContextPath()+"/404");
			return;
			
		}
		
		int numberOfItems = songDAO.numberOfItems(id);
		int numberOfPages =(int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);
		if(currentPage > numberOfPages || currentPage < 1 ) {
			currentPage = 1;
		}
		
		int numberPage = DefineUtil.NUMBER_PER_PAGE;
		int offset = (currentPage -1) * numberPage;
		
		
		ArrayList<Song> songs = songDAO.getItemsByCategoryPagination(offset, id);
		
		
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("numberOfItems", numberOfItems);
		request.setAttribute("numberPage", numberPage);
		
		request.setAttribute("songs", songs);
		request.setAttribute("category", category);
		
		RequestDispatcher rd = request.getRequestDispatcher("/public/cat.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
