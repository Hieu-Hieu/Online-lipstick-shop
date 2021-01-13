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

@WebServlet({ "/admin/brand/add" })
public class addBrandController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		BrandDAO brandDAO = new BrandDAO();
		Brand brand = new Brand();
		String name = req.getParameter("brandName").trim();
		brand.setBrandName(name);
		String sql = "FROM Brand where brandName =" + "'" +  name + "'";
		String url = "/admin/addBrand.jsp";
		try {
			System.out.println(brandDAO.checkData(sql));
			if(brandDAO.checkData(sql)==0)
			{
				if (brandDAO.insert(brand)) {
					req.setAttribute("addBrand", 1);
					url="/admin/brand/list";
				}
			}
			
			else {
				req.setAttribute("brandName", brand.getBrandName());
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
