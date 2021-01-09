package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import get.GetUser;

/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/NewPassword")
public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewPassword() {
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
		String pass = request.getParameter("pass");
		String passAgain = request.getParameter("passAgain");
		HttpSession session = request.getSession();
		String url = "";
		GetUser getUser = new GetUser();
		String email = (String) session.getAttribute("emailAccount");
		if (email != null) {
			if (pass.equals(passAgain)) {
				if (getUser.updateUserPass(email, pass)) {
					session.removeAttribute("emailAccount");
					session.removeAttribute("code");
					url = "/signin.jsp";
					response.sendRedirect(request.getContextPath() + url);
					return;
				}
			} else {
				request.setAttribute("error", "Mật khẩu không khớp");
				url = "/new-password.jsp";
			}
		} else {
			url = "enter-email.jsp";
		}
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

}
