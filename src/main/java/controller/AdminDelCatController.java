package controller;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.dao.SongDAO;
import util.AuthUtil;

public class AdminDelCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDAO categoryDAO; 
    private SongDAO songDAO;
    public AdminDelCatController() {
        super();
        categoryDAO = new CategoryDAO();
        songDAO = new SongDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check login
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		
		int cid = 0;
		try {
			cid  = Integer.parseInt( request.getParameter("cid"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?error=1");
			return;
		}
		
		//
		
		songDAO.delsongAdmin(cid);
			
		if(categoryDAO.delCatAdmin(cid) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=3");
			return;
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/cats?error=2");
			return;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
			
	}

}
