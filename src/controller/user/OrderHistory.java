package controller.user;

import java.io.IOException;
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
import model.Bill;
import model.BillDetail;
import model.User;

/**
 * Servlet implementation class OrderHistory
 */
@WebServlet("/OrderHistory")
public class OrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderHistory() {
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
		doPost(request, response);
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
		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		ArrayList<Bill> listBill = new ArrayList<Bill>();
		ArrayList<BillDetail> detailBill = new ArrayList<BillDetail>();
//		Bill bill = new Bill();
		GetBill getBill = new GetBill();
		BillDetailDAO detail = new BillDetailDAO();
		User u = (User) session.getAttribute("user");
		String url = "";
		if (u != null) {

			listBill = getBill.getListBillByUserID(u.getUserID());
			switch (command) {
			case "list":
				url = "/order-history.jsp";
				request.setAttribute("listBill", listBill);
				break;
			case "detail":
				int billID = Integer.parseInt(request.getParameter("billID"));
				detailBill = detail.getBilldetail(getBill.getBillByID(billID));
				url = "/order-history.jsp";
				request.setAttribute("detailBill", detailBill);
				request.setAttribute("listBill", listBill);
				request.setAttribute("billID", billID);
				break;
			}
		} else {
			url = "/signin.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
