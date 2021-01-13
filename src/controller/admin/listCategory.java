package controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.CategoryDAO;
import model.Category;

@WebServlet("/admin/category/list")
public class listCategory extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryDAO categoryDAO = new CategoryDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		String command = req.getParameter("command");
		List<Category> cateList;
		switch (command) {
		case "search":
			String input = req.getParameter("input");
			if (input != null) {
				req.setAttribute("searchKey", req.getParameter("input"));
			} else {
				input = req.getParameter("searchKey");
				req.setAttribute("searchKey", req.getParameter("searchKey"));
			}
			try {
				
				cateList = categoryDAO.search(input);
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "filter":

			break;
			
		case "list":
			try {
				cateList = categoryDAO.getListCategory();
				req.setAttribute("categoryList", cateList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		}

		try {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/categoryList.jsp");
			dispatcher.forward(req, resp);
		} catch( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}