package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Comment;
import model.bean.Song;
import model.dao.CommentDAO;
import model.dao.CountlikeDAO;
import model.dao.SongDAO;

public class PublicDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SongDAO songDAO;
	private CommentDAO commentDAO;
	private CountlikeDAO countlikeDAO;
	private ArrayList<model.bean.Comment> listCmtById = new ArrayList<>();

	public PublicDetailController() {
		super();
		songDAO = new SongDAO();
		commentDAO = new CommentDAO();
		countlikeDAO = new CountlikeDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/404");
			return;
		}

		
		listCmtById = commentDAO.getItems(id);
		request.setAttribute("listCmtById", listCmtById);
		
		Song song = songDAO.getItem(id);
		if (song == null) {
			response.sendRedirect(request.getContextPath() + "/404");
			return;
		}
		// tăng view
		HttpSession session = request.getSession();
		String hasVisited = (String) session.getAttribute("hasVisited: " + id); // mục đích tạo ra 1 Attribute tron
																				// session và phân biệt giữa các bài
																				// viết qua id
		if (hasVisited == null) { //người đó chưa xem bài viết bao giờ
			session.setAttribute("hasVisited : " +id, "yes");
			session.setMaxInactiveInterval(1200);
			songDAO.increaseView(id); //sau một thời gian quy định, sẽ tự động mất session và tăng lượt view
		}

		ArrayList<Song> relatedSongs = songDAO.getRelatedItems(song, 2);

		request.setAttribute("relatedSongs", relatedSongs);
		request.setAttribute("song", song);
		session.setAttribute("id", id);
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/public/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		int id = (int) session.getAttribute("id");
		
		String acmt = request.getParameter("acmt");
		Comment objCmt = new Comment(0,id,acmt);


		if(commentDAO.addCMT(objCmt) > 0) {
			listCmtById.add(objCmt);
			//System.out.println("Thêm comment thành công");
		}else {
			//System.out.println("Thêm comment thất bại");
		}
		
		
		if (listCmtById != null) {
			for (Comment item : listCmtById) {
				response.getWriter().print("<div >" + "	<p class=\"article\" style=\"color: red\" class=\"name-cmt\">" +item.getComment()
						+ "</p>" + "	</div>");
			}
		}
	}

}
