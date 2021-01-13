package controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import get.GetProduct;
import model.Product;

@WebServlet(urlPatterns = { "/admin/product/list" })
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String currentPage = request.getParameter("currentPage");
		
		String command = "";
		if(request.getParameter("command")!=null) {
			command = request.getParameter("command");
		}
		
		
		//System.out.println(command);
		GetProduct gp = new GetProduct();
		List<Product> listProduct = Collections.emptyList();
		
		String sql = "";
		String url = "/admin/productmanager.jsp";
		switch (command) {
		case "search":
			String input = request.getParameter("input");
			if (input != null) {
				request.setAttribute("searchKey", request.getParameter("input"));
			} else {
				input = request.getParameter("searchKey");
				request.setAttribute("searchKey", request.getParameter("searchKey"));
			}
			try {
				listProduct = gp.search(input, Integer.parseInt(currentPage) * 9 - 9, 9);
				sql = "from Product where name LIKE '%" + input + "%'";
				sql.toString();
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(input);
			break;
		case "filter":

			break;

		case "list":
			try {
				listProduct = gp.getAllProduct(Integer.parseInt(currentPage) * 9 - 9, 9);
				sql = "from Product";
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
		default:
			break;

		}

		try {
			request.setAttribute("totalPage", gp.totalPage(sql));
			request.setAttribute("command", request.getParameter("command"));
			request.setAttribute("currentPage", currentPage);
			if (listProduct.size() > 0) {
				request.setAttribute("listProduct", listProduct);
			} else {
				request.setAttribute("EmptyListProduct", "Không có sản phẩm nào");
			}
			url = "/admin/productmanager.jsp";
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}