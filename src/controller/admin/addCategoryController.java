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

@WebServlet(urlPatterns = { "/admin/category/add" })
public class addCategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		CategoryDAO categoryDao = new CategoryDAO();
		Category category = new Category();
		String name = req.getParameter("categoryName").trim();
		category.setCategoryName(name);
		String sql = "FROM Category where categoryName = " + "'" +  name + "'";
		String url = "/admin/addCategory.jsp";
		try {
			System.out.println(categoryDao.checkData(sql));
			if(categoryDao.checkData(sql)==0)
			{
				if (categoryDao.insert(category)) {
					
					url="/admin/category/list";
				}
			}
			
			else {
				req.setAttribute("categoryName", category.getCategoryName());
				req.setAttribute("errorName", "Tên này đã tồn tại");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}

}
