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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
