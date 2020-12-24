package controller.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.DBConnect;
import get.BrandDAO;
import get.CategoryDAO;
import get.GetProduct;
import model.Brand;
import model.Category;
import model.Product;

@WebServlet({})
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
			GetProduct gp =new GetProduct();
			Product p =new Product();
			 
			p.setProductID(Integer.parseInt(req.getParameter("pID")));
			p.setBrandID(Integer.parseInt(req.getParameter("brandID")));
			p.setName(req.getParameter("pName"));
			p.setCategoryID(Integer.parseInt(req.getParameter("categoryID")));
			p.setImgFirst(req.getParameter("imgFirst"));
			p.setImgLast(req.getParameter("imgLast"));
			p.setPrice(Float.parseFloat(req.getParameter("price")));
			p.setQuantity(Integer.parseInt(req.getParameter("quantity")));		
			
			try {
			
	 			 if(gp.updateProduct(p)) {
	 				req.setAttribute("update", 1);
					  RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/admin/product/list?currentPage=1");
	 			 }  
	 			  else {
						 
						 req.setAttribute("update", 0);
						 RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher( "/admin/product/update");
						  
						  dispatcher.forward(req, resp);
				  }
			}
			catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
}
