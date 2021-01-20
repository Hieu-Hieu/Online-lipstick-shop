package controller.user;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BillDAO;
import dao.BillDetailDAO;
import dao.CartDAO;
import model.Bill;
import model.BillDetail;
import model.Cart;
import model.User;
import sendmail.sendMail;

/**
 * Servlet implementation class BillController
 */
@WebServlet("/BillController")
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BillController() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		CartDAO getCart = new CartDAO();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		BillDAO getBill = new BillDAO();
		BillDetailDAO billDetail = new BillDetailDAO();
		BillDetail detail = new BillDetail();
		String url = "/cart.jsp";
		Bill b = new Bill();
		int check =0;
		try {
			ArrayList<Cart> listCart = getCart.getCartByUserID(u.getUserID());
			double total = getCart.totalCart(u.getUserID());
			String username = request.getParameter("name");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			LocalDate localDate = LocalDate.now();
			Date d = Date.valueOf(localDate);
			Bill bill = new Bill(u, address, phone, d, total, false, "Chờ duyệt");
			
				
				if (getBill.addBill(bill)) {
					b = getBill.getBillNew(u);
					// thêm sản phẩm vào trong billdetail
					
					for (Cart cart : listCart) {
						detail.setProduct(cart.getProduct());
						detail.setBill(b);
						detail.setQuantity(cart.getQuantity());
						billDetail.addBilldetail(detail);
					}
					check = 1;
					if (getCart.deleteCartByUserID(u.getUserID())) {
						url = "/OrderHistory?command=list";
						response.sendRedirect(request.getContextPath() + url);
						//return;
					}
				}
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	
		try {
			
		String bang = "<h2  style=\" text-align:left;margin:10px 0;border-bottom:1px solid #ddd;padding-bottom:5px;font-size:13px;color:#02acea\">CHI TIẾT ĐƠN HÀNG</h2>";
		
		 bang +="<table  border=\"1.5px\" width=\"95%\" style=\"background:#fff; border-collapse: collapse;\">";
		bang+="<tr>";				
		bang+="<th style=\" width: 10%\">Sản phẩm</th>";
		bang+="<th>Tên sản phẩm</th>";	
		bang+="<th>Giá</th>";
		bang+="<th>Số lượng</th>";
		bang+="<th>Tổng</th>";	
		bang+="</tr>";
		double tongbill=0;
		
		if(check>0)
		{
				ArrayList<BillDetail> listBD= billDetail.getBilldetail(b);
				for(BillDetail bd : listBD)
				{
					bang+="<tr style=\" text-align: center; \">";		
					bang+="<td> <img src=\""+ bd.getProduct().getImgFirst().trim()+"\" width=\"120px\"></td>";
					bang+="<td>"+bd.getProduct().getName()+"</td>";
					bang += "<td>"+bd.getProduct().getPrice()+"đ"+"</td>";
					bang+="<td>"+bd.getQuantity()+"</td>";
					//bang+="<td>"+t[4].toString()+"</td>";
					bang+="<td>"+BigDecimal.valueOf((bd.getProduct().getPrice()*bd.getQuantity())).toPlainString()+"</td>";
					bang+="</tr>";
					
					 tongbill+=bd.getProduct().getPrice()*bd.getQuantity();
					// DecimalFormat decimalFormat = new DecimalFormat( Double.toString(tongbill));
					// System.out.println("Tong bill: "+bd.getProduct().getPrice()+"X"+bd.getQuantity()+" "+decimalFormat);
				}
				bang+=" </table>";
				
				String body="Dear "+u.getUsername();
				body+="<br> Cảm ơn bạn đã đặt hàng tại Lipstickshop";
				body+="<br> Quý khách vui lòng kiểm tra lại đơn hàng";
				body+="<br> Địa chỉ nhận hàng: "+b.getAddress()+" sdt: "+ b.getPhone();
				body+="<br> Mã đơn hàng: "+b.getBillID()+" tổng hóa đơn: "+BigDecimal.valueOf((tongbill)).toPlainString()+"đ vào lúc: "+ b.getDate();
				body+="<br> Mọi thắc mắc vui lòng liên hệ hieu.it@gmail.com";
				body+="<br>"+bang;
			
				
				sendMail.sendMail(u.getEmail(), "Lipstickshop: Xác nhận đơn hàng",body);
				System.out.println("Gui mail ok");
				
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
