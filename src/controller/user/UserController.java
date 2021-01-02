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
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String url = "";

		String command = request.getParameter("command");

		GetUser getUser = new GetUser();
		User u = new User();

		switch (command) {
		case "register":
			String pass = request.getParameter("password").trim();
			String passAgain = request.getParameter("passwordAgain").trim();
			if (pass.equals(passAgain)) {
				u.setUsername(request.getParameter("name").trim());
//				u.setUserID(Integer.parseInt(request.getParameter("id")));
				u.setPassword(pass);
				u.setEmail(request.getParameter("email").trim());
				u.setPhone(request.getParameter("phone").trim());
				u.setAddress(request.getParameter("address").trim());
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
			String passw = request.getParameter("pass");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			boolean role = Boolean.parseBoolean(request.getParameter("role"));

			GetUser.updateUser(new User(id, user, passw, email, phone, address, role));
			url = "/my-account.jsp";
			break;
		case "login":
			String username = request.getParameter("username").trim();
			String password = request.getParameter("password").trim();
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
