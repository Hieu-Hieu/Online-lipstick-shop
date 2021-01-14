package controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BrandDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import model.Brand;
import model.Category;
import model.Product;

@WebServlet(urlPatterns = { "/admin/product/update" })
public class ProductUpdateController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		
		ArrayList<Category> cate = new ArrayList<Category>();
		CategoryDAO getCate = new CategoryDAO();

		ArrayList<Brand> brand = new ArrayList<Brand>();
		BrandDAO getBrand = new BrandDAO();
		
		try {
			int productID= Integer.parseInt(req.getParameter("id"));
			System.out.println("pID:"+productID);
			ProductDAO Gproduct = new ProductDAO();
		Product product = Gproduct.getProductByID(productID);
		System.out.println(product);
		req.setAttribute("product", product);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

		RequestDispatcher dispatch = req.getRequestDispatcher("/admin/updateProduct.jsp");
		dispatch.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		resp.getWriter().append("Served at: ").append(req.getContextPath());

		Product product = new Product();
		ProductDAO gp = new ProductDAO();
		CategoryDAO cate = new CategoryDAO();
		BrandDAO brand = new BrandDAO();
		String url = "/admin/addProduct.jsp";

		try {
			int brandId = Integer.parseInt(req.getParameter("brandID"));
			int categoryId = Integer.parseInt(req.getParameter("categoryID"));
			
			product.setProductID(Integer.parseInt(req.getParameter("productID")));
			product.setBrand(brand.getByID(brandId));
			product.setCategory(cate.getByID(categoryId));
			product.setImgFirst(req.getParameter("imgFirst"));
			product.setImgLast(req.getParameter("imgLast"));
			product.setPrice(Float.parseFloat(req.getParameter("price")));
			product.setDescription(req.getParameter("description"));
			product.setQuantity(Integer.parseInt(req.getParameter("quantity")));
			int page = gp.totalPage("from Product");
			
			String pName = req.getParameter("pName").trim();
			product.setName(pName);
			String sql = "FROM Product where productID <>"+ product.getProductID()+ " and "+ "name =" + "'" +  pName + "'";
			if(gp.checkData(sql)==0){
				if(gp.updateProduct(product)){
					url = "/admin/product/list?command=list&currentPage=" + String.valueOf(page);
					System.out.println("1");
				}
			}		
			else {
				req.setAttribute("errorName", "Tên này đã tồn tại");
				req.setAttribute("product", product );
				
				ArrayList<Category> Listcate = new ArrayList<Category>();
				CategoryDAO getCate = new CategoryDAO();

				ArrayList<Brand> Listbrand = new ArrayList<Brand>();
				BrandDAO getBrand = new BrandDAO();

				try {
					Listbrand = getBrand.getListBrand();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				req.setAttribute("ListBrand", Listbrand);

				try {
					Listcate = getCate.getListCategory();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				req.setAttribute("ListCategory", Listcate);
				url = "/admin/addProduct.jsp";
				
				System.out.println("2");
			}
			
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("3");
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher(url);

		dispatcher.forward(req, resp);

	}
}
