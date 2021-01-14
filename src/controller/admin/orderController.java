package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bill;
import model.BillDetail;
import sendmail.sendMail;
import dao.BillDAO;
import dao.BillDetailDAO;

@WebServlet({ "/admin/order/list" })
public class orderController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		
		System.out.println("ahh");
		ArrayList<Bill> listBill = new ArrayList<Bill>();
		ArrayList<BillDetail> detailBill = new ArrayList<BillDetail>();
		BillDAO getBill = new BillDAO();
		BillDetailDAO detail = new BillDetailDAO();
		String command = "";
		String Action = "";
		if(req.getParameter("status")== null) {
			listBill = getBill.getListBillPending();
			req.setAttribute("listBill", listBill);
			req.setAttribute("status", "pending");
		}
		else if(req.getParameter("status")!= null) {
			command = req.getParameter("status");
			if(command.equals("pending")) {
				listBill = getBill.getListBillPending();
				req.setAttribute("listBill", listBill);
				req.setAttribute("status", "pending");
				
			}
			else if(command.equals("censored")) {
				listBill = getBill.getListBillCensored();
				req.setAttribute("listBill", listBill);
				req.setAttribute("status", "censored");
			}
			else if(command.equals("cancel")) {
				listBill = getBill.getListBillCancel();
				req.setAttribute("listBill", listBill);
				req.setAttribute("status", "cancel");
			}
			else if(command.equals("orderSuccess")) {
				listBill = getBill.getListBillSuccess();
				req.setAttribute("listBill", listBill);
				req.setAttribute("status", "orderSuccess");
			}
			
		}
		
		if(req.getParameter("Action")!= null && req.getParameter("id")!=null) {
			Action = req.getParameter("Action");
			int billID =  Integer.parseInt(req.getParameter("id"));
			if(Action.equals("Huy")) {
				
				if(getBill.updateStatus(billID, "Đã hủy")) {
					req.setAttribute("statusUpdateSuccess", "Cập nhật thành công");
					
					if(getBill.getBillByID(billID).getUser().getEmail()!=null) {
						String mail = getBill.getBillByID(billID).getUser().getEmail();
						String userName = getBill.getBillByID(billID).getUser().getUsername();
						String title = "Đơn hàng trên Lipstickshop của bạn đã được hủy!";
						String mailText = "<h4>Xin chào " + userName+ " </h4>"+
								"<h3>Đơn hàng #"+ billID 
								+ " trên Lipstickshop của bạn đã được hủy!"
								+ " Rất cảm ơn bạn đã mua hàng tại Lipsticshop. </h3>";
						sendMail.sendMail(mail, title, mailText);
					}
				}
				listBill = getBill.getListBillPending();
				req.setAttribute("listBill", listBill);
				req.setAttribute("status", "cancel");
				
			}
			else if(Action.equals("Duyet")) {
				
				if(getBill.updateStatus(billID, "Đã duyệt")) {
					req.setAttribute("statusUpdateSuccess", "Cập nhật thành công");
					
					if(getBill.getBillByID(billID).getUser().getEmail()!=null) {
						String mail = getBill.getBillByID(billID).getUser().getEmail();
						String userName = getBill.getBillByID(billID).getUser().getUsername();
						String title = "Lipsticshop đã xác nhận đơn hàng của bạn rồi nhé!";
						//<h5><a href="+ req.getServletContext().getContextPath()+"/OrderHistory?command=detail&billID="+billID+'"'+">" +"</a>"
						//+ billID +  "</h5>";
						String mailText = "<h4>Xin chào " + userName+ " </h4>"+
								"<h3>Lipsticshop đã xác nhận đơn hàng #"+ billID 
								+ " của bạn và sẽ gửi hàng cho bạn sớm nhất có thể nhé!"
								+ " Rất cảm ơn bạn đã mua hàng tại Lipsticshop. </h3>";
						sendMail.sendMail(mail, title, mailText);
					}
					
				}
				listBill = getBill.getListBillPending();
				req.setAttribute("listBill", listBill);
				req.setAttribute("status", "pending");
			}
			
			else if(Action.equals("DaGiao")) {
				if(getBill.updateStatus(billID, "Đã giao hàng")) {
					req.setAttribute("statusUpdateSuccess", "Cập nhật thành công");
					
					if(getBill.getBillByID(billID).getUser().getEmail()!=null) {
						String mail = getBill.getBillByID(billID).getUser().getEmail();
						String userName = getBill.getBillByID(billID).getUser().getUsername();
						String title = "Lipsticshop xin thông báo đơn hàng của bạn đã được giao thành công";
						//<h5><a href="+ req.getServletContext().getContextPath()+"/OrderHistory?command=detail&billID="+billID+'"'+">" +"</a>"
						//+ billID +  "</h5>";
						String mailText = "<h4>Xin chào " + userName+ " </h4>"+
								"<h3>Lipsticshop xin thông báo đơn hàng #"+ billID 
								+ " của bạn đã được giao thành công rồi nhé!"
								+ " Rất cảm ơn bạn đã mua hàng tại Lipsticshop. </h3>";
						sendMail.sendMail(mail, title, mailText);
					}
					
				}
				listBill = getBill.getListBillPending();
				req.setAttribute("listBill", listBill);
				req.setAttribute("status", "pending");
			}
		}
		
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/admin/odermanager.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		}

}
