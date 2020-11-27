package controller.user;

import get.GetUser;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.User;

public class UserController extends HttpServlet {

	GetUser GetUser = new GetUser();
  Cart cart = new Cart();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        
        
        String url = "";
        User users = new User();
        HttpSession session = request.getSession();
        switch (command) {
            case "insert":
                users.setid(request.getParameter("id"));
                users.setusername(request.getParameter("name"));
                users.setpassword(request.getParameter(("pass")));
                users.setemail(request.getParameter("email"));  
                users.setphone(request.getParameter("phone")); 
                users.setaddress(request.getParameter("address")); 
                users.setrole(false);     
                GetUser.insertUser(users);             
                session.setAttribute("user", users);
                url = "/navigate.jsp";   
                break;
              case "update":
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        boolean role = Boolean.parseBoolean(request.getParameter("role"));
        GetUser.updateUser(new User(id, username, password, email, phone, address, role));
                        url = "/myaccount.jsp";
                        break; 
            case "logindeal":
                users = GetUser.login(request.getParameter("name"), (request.getParameter("pass")));                
                if (users != null) {
                    session.setAttribute("user", users);
                    url = "/deal.jsp";        
                }
                break;
              
                  
            case "login":
                users = GetUser.login(request.getParameter("name"), (request.getParameter("pass")));                
                if (users != null) {
                    session.setAttribute("user", users);
                    url = "/MusicShop/navigate.jsp";        
                }
                
                
                else{
                    request.setAttribute("error", "Lỗi tên đăng nhập hoặc mật khẩu");
                    url = "/login.jsp";
                }
                break;
                
        }
        response.sendRedirect(url);
    

    }

}
