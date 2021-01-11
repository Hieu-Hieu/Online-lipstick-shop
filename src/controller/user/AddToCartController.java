package controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import get.GetCart;
import get.GetProduct;
import get.GetUser;
import model.Cart;
import model.User;

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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String command = request.getParameter("command");
		User u = new User();
		u = (User) session.getAttribute("user");
		int userID = 0;
		int productID = productID = Integer.parseInt(request.getParameter("productID"));
		int quantity = 0;
		int quantityStock = 0;
		String url = "";
		if (u != null) {
			try {
				userID = u.getUserID();
				GetCart getCart = new GetCart();
				GetUser getUser = new GetUser();
				GetProduct getProduct = new GetProduct();
				switch (command) {
				case "add":
					quantity = Integer.parseInt(request.getParameter("quantity"));
					quantityStock = getProduct.getQuantityByProductID(productID);
					if (quantity > quantityStock) {
						request.setAttribute("quantityError", "Số lượng trong kho chỉ còn" + quantityStock);
						quantity = quantityStock;
					}
					if (getCart.checkProductExist(userID, productID)) {
						getCart.updateProductQuantity(userID, productID, quantity);
					} else {
						Cart cart = new Cart(getUser.getUserByID(userID), getProduct.getProductByID(productID),
								quantity);
						getCart.addToCart(cart);
					}
					if (request.getParameter("cart").equals("no")) {
						int currentPage = Integer.parseInt(request.getParameter("currentPage"));
						url = "/ProductList?currentPage=" + currentPage;
					} else {
						url = "/CartController";
					}
					break;
				case "remove":
					getCart.deleteProductInCart(userID, productID);
					url = "/CartController";
					break;
				case "update":
					quantity = Integer.parseInt(request.getParameter("quantity"));
					quantityStock = getProduct.getQuantityByProductID(productID);
					if (quantity > quantityStock) {
						request.setAttribute("quantityError", "Số lượng trong kho chỉ còn" + quantityStock);
						quantity = quantityStock;
					}
					if (quantity > 0) {
						getCart.updateProductQuantityInCart(userID, productID, quantity);
					} else {
						getCart.deleteProductInCart(userID, productID);
					}
					url = "/CartController";
					break;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			request.setAttribute("LoginRequire", "Bạn vui lòng đăng nhập để mua hàng");
			url = "/ProductDetailController?productID=" + productID + "&login=login";
		}
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
//		dispatcher.forward(request, response);
		response.sendRedirect(request.getContextPath() + url);
	}

}
