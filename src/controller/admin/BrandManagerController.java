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
import get.GetProduct;
import model.Brand;
import model.Product;

@WebServlet("/brand-manager")
public class BrandManagerController extends HttpServlet{
	
	BrandDAO brandDAO = null;
	
	public BrandManagerController() {
		this.brandDAO = new BrandDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String brandId = request.getParameter("brand_id");
		String deleteId = request.getParameter("delete_id");

		if (brandId != null && deleteId != null) {		
			brandDAO.delete(brandId);
		}
		
		String currentPage = (request.getParameter("currentPage") == null ||request.getParameter("currentPage").isBlank() || request.getParameter("currentPage").isEmpty()) ? "1" : request.getParameter("currentPage");
		ArrayList<Brand> brandes = null;
		String url = "";
		try {
			brandes = brandDAO.getAll(Integer.parseInt(currentPage) * 9 - 9, 9);
			request.setAttribute("brandes", brandes);
			url = "/admin/brandmanager.jsp";
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
		
		Brand brand = null;
		String brandId = request.getParameter("brand_id");
		String brandName = request.getParameter("brand_name");
		
		try {
			brand = brandDAO.getByID(brandId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		if (brand != null)//update
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
		}else {//insert
			try {
				brand = new Brand(brandId, brandName);			
				boolean result = brandDAO.insert(brand);
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
