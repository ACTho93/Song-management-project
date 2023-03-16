package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int trangthai = Integer.parseInt(request.getParameter("atrangthai"));
		if(trangthai == 1) {
			out.print(
					"<a href=\"javascrift:void(0)\" onclick=\"return getActive(1)\">" +
						"<img height=\"20px\" weight=\"20px\" src=\""+ request.getContextPath()+ "/templates/public/images/likeT.png\" />"+
					"</a>"
			);
		} else {
			out.print(
					"<a href=\"javascrift:void(0)\" onclick=\"return getActive(0)\">" +
						"<img height=\"20px\" weight=\"20px\"  src=\""+ request.getContextPath()+ "/templates/public/images/likeD.png\" />"+
					"</a>"
			);
		}
	}

}
