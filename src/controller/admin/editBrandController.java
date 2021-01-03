package controller.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.BrandDAO;
import model.Brand;

@WebServlet("/admin/brand/update")
public class editBrandController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BrandDAO brandDao = new BrandDAO();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		int id = Integer.parseInt(req.getParameter("id"));
		Brand brand = brandDao.getByID(id);
		
		req.setAttribute("brand", brand);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/editBrand.jsp");
		dispatcher.forward(req, resp);
		}
		catch(Exception ex) {
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Brand b = new Brand();
		b.setBrandID(Integer.parseInt(req.getParameter("brandID")));
		b.setBrandName(req.getParameter("brandName"));
		try {
			if(brandDao.update(b)) {
				req.setAttribute("updateBrand", 1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect(req.getContextPath()+"/admin/brand/list");

	}
}
