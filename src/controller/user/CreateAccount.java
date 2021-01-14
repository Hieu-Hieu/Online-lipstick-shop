package controller.user;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;
import sendmail.SendCode;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAccount() {
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
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String subject = "Mã xác thực đăng ký tài khoản";
		String command = request.getParameter("command");
		UserDAO getUser = new UserDAO();
		SendCode sm = new SendCode();
		String url = "/register.jsp";
		int code;
		User user = (User) session.getAttribute("newUser");
		if (user != null) {
			String email = user.getEmail();
			switch (command) {
			case "new":
				code = randomCode();
				if (sm.sendMail(email, subject, String.valueOf(code))) {
					session.setAttribute("codeAuth", code);
					url = "/code.jsp?command=newUser";
					response.sendRedirect(request.getContextPath() + url);
					return;
				}
				break;
			case "again":
				code = randomCode();
				if (sm.sendMail(email, subject, String.valueOf(code))) {
					session.setAttribute("codeAuth", code);
					request.setAttribute("sended", "Đã gửi lại mã cho bạn!");
					url = "/code.jsp?command=newUser";
				}
				break;
			case "check":
				String enterCode = request.getParameter("enterCode");
				code = (int) session.getAttribute("codeAuth");
				if (enterCode.equals(String.valueOf(code))) {
					System.out.println("check ok");
					request.setAttribute("createSuccess", "Đăng ký thành công, Đăng nhập để tiếp tục");
					if (getUser.insertUser(user)) {
						session.removeAttribute("newUser");
						session.removeAttribute("codeAuth");
						request.setAttribute("login", "Đăng nhập để mua hàng");
						url = "/code.jsp?command=newUser";
					}
				}
				break;
			}
		} else {
			url = "/register.jsp";
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
