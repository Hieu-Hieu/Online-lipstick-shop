package controller.user;

import java.io.IOException;
import java.sql.SQLException;

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
		User users = new User();
		HttpSession session = request.getSession();
		switch (command) {
		case "insert":
			users.setUserID(Integer.parseInt(request.getParameter("id")));
			users.setUsername(request.getParameter("name"));
			users.setPassword(request.getParameter(("pass")));
			users.setEmail(request.getParameter("email"));
			users.setPhone(request.getParameter("phone"));
			users.setAddress(request.getParameter("address"));
			users.setRole(false);
			GetUser.insertUser(users);
			session.setAttribute("user", users);
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
				users = GetUser.login(request.getParameter("name"), (request.getParameter("pass")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (users != null) {
				session.setAttribute("user", users);
				url = "/deal.jsp";
			}
			break;

		case "login":
			try {
				users = GetUser.login(request.getParameter("name"), (request.getParameter("pass")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (users != null) {
				session.setAttribute("user", users);
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

		GetUser getUser = new GetUser();
		User u = new User();
		try {
			u = getUser.login(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (u != null) {
			session.setAttribute("user", u);
			if (u.getRole() == true) {
				url = "admin/dashboard.jsp";
			} else {
				url = "index.jsp";
			}
		} else {
			request.setAttribute("error", "Lỗi tên đăng nhập hoặc mật khẩu");
			url = "signin.jsp";
		}
		response.sendRedirect(url);
	}

}
