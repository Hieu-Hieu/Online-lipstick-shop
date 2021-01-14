package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;

@WebServlet({ "/admin/category/delete" })
public class deleteCategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		CategoryDAO ctd = new CategoryDAO();
		String id = req.getParameter("id");
		ctd.delete(Integer.parseInt(id));

		resp.sendRedirect(req.getContextPath() + "/admin/category/list?command=list");
	}

}
