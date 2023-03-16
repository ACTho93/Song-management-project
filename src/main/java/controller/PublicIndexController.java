package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Song;
import model.bean.User;
import model.dao.SongDAO;
import util.DefineUtil;

public class PublicIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SongDAO songDAO;
       
    public PublicIndexController() {
        super();
        songDAO = new SongDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		
		int numberOfItems = songDAO.numberOfItems();
		
		//get number songs
		
		
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
		ArrayList<Song> songs = songDAO.getItemsPagination(offset);

		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("numberOfItems", numberOfItems);
		
		request.setAttribute("numberPage", numberPage);
		
		request.setAttribute("songs", songs);
		RequestDispatcher rd = request.getRequestDispatcher("/public/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
