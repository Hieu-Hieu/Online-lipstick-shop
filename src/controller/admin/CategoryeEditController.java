package controller.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.CategoryDAO;
import model.Category;

@WebServlet(urlPatterns = { "/admin/category/edit" })
public class CategoryeEditController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryDAO categoryDao = new CategoryDAO();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		int categoryID = Integer.parseInt(req.getParameter("id"));
		Category category = categoryDao.getByID(categoryID);
		
		req.setAttribute("category", category);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/category/editCategory.jsp");
		dispatcher.forward(req, resp);
		}
		catch(Exception ex) {
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Category category = new Category();
		category.setCategoryID(Integer.parseInt(req.getParameter("categoryID")));
		category.setCategoryName(req.getParameter("categoryName"));
		try {
			if(categoryDao.updateCategory(category)) {
				req.setAttribute("updateCategory", 1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect(req.getContextPath()+"/admin/category/list");

	}
}