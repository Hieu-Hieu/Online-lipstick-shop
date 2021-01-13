package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.GetProduct;

@WebServlet(urlPatterns = { "/admin/product/delete" })
public class DeleteProductController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		GetProduct gp = new GetProduct();
		String id = req.getParameter("id");

		try {
			if (gp.deleteProduct(Integer.parseInt(id))) {
				req.setAttribute("deleteSuccess", 1);
			}
		} catch (Exception e) {

			System.out.print(e);
		}
		req.setAttribute("deleteSuccess", 0);
		resp.sendRedirect(req.getContextPath() + "/admin/product/list?command=list&currentPage=1");
	}
}
