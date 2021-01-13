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
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			Brand brand = brandDao.getByID(id);

			req.setAttribute("brand", brand);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/editBrand.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception ex) {

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");

		Brand b = new Brand();
		b.setBrandID(Integer.parseInt(req.getParameter("brandID")));
		
		String name = req.getParameter("brandName").trim();
		b.setBrandName(name);
		String sql = "FROM Brand where brandID <>"+ b.getBrandID()+ "and brandName =" + "'" +  name + "'" ;
		String url="/admin/editBrand.jsp";
		
		try {
			System.out.println(brandDao.checkData(sql));
				if(brandDao.checkData(sql)==0)
				{
					if (brandDao.update(b)) {
						req.setAttribute("addBrand", 1);
						url="/admin/brand/list";
					}
				}
				
				else {
					req.setAttribute("brand", b);
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
