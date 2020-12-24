package controller.admin;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import connect.DBConnect;
import get.BrandDAO;
import get.CategoryDAO;
import model.Brand;
import model.Category;
import model.Product;



@WebServlet(urlPatterns = { "/admin/product/add" })
public class ProductAddController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 @Override
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Product product = new Product();
		
		try {
		Connection connection = DBConnect.getConnecttion();
			String sql ="INSERT INTO product (productID, categoryID, Name, brandID, imgFirst, imgLast,price, description,quantity) VALUES(?,?,?,?,?,?,?,?,?)";
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
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		
//		
//		Product product = new Product();
//		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
//
//		try {
//			
//			 // Đường dẫn tuyệt đối tới thư mục gốc của web app.
//	           String appPath = req.getServletContext().getRealPath("");
//	           appPath = appPath.replace('\\', '/');
//	 
//	  
//	           // Thư mục để save file tải lên.
//	           String fullSavePath = null;
//	           if (appPath.endsWith("/")) {
//	               fullSavePath = appPath + SAVE_DIRECTORY;
//	           } else {
//	               fullSavePath = appPath + "/" + SAVE_DIRECTORY;
//	           }
//	 
//	           
//	           // Tạo thư mục nếu nó không tồn tại.
//	           File fileSaveDir = new File(fullSavePath);
//	           if (!fileSaveDir.exists()) {
//	               fileSaveDir.mkdir();
//	           }
//			
//			List<FileItem> items = servletFileUpload.parseRequest(req);
//			for (FileItem item : items) {
//				
//				if (item.getFieldName().equals("pName")) {
//					
//					product.setName(item.getString());
//				} 
//				
//				else if (item.getFieldName().equals("pID")) {
//					product.setProductID(item.getString());
//				}
//				else if (item.getFieldName().equals("categoryID")) {
//					product.setCategoryID(item.getString());
//				}
//				else if (item.getFieldName().equals("brandID")) {
//					product.setBrandID(item.getString());
//				}
//				else if (item.getFieldName().equals("price")) {
//					product.setPrice(Double.parseDouble(item.getString()));
//				} 
//				
//				else if (item.getFieldName().equals("description")) {
//					product.setDescription(item.getString());
//					
//				} 
//				else if (item.getFieldName().equals("quantity")) {
//					product.setQuantity(Integer.parseInt(item.getString()));
//				}
//				
//				else if (item.getFieldName().equals("imgFirst")) {
//					
//					
//					String originalFileName = item.getName();
//					int index = originalFileName.lastIndexOf(".");
//					String ext = originalFileName.substring(index + 1);
//					String fileName = System.currentTimeMillis() + "." + ext;
//					
//					System.out.println(fileName);
//					String filePath = fullSavePath + "/" + fileName;
//					File file = new File(filePath);
//					
//					
//					item.write(file);
//					product.setImgFirst(filePath);
//					System.out.println(filePath);
//				}
//				
//				else if (item.getFieldName().equals("imgLast")) {
//					
//					
//					String originalFileName = item.getName();
//					int index = originalFileName.lastIndexOf(".");
//					String ext = originalFileName.substring(index + 1);
//					String fileName = System.currentTimeMillis() + "." + ext;
//					
//					String filePath = fullSavePath + "/" + fileName;
//					File file = new File(filePath);
//					item.write(file);
//					product.setImgLast(filePath);
//				}
//			
//			}
//			
//				Connection connection = DBConnect.getConnecttion(); 
//			
//				String sql ="INSERT INTO product (productID, categoryID, Name, brandID, imgFirst, imgLast,price, description,quantity) VALUES(?,?,?,?,?,?,?,?,?)";
//				PreparedStatement ps = connection.prepareStatement(sql); 
//					
//				  ps.setString(1, product.getProductID());
//				  ps.setString(2, product.getCategoryID());
//				  ps.setString(3, product.getName());
//				  ps.setString(4, product.getBrandID());
//				  ps.setDouble(7, product.getPrice());
//				  ps.setString(8, product.getDescription());
//				  ps.setInt(9, product.getQuantity());
//				  ps.setString(5, product.getImgFirst());
//				  ps.setString(6, product.getImgLast());
//				  			 
//				  int row = ps.executeUpdate(); 
//				  if (row > 0) {
//					  req.setAttribute("addSuccess", 1);
//					  RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/admin/product/list?currentPage=1");
//					  
//					  dispatcher.forward(req, resp);
//				  } 
//				  else {
//						 
//						 req.setAttribute("addSuccess", 0);
//						 RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher( "/admin/product/add");
//						  
//						  dispatcher.forward(req, resp);
//				  }
//				 
//			
//		} catch (FileUploadException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//	
//}
//	





//package controller.admin;
//
//import java.io.File;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.print.DocFlavor.URL;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//
//import connect.DBConnect;
//import get.GetBrand;
//import get.GetCategory;
//import model.Brand;
//import model.Category;
//import model.Product;
//import model.User;
//
//@WebServlet(urlPatterns = { "/admin/product/add" })
//public class ProductAddController extends HttpServlet {
//
//	final String UPLOAD_DIRECTORY = "images";
//	public static final String SAVE_DIRECTORY = "images";
//
//	@Override protected void doGet(HttpServletRequest req, HttpServletResponse
//  resp) throws ServletException, IOException { ArrayList<Category> cate = new
//  ArrayList<Category>(); GetCategory getCate = new GetCategory();
//  
//  ArrayList<Brand> brand =new ArrayList<Brand>(); GetBrand getBrand = new
// GetBrand(); try { brand = getBrand.getListBrand(); } catch (SQLException e) {
//  // TODO Auto-generated catch block e.printStackTrace(); }
//  req.setAttribute("ListBrand", brand);
//  
//  
//  try { cate = getCate.getListCategory(); } catch (SQLException e) { // TODO
//  Auto-generated catch block e.printStackTrace(); }
//  req.setAttribute("ListCategory", cate);
//  
//  RequestDispatcher dispatch =
//  req.getRequestDispatcher("/admin/addProduct.jsp"); dispatch.forward(req,
//  resp);
//  
//  File file = new File(""); String currentDirectory = file.getAbsolutePath();
//  System.out.println("Current working directory : " + currentDirectory); String
//  workingDir = System.getProperty("user.dir");
//  System.out.println("Current working directory : " + workingDir);
//  
//  
//  
//  }
//
//	@Override protected void doPost(HttpServletRequest req, HttpServletResponse
// resp) throws ServletException, IOException {
//  
//  
// // Đường dẫn tuyệt đối tới thư mục gốc của web app. String appPath =
//  req.getServletContext().getRealPath(""); appPath = appPath.replace('\\',
//  '/'); Product product = new Product();
// 
//  // Thư mục để save file tải lên. String fullSavePath = null; if
//  (appPath.endsWith("/")) { fullSavePath = appPath + SAVE_DIRECTORY; } else {
//  fullSavePath = appPath + "/" + SAVE_DIRECTORY; }
//  
//  
//  // Tạo thư mục nếu nó không tồn tại. File fileSaveDir = new
//  File(fullSavePath); if (!fileSaveDir.exists()) { fileSaveDir.mkdir(); }
//  
//  
//  DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//  ServletFileUpload servletFileUpload = new
//  ServletFileUpload(diskFileItemFactory);
//  
//  try { List<FileItem> items = servletFileUpload.parseRequest(req);
//  System.out.println(items); for (FileItem item : items) { if
//  (item.getFieldName().equals("pName")) { product.setName(item.getString()); }
//  else if (item.getFieldName().equals("pID")) {
//  
//  product.setProductID(item.getString()); } else if
//  (item.getFieldName().equals("category")) {
//  
//  product.setCategoryID(item.getString()); } else if
//  (item.getFieldName().equals("brand")) {
//  
//  product.setBrandID(item.getString()); } else if
//  (item.getFieldName().equals("price")) {
//  
//  product.setPrice(Double.parseDouble(item.getString())); }
//  
//  else if (item.getFieldName().equals("description")) {
//  product.setDescription(item.getString()); }
//  
//  else if (item.getFieldName().equals("imgFirst")) { final String dir =
//  appPath+"/images"; String originalFileName = item.getName(); int index =
//  originalFileName.lastIndexOf("."); String ext =
//  originalFileName.substring(index + 1); String fileName =
//  System.currentTimeMillis() + "." + ext; //File file = new File(dir + "/" +
//  fileName); //File file = new File(fullSavePath + "/" + fileName); String
//  filePath = fullSavePath + File.separator + fileName; File file = new
//  File(filePath); item.write(file); product.setImgFirst("/images/" + fileName);
//  } else if (item.getFieldName().equals("imgLast")) { final String dir2 =
//  appPath+ "/images"; String originalFileName = item.getName(); int index =
//  originalFileName.lastIndexOf("."); String ext =
//  originalFileName.substring(index + 1); String fileName =
//  System.currentTimeMillis() + "." + ext; String filePath2 = fullSavePath +
//  File.separator + fileName;
//  
//  File file = new File(filePath2); item.write(file);
//  product.setImgLast("/images/" + fileName); } }
//  
//  
//  //productService.insert(product);
//  
//  Connection connection = DBConnect.getConnecttion(); String sql =
//  "INSERT INTO product (productID, categoryID, Name, brandID, imgFirst, imgLast,price, description,quantity) VALUES(?,?,?,?,?,?,?,?,?)"
//  ; PreparedStatement ps = connection.prepareStatement(sql); // ps.setString(1,
//  product.getProductID()); ps.setString(1, product.getProductID());
//  ps.setString(2, product.getCategoryID()); ps.setString(3, product.getName());
//  ps.setString(4, product.getBrandID()); ps.setDouble(7, product.getPrice());
//  ps.setString(8, product.getDescription()); ps.setInt(9,
//  product.getQuantity());
//  
//  ps.setString(5, product.getImgFirst()); ps.setString(6,
//  product.getImgLast());
//  
//  String message ="upload fail"; int row = ps.executeUpdate(); if (row > 0) {
//  message = "File uploaded and saved into database"; } else
//  System.out.println(message);
//  
//  //resp.sendRedirect(req.getContextPath() +
//  "/admin/product/list?currentPage=1");
//  
//  RequestDispatcher dispatcher =
//  req.getServletContext().getRequestDispatcher(req.getContextPath() +
//  "/admin/product/list?currentPage=1");
//  
//  dispatcher.forward(req, resp);
//  
//  } catch (FileUploadException e) { e.printStackTrace(); } catch (Exception e)
//  { e.printStackTrace(); }
//  
//  }
//}
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Date;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//
//import connect.DBConnect;
//
///
//
//@WebServlet("/admin/product/add")
//
//@MultipartConfig(maxFileSize = 16177215)
//
//public class ProductAddController extends HttpServlet {
//
//	//
//
//	//
//	private static final long serialVersionUID = 1L;
//	private static final String UPLOAD_DIRECTORY = "images";
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//	}
//
//	@Override protected void doPost(HttpServletRequest request,
//		  HttpServletResponse response) throws ServletException, IOException {
//		  //processRequest(request, response); // gets values of text fields String
//		  productID = request.getParameter("productID"); String ProductName =
//		  request.getParameter("productName"); String categoryID =
//		  request.getParameter("categoryID"); String BrandID =
//		  request.getParameter("brandID");
//		  
//		  double price = Double.parseDouble(request.getParameter("price")); String
//		  description = request.getParameter("description"); int quantity =
//		  Integer.parseInt(request.getParameter("quantity"));
//		  
//		  InputStream inputStream = null; InputStream inputStream1 = null;
//		  
//		  
//		  // obtains the upload file part in this multipart request Part filePart =
//		  request.getPart("imgFirst"); if (filePart != null) { // prints out some
//		  information for debugging System.out.println(filePart. getName());
//		  System.out.println(filePart.getSize());
//		  System.out.println(filePart.getContentType());
//		  
//		  // obtains input stream of the upload file inputStream =
//		  filePart.getInputStream();
//		  
//		  
//		  
//		  } Part filePart1 = request.getPart("imgLast"); if (filePart1 != null) { //
//		  prints out some information for debugging
//		  System.out.println(filePart1.getName());
//		  System.out.println(filePart1.getSize());
//		  System.out.println(filePart1.getContentType());
//		  
//		  // obtains input stream of the upload file inputStream1 =
//		  filePart1.getInputStream(); }
//		  
//		  
//		  Connection conn = null; // connection to the database String message = null;
//		  // message will be sent back to client
//		  
//		  try { // connects to the database Connection connection =
//		  DBConnect.getConnecttion();
//		  
//		  // constructs SQL statement String sql =
//		  "INSERT INTO product (productID, categoryID, productName, brandID, imgFirst, imgLast,price, description,quantity) VALUES(?,?,?,?,?,?,?,?,?)"
//		  ; PreparedStatement ps = connection.prepareStatement(sql); ps.setString(1,
//		  productID ); ps.setString(2, categoryID); ps.setString(3, ProductName);
//		  ps.setString(4, BrandID); ps.setDouble(7, price); ps.setString(8,
//		  description); ps.setInt(9, quantity);
//		  
//		  if (inputStream != null) {
//		  
//		  String filename = filePart.getSubmittedFileName(); ps.setString(5,
//		  UPLOAD_DIRECTORY + "/" + filename); }
//		  
//		  if (inputStream1 != null) {
//		  
//		  String filename1 = filePart1.getSubmittedFileName(); ps.setString(6,
//		  UPLOAD_DIRECTORY + "/" + filename1); }
//		  
//		  // sends the statement to the database server int row = ps.executeUpdate();
//		  if (row > 0) { message = "File uploaded and saved into database"; } } catch
//		  (SQLException ex) { message = "ERROR: " + ex.getMessage();
//		  ex.printStackTrace(); } finally { if (conn != null) { // closes the database
//		  connection try { conn.close(); } catch (SQLException ex) {
//		  ex.printStackTrace(); } } // sets the message in request scope
//		  request.setAttribute("Message", message); System.out.println(message);
//		  
//		  // forwards to the message page
//		  getServletContext().getRequestDispatcher("/admin/product.jsp").forward(
//		  request, response); }
//		  
//		  }
//
//}
//
///