package controller.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import model.Category;

@WebServlet(urlPatterns = { "/admin/category/update" })
public class CategoryeEditController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryDAO categoryDao = new CategoryDAO();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		try {
			int categoryID = Integer.parseInt(req.getParameter("id"));
			Category category = categoryDao.getByID(categoryID);

			req.setAttribute("category", category);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/editCategory.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception ex) {

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CategoryDAO categoryDAO = new CategoryDAO();
		Category category = new Category();
		category.setCategoryID(Integer.parseInt(req.getParameter("categoryID")));
		
		String name = req.getParameter("categoryName").trim();
		category.setCategoryName(name);
		
		String sql = "FROM Category where categoryID <> "+category.getCategoryID()+ "and categoryName =" + "'" +  name + "'" ;
		String url="/admin/editCategory.jsp";
		
		try {
			System.out.println(categoryDAO.checkData(sql));
				if(categoryDAO.checkData(sql)==0)
				{
					if (categoryDAO.updateCategory(category)) {
						url="/admin/category/list";
					}
				}
				
				else {
					req.setAttribute("category", category);
					req.setAttribute("errorName", "Tên này đã tồn tại");
				}	
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}

	
}