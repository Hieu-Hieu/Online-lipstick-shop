package controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.GetCart;
import model.Cart;

/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String command = request.getParameter("command");
		String userID = request.getParameter("userID");
		String productID = request.getParameter("productID");
		GetCart getCart = new GetCart();
		String url = "/";
		Cart cart = new Cart(userID, productID, 1);
		try {
			switch (command) {
			case "add":
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				if (getCart.checkExist(userID, productID)) {
					if (getCart.updateProductQuantity(userID, productID, quantity)) {
						url = "/product-list.jsp";
					}
				} else {
					if (getCart.addToCart(userID, productID, quantity)) {
						url = "/product-list.jsp";
					}
				}
				break;
			case "remove":
				System.out.println("remove");
				getCart.delete(userID, productID);
				url = "/CartController";
				break;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + url);
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
//		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
