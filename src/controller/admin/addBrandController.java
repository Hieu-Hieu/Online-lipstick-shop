package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.BrandDAO;
import model.Brand;

@WebServlet({ "/admin/brand/add" })
public class addBrandController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		BrandDAO brandDAO = new BrandDAO();
		Brand brand = new Brand();
		brand.setBrandName(req.getParameter("brandName"));
		if (brandDAO.insert(brand)) {
			req.setAttribute("addBrand", 1);
		}

		resp.sendRedirect(req.getContextPath() + "/admin/brand/list");

	}
}
