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
		String sql = "";
		String command = request.getParameter("command");
		GetUser getUser = new GetUser();
		User u = new User();
		String username = "";
		String pass = "";
		String email = "";
		String phone = "";
		String address = "";
		boolean check = true;
		switch (command) {
		case "register":
			try {
				username = request.getParameter("name").trim();
				sql = "From User where username =" + "'" + username + "'";
				if (getUser.checkData(sql)) {
					u.setUsername(username);
					request.setAttribute("name", request.getParameter("name"));
				} else {
					check = false;
					request.setAttribute("errorName", "Tên đã tồn tại");
				}
				// ktra email
				email = request.getParameter("email").trim();
				sql = "FROM User where email =" + "'" + email + "'";
				if (getUser.checkData(sql)) {
					request.setAttribute("email", request.getParameter("email"));
					u.setEmail(email);
				} else {
					check = false;
					request.setAttribute("errorEmail", "Email đã tồn tại");
				}
				// ktra SĐT
				phone = request.getParameter("phone").trim();
				sql = "FROM User where phone =" + "'" + phone + "'";
				if (getUser.checkData(sql)) {
					request.setAttribute("phone", request.getParameter("phone"));
					u.setPhone(phone);
				} else {
					check = false;
					request.setAttribute("errorPhone", "Số điện thoại đã được sử dụng");
				}

				if (check == true) {
					pass = request.getParameter("password").trim();
					String passAgain = request.getParameter("passwordAgain").trim();
					if (pass.equals(passAgain)) {
						u.setPassword(pass);
						u.setAddress(request.getParameter("address").trim());
						u.setRole(false);
						GetUser.insertUser(u);
						request.setAttribute("login", "Đăng nhập để mua hàng");
						url = "/register.jsp";
					} else {
						request.setAttribute("errorPass", "Mật khẩu không khớp");
						url = "/register.jsp";
					}
				} else {
					url = "/register.jsp";
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			// ktra tên
			request.setAttribute("address", request.getParameter("address"));

			break;
		case "update":
			int id = Integer.parseInt(request.getParameter("id"));
			username = request.getParameter("username");
			pass = request.getParameter("pass");
			email = request.getParameter("email");
			phone = request.getParameter("phone");
			address = request.getParameter("address");
			boolean role = Boolean.parseBoolean(request.getParameter("role"));
			GetUser.updateUser(new User(id, username, pass, email, phone, address, role));
			url = "/my-account.jsp";
			break;
		case "login":
			email = request.getParameter("email").trim();
			String password = request.getParameter("password").trim();
			try {
				u = getUser.login(email, password);
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

	public void name() {

	}
}
