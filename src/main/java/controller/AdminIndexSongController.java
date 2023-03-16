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
import util.AuthUtil;
import util.DefineUtil;

public class AdminIndexSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SongDAO songDAO;
       
    public AdminIndexSongController() {
        super();
        songDAO = new SongDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check login
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		//get number songs
		
		int numberOfItems = 0;
		if(userLogin.getId_role() == 1) { // neu la admin
			numberOfItems = songDAO.numberOfItems();
		}else {
			numberOfItems = songDAO.numberOfItems1(userLogin.getId());
		}
		
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

		
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("numberOfItems", numberOfItems);
		request.setAttribute("numberPage", numberPage);
		
		
		if("admin".equals(userLogin.getUsername())) {
			ArrayList<Song> listSong = songDAO.getItemsPagination(offset);
			request.setAttribute("listSong", listSong);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/song/index.jsp");
			rd.forward(request, response);
		}else {
			ArrayList<Song> listSongByUser = songDAO.getItemsSongByUser1(offset,userLogin.getId());
			request.setAttribute("listSongByUser", listSongByUser);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/song/index1.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
