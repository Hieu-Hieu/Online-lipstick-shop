package controller.user;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import get.BillDetailDAO;
import get.GetBill;
import get.GetCart;
import model.Bill;
import model.BillDetail;
import model.Cart;
import model.User;

/**
 * Servlet implementation class BillController
 */
@WebServlet("/BillController")
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BillController() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		GetCart getCart = new GetCart();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		GetBill getBill = new GetBill();
		BillDetailDAO billDetail = new BillDetailDAO();
		BillDetail detail = new BillDetail();
		String url = "";
		try {
			ArrayList<Cart> listCart = getCart.getCartByUserID(u.getUserID());
			double total = getCart.totalCart(u.getUserID());
			String username = request.getParameter("name");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			LocalDate localDate = LocalDate.now();
			Date d = Date.valueOf(localDate);
			Bill bill = new Bill(u, address, phone, d, total, false, false);
			if (getBill.addBill(bill)) {
				Bill b = getBill.getBillNew(u);
				// thêm sản phẩm vào trong billdetail
				for (Cart cart : listCart) {
					detail.setProduct(cart.getProduct());
					detail.setBill(b);
					detail.setQuantity(cart.getQuantity());
					billDetail.addBilldetail(detail);
				}
				if (getCart.deleteCartByUserID(u.getUserID())) {
					url = "/OrderHistory?command=list";
					response.sendRedirect(request.getContextPath() + url);
					return;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			url = "/CartController";
			System.out.println(e.toString());

		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
