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

import get.BrandDAO;
import model.Brand;

@WebServlet("/admin/brandManager")
public class BrandManagerController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException, ServletException {
		BrandDAO brandDAO = new BrandDAO();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int brandId = Integer.parseInt(request.getParameter("brand_id"));
		String deleteId = request.getParameter("delete_id");

		if (deleteId != null) {
			brandDAO.delete(brandId);
		}

		String currentPage = (request.getParameter("currentPage") == null
				|| request.getParameter("currentPage").isEmpty() || request.getParameter("currentPage").isEmpty()) ? "1"
						: request.getParameter("currentPage");
		ArrayList<Brand> brandes = null;
		String url = "";
		try {
			brandes = brandDAO.getAll(Integer.parseInt(currentPage) * 9 - 9, 9);
			request.setAttribute("brandes", brandes);
			url = "/admin/brandManager.jsp";
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
		BrandDAO brandDAO = new BrandDAO();
		Brand brand = null;
		int brandId = Integer.parseInt(request.getParameter("brand_id"));
		String brandName = request.getParameter("brand_name");

		try {
			brand = brandDAO.getByID(brandId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (brand != null)// update
		{
			brand.setBrandName(brandName);
			try {
				boolean result = brandDAO.update(brandId, brand);
				if (result) {
					doGet(request, response);
				} else {

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {// insert
			try {
				Brand brand1 = new Brand(brandId, brandName);
				boolean result = brandDAO.insert(brand1);
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