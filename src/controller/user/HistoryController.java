package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import get.GetBill;
import model.Bill;

/**
 * Servlet implementation class HistoryController
 */
@WebServlet("/HistoryController")
public class HistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HistoryController() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		GetBill getBill = new GetBill();
		int userID = Integer.parseInt(request.getParameter("userID"));
		ArrayList<Bill> listBill = new ArrayList<Bill>();
		listBill = getBill.getListBillByUserID(userID);
		if (listBill != null) {
			((ServletRequest) response).setAttribute("listBill", listBill);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/my-account.jsp");
			dispatcher.forward(request, response);

		}

	}

}
