package controller.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import sendmail.SendCode;

/**
 * Servlet implementation class ForgotPassWord
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPassword() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		SendCode sm = new SendCode();
		String subject = "Mã quên mật khẩu";
		String url = "";
		String recipient = "";
		int code;
		String message = "";
		UserDAO getUser = new UserDAO();
		switch (command) {
		case "new":
			try {
				recipient = request.getParameter("email");
				if (getUser.checkEmail(recipient)) {
					code = randomCode();
					message = "Mã xác thực quên mật khẩu của bạn là: <b>" + String.valueOf(code) + "</b>";
					if (sm.sendMail(recipient, subject, message)) {
						session.setAttribute("emailAccount", recipient);
						session.setAttribute("code", code);
//				session.setAttribute("sended", "Đã gửi mã! Kiểm tra email để tiếp tục");/
						url = "/code.jsp?command=oldUser";
					}
				} else {
					request.setAttribute("error", "Email không tồn tại");
					url = "/enter-email.jsp";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "again":
			recipient = (String) session.getAttribute("emailAccount");
			if (recipient != null) {
				session.removeAttribute("code");
				code = randomCode();
				message = "Mã xác thực quên mật khẩu của bạn là: <b>" + String.valueOf(code) + "</b>";
				if (sm.sendMail(recipient, subject, message)) {
					session.setAttribute("code", code);
//				request.setAttribute("sended", "Đã gửi mã! Kiểm tra email để tiếp tục");
					url = "/code.jsp?command=oldUser";
					response.sendRedirect(request.getContextPath() + url);
					return;
				}
			} else {
				url = "/enter-email.jsp";
				response.sendRedirect(request.getContextPath() + url);
				return;
			}
			break;
		case "check":
			String codeNumber = request.getParameter("codeNumber");
			if (codeNumber != null) {
				code = (int) session.getAttribute("code");
				if (codeNumber.equals(String.valueOf(code))) {
					url = "/new-password.jsp";
				} else {
					request.setAttribute("error", "Mã code không đúng!");
					url = "/code.jsp?command=oldUser";
				}
			} else {
				url = "/enter-email.jsp";
				response.sendRedirect(request.getContextPath() + url);
				return;
			}
			break;
		}
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

	public int randomCode() {
		Random generate = new Random();
		int code = generate.nextInt((999999 - 100000) - 1) + 100000;
		return code;
	}
}
