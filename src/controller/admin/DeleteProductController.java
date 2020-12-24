package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.GetProduct;

public class DeleteProductController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GetProduct p =new GetProduct();
		String id = req.getParameter("id");

		try {
		if(p.deleteProduct(Integer.parseInt(id))) {
			
		}
		}
		catch (Exception e) {
			System.out.print(e);
		}
		resp.sendRedirect(req.getContextPath() + "/admin/product/list");
	}

	
}
