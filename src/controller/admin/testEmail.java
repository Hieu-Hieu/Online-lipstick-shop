package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sendmail.sendMail;

@WebServlet({"/sendMail"})
public class testEmail extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sendMail sm = new sendMail();
		String subject = "Xác nhận đơn hàng: "+ "BillID";
		sm.sendMail("18110283@student.hcmute.edu.vn", "LipstickShop", "Payment success. We will contact you soon ! ");
		System.out.println("ok chua");
	}
}
