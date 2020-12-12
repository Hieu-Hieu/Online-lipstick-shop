package controller.admin;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.CategoryDAO;
import get.GetProduct;
import model.Category;
import model.Product;

@WebServlet("/category-manager")
public class CategoryManagerController extends HttpServlet{
	
	CategoryDAO categoryDAO = null;
	
	public CategoryManagerController() {
		this.categoryDAO = new CategoryDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		String categoryId = request.getParameter("category_id");
		String deleteId = request.getParameter("delete_id");

		if (categoryId != null && deleteId != null) {		
			categoryDAO.delete(categoryId);
		}
		
		String currentPage = (request.getParameter("currentPage") == null ||request.getParameter("currentPage").isBlank() || request.getParameter("currentPage").isEmpty()) ? "1" : request.getParameter("currentPage");
		ArrayList<Category> categories = null;
		String url = "";
		try {
			categories = categoryDAO.getAll(Integer.parseInt(currentPage) * 9 - 9, 9);
			request.setAttribute("categories", categories);
			url = "/admin/categorymanager.jsp";
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		Category category = null;
		String categoryId = request.getParameter("category_id");
		String categoryName = request.getParameter("category_name");
		
		try {
			category = categoryDAO.getByID(categoryId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		if (category != null)//update
		{
			category.setCategoryName(categoryName);
			try {	
				boolean result = categoryDAO.update(categoryId, category);
				if (result) {
					doGet(request, response);
				} else {
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {//insert
			try {
				category = new Category(categoryId, categoryName);			
				boolean result = categoryDAO.insert(category);
				if (result) {
					doGet(request, response);
				} else {
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
}
