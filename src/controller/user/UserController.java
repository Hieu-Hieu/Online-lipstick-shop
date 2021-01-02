package controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import get.GetUser;
import model.User;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

	GetUser GetUser = new GetUser();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("signin.jsp").forward(request, response);
		String command = request.getParameter("command");
		String url = "";
		User u = new User();
		HttpSession session = request.getSession();
		switch (command) {
		case "insert":
			u.setUserID(Integer.parseInt(request.getParameter("id")));
			u.setUsername(request.getParameter("name"));
			u.setPassword(request.getParameter(("pass")));
			u.setEmail(request.getParameter("email"));
			u.setPhone(request.getParameter("phone"));
			u.setAddress(request.getParameter("address"));
			u.setRole(false);
			GetUser.insertUser(u);
			session.setAttribute("user", u);
			url = "/navigate.jsp";
			break;
		case "update":
			int id = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String password = request.getParameter("pass");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			boolean role = Boolean.parseBoolean(request.getParameter("role"));

			GetUser.updateUser(new User(id, username, password, email, phone, address, role));
			url = "/my-account.jsp";
			break;
		case "logindeal":
			try {
				u = GetUser.login(request.getParameter("name"), (request.getParameter("pass")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (u != null) {
				session.setAttribute("user", u);
				url = "/deal.jsp";
			}
			break;

		case "login":
			try {
				u = GetUser.login(request.getParameter("name"), (request.getParameter("pass")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (u != null) {
				session.setAttribute("user", u);
				url = "/dashboard.jsp";
			}

			else {
				request.setAttribute("error", "Lỗi tên đăng nhập hoặc mật khẩu");
				url = "/signin.jsp";
			}
			break;

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String url = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String command = request.getParameter("command");

		GetUser getUser = new GetUser();
		User u = new User();

		switch (command) {
		case "register":
			String passAgain = request.getParameter("passwordAgain");
			if (password.equals(passAgain)) {
				u.setUsername(request.getParameter("name"));
//				u.setUserID(Integer.parseInt(request.getParameter("id")));
				u.setPassword(password);
				u.setEmail(request.getParameter("email"));
				u.setPhone(request.getParameter("phone"));
				u.setAddress(request.getParameter("address"));
				u.setRole(false);
				GetUser.insertUser(u);
				request.setAttribute("login", "Đăng nhập để mua hàng");
				url = "/register.jsp";
			} else {
				request.setAttribute("name", request.getParameter("name"));
				request.setAttribute("email", request.getParameter("email"));
				request.setAttribute("address", request.getParameter("address"));
				request.setAttribute("phone", request.getParameter("phone"));
				request.setAttribute("errorPass", "Mật khẩu không khớp");
				url = "/register.jsp";
			}
			break;
		case "update":
			int id = Integer.parseInt(request.getParameter("id"));
			String user = request.getParameter("username");
//			String pass = request.getParameter("pass");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			boolean role = Boolean.parseBoolean(request.getParameter("role"));

			GetUser.updateUser(new User(id, username, password, email, phone, address, role));
			url = "/my-account.jsp";
			break;
		case "login":
			try {
				u = getUser.login(username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (u != null) {
				session.setAttribute("user", u);
				if (u.getRole() == true) {
					url = "/admin/dashboard.jsp";
				} else {
					url = "/index.jsp";
				}
			} else {
				request.setAttribute("error", "Lỗi tên đăng nhập hoặc mật khẩu");
				url = "/signin.jsp";
			}
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
