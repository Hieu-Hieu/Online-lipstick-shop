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
		String url="";
		try {
			int brandId = Integer.parseInt(request.getParameter("brand_id"));
			String deleteId = request.getParameter("delete_id");
			System.out.println("deleteID"+deleteId);
			if (deleteId != null) {
				brandDAO.delete(brandId);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		ArrayList<Brand> brandes = null;
		try {
			brandes = brandDAO.getListBrand();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			request.setAttribute("brandes", brandes);
			System.out.println(brandes);
			url = "/admin/brandManager.jsp";
		
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
		System.out.println("brandID"+request.getParameter("brand_Id"));
		String brandID =request.getParameter("brand_id");
		String brandName = request.getParameter("brand_name");
		if(brandId== null) {
			 // insert
					try {
						Brand brand1 = new Brand(brandName);
						boolean result = brandDAO.insert(brand1);
						if (result) {
							doGet(request, response);
						} else {
		
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				
		}
		else {
			try {
				int brandId = Integer.parseInt(request.getParameter("brand_id"));
				brand = brandDAO.getByID(brandId);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (brand != null)// update
			{
				try {
					boolean result = brandDAO.update(brand);
					if (result) {
						doGet(request, response);
					} else {
	
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// doGet(request, response);
	}
	}
}