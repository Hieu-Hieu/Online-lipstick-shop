package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.CategoryDAO;
import model.Category;

@WebServlet(urlPatterns = { "/admin/category/add" })
public class addCategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryDAO categoryDao = new CategoryDAO();
		Category category = new Category();
		category.setCategoryName(req.getParameter("categoryName"));
		if(categoryDao.insert(category)) {
			req.setAttribute("addCategory", 1);
		}
		
		resp.sendRedirect(req.getContextPath()+"/admin/category/list");

	}

}
