package controller.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.DBConnect;
import get.BrandDAO;
import get.CategoryDAO;
import model.Brand;
import model.Category;
import model.Product;

public class ProductUpdateController {
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
			ArrayList<Category> cate = new ArrayList<Category>(); 
			CategoryDAO getCate = new CategoryDAO();
			  
			 ArrayList<Brand> brand =new ArrayList<Brand>(); 
			 BrandDAO getBrand = new BrandDAO(); 
			 
			try {
				brand = getBrand.getListBrand();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			  
			  req.setAttribute("ListBrand", brand);
			  
			  
			   try {
				cate = getCate.getListCategory();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			   
			  req.setAttribute("ListCategory", cate);
			  
			  RequestDispatcher dispatch = req.getRequestDispatcher("/admin/addProduct.jsp"); 
			  dispatch.forward(req,resp);
		}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			Product product = new Product();
			
			try {
			Connection connection = DBConnect.getConnecttion();
				String sql ="update product set categoryID=?, Name=?, brandID=?, imgFirst=?, imgLast=?,price=?, description=?,quantity=? where  productID=? ";
				PreparedStatement ps = connection.prepareStatement(sql); 
					
				 ps.setInt(1, Integer.parseInt(req.getParameter("pID")));
				 ps.setInt(2, Integer.parseInt(req.getParameter("categoryID")));
				 ps.setString(3, req.getParameter("pName"));
				 ps.setInt(4, Integer.parseInt(req.getParameter("brandID")));
				 ps.setString(5, req.getParameter("imgFirst"));
				 ps.setString(6, req.getParameter("imgLast"));
				 ps.setFloat(7, Float.parseFloat(req.getParameter("price")));
				 ps.setString(8, req.getParameter("description"));
				 ps.setInt(9, Integer.parseInt(req.getParameter("quantity")));
	 			 
				  int row = ps.executeUpdate(); 
				  if (row > 0) {
					  req.setAttribute("addSuccess", 1);
					  RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/admin/product/list?currentPage=1");
					  
					  dispatcher.forward(req, resp);
				  } 
				  else {
						 
						 req.setAttribute("addSuccess", 0);
						 RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher( "/admin/product/add");
						  
						  dispatcher.forward(req, resp);
				  }
			}
			catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
}
