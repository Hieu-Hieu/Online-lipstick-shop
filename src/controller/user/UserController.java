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

import dao.UserDAO;
import model.User;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

	UserDAO GetUser = new UserDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String url = "/my-account.jsp?Error=Dupicate";
		String sql = "";
		String command = request.getParameter("command");
		UserDAO getUser = new UserDAO();
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
				u.setUsername(username);
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
						session.setAttribute("newUser", u);
						url = "/CreateAccount?command=new";
						response.sendRedirect(request.getContextPath() + url);
						return;
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
			request.setAttribute("name", request.getParameter("name"));
			break;
		case "update":
			try {
				u = (User) session.getAttribute("user");
				username = request.getParameter("username");
				email = request.getParameter("email");
				phone = request.getParameter("phone");
				address = request.getParameter("address");
				if (getUser.updateUserInfo(u.getUserID(), username, phone, email, address)) {
					request.setAttribute("updateSuccess", "Cập nhật thành công");
					u = getUser.getUserByID(((User) session.getAttribute("user")).getUserID());
					url = "/my-account.jsp";
					session.setAttribute("user", u);
				}

			} catch (Exception e) {
				// TODO: handle exception
				url = "/my-account.jsp";
				session.setAttribute("dupicateError", "Trùng Email hoặc số điện thoại");
				e.printStackTrace();
			}

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
//					session.setAttribute("admin", u);
					url = "/admin/dashboard.jsp";
				} else {
					url = "/index.jsp";
				}
				response.sendRedirect(request.getContextPath() + url);
				return;
			} else {
				request.setAttribute("error", "Lỗi tên đăng nhập hoặc mật khẩu");
				url = "/signin.jsp";
			}
			break;
		case "changePass":
			String oldPass = request.getParameter("oldPass");
			u = (User) session.getAttribute("user");
			if (!oldPass.equals(u.getPassword())) {
				check = false;
				request.setAttribute("oldPassError", "Mật khẩu không đúng");
			}
			String newPass1 = request.getParameter("newPass1");
			String newPass2 = request.getParameter("newPass2");
			if (!newPass1.equals(newPass2)) {
				check = false;
				request.setAttribute("newPassError", "Mật khẩu mới không khớp");
			}
			if (check == true) {
				request.setAttribute("updateSuccess", "Cập nhật thành công");
				getUser.updateUserPass(u.getEmail(), newPass1);
			}
			url = "/my-account.jsp";
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	public void sendCode(HttpServletRequest request, HttpServletResponse response) {

	}
}
