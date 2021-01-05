package controller.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.GetProduct;
import model.Product;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String currentPage = request.getParameter("currentPage");
		String command = request.getParameter("command");
		System.out.println(command);
		GetProduct gp = new GetProduct();
		List<Product> listProduct = null;
		String url = "";
		String sql = "/index.jsp";
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
			url = "/index.jsp";
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
