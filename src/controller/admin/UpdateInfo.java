package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import get.GetUser;
import model.User;

/**
 * Servlet implementation class UpdateInfo
 */
@WebServlet("/admin/UpdateInfo")
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateInfo() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String url = "";
		GetUser getUser = new GetUser();
		User u = new User();
		String username = "";
		String pass = "";
		String email = "";
		boolean check = true;
		try {
			String oldPass = request.getParameter("oldPass");
			u = (User) session.getAttribute("user");
			if (oldPass.equals(u.getPassword()))
				check = true;
			else {
				check = false;
				request.setAttribute("oldPassError", "Mật khẩu không đúng");
			}
			String newPass1 = request.getParameter("newPass1");
			String newPass2 = request.getParameter("newPass2");
			if (newPass1.equals(newPass2)) {
				check = true;
			} else {
				check = false;
				request.setAttribute("newPassError", "Mật khẩu mới không khớp");
			}
			if (check == true) {
				username = request.getParameter("username");
				email = request.getParameter("email");
				if (getUser.updateAdminInfo(u.getUserID(), username, email, newPass1)) {
					request.setAttribute("updateSuccess", "Cập nhật thành công");
					User user = getUser.getUserByID(((User) session.getAttribute("user")).getUserID());
					session.setAttribute("user", user);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			session.setAttribute("dupicateError", "Trùng Email");
			e.printStackTrace();
		}

		url = "/admin/profile.jsp";
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
