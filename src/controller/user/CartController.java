package controller.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import get.GetCart;
import model.User;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
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
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = "";
		User u = new User();
		u = (User) session.getAttribute("user");
		if (u != null) {
			int userID = u.getUserID();
			GetCart getCart = new GetCart();
			ArrayList<List> listCart = new ArrayList<List>();
			try {
				if (getCart.checkUserExist(userID)) {
					listCart = getCart.getCartByUserID(userID);
					request.setAttribute("listCart", listCart);
					request.setAttribute("totalCart", getCart.totalCart(userID));
					url = "/cart.jsp";
				}
			} catch (

			SQLException e) {
				// TODO Auto-generated catch block
//				System.out.println(e);
				e.printStackTrace();
			}
			url = "/cart.jsp";
//			RequestDispatcher dipatcher = getServletContext().requestDi
		} else {
			url = "/cart.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
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
