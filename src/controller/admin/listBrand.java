package controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.BrandDAO;
import model.Brand;

@WebServlet("/admin/brand/list")
public class listBrand extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		
		List<Brand> brandList = Collections.emptyList();
		BrandDAO brandDao = new BrandDAO();
		String command = req.getParameter("command");
		//Brand brand = new Brand();
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
				brandList = brandDao.search(input);
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "list":
			try {
				brandList = brandDao.getListBrand();
				req.setAttribute("brandList", brandList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		default:
			break;
		}
		
		try {
			req.setAttribute("command", req.getParameter("command"));
			if (brandList.size() > 0) {
				req.setAttribute("listProduct", brandList);
			} else {
				req.setAttribute("EmptyListBrand", "Không có Brand nào");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/brandList.jsp");
		dispatcher.forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}