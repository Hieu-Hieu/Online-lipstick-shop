package controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.GetCart;
import model.BillDetail;

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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String command = request.getParameter("command");
		int userID = Integer.parseInt(request.getParameter("userID"));
		int productID = Integer.parseInt(request.getParameter("productID"));

		GetCart getCart = new GetCart();
		String url = "/";
		BillDetail cart = new BillDetail(userID, productID, 1);
		try {
			switch (command) {
			case "add":
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				if (getCart.checkExist(userID, productID)) {
					if (getCart.updateProductQuantity(userID, productID, quantity)) {
						if (request.getParameter("cart").equals("no"))
							url = "/ProductList?currentPage=" + request.getParameter("currentPage");
						else {
							url = "/CartController";
						}
					}
				} else {
					if (getCart.addToCart(userID, productID, quantity)) {
						url = "/ProductList?currentPage=" + request.getParameter("currentPage");
					}
				}
				break;
			case "remove":
				getCart.delete(userID, productID);
				url = "/CartController";
				break;
			case "update":
				// náº¿u sá»‘ lÆ°á»£ng lá»›n hÆ¡n 1 thÃ¬ cáº­p nháº­t giá»� hÃ ng ngÆ°á»£c láº¡i
				// báº±ng 0 thÃ¬ xÃ³a khá»�i
				// giá»� hÃ ng
				int quantity1 = Integer.parseInt(request.getParameter("quantity"));
				if (getCart.updateProductQuantityInCart(userID, productID, quantity1) && quantity1 > 0) {
					url = "/CartController";
				} else {
					if (getCart.delete(userID, productID)) {
						url = "/CartController";
					}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			System.out.print(e);
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + url);
	}

}
