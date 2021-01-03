package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.BrandDAO;


public class deleteBrandController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BrandDAO b = new BrandDAO();
		String id = req.getParameter("id");
		b.delete(Integer.parseInt(id));
		
		resp.sendRedirect(req.getContextPath() + "/admin/brand/list");
	}
}
