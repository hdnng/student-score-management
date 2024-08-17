package servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import dao.LoginDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");

        LoginDAO loginDAO = new LoginDAO();
//        if (loginDAO.validate(username, password)) {
//            request.getSession().setAttribute("name", username);
//            response.sendRedirect("homepage.jsp");
//        } else {
//            request.setAttribute("errorMessage", "Invalid username or password. Please try again.");
//
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }

        try {
            boolean isValidUser = loginDAO.validate(username, password);

            if (isValidUser) {
                String name = loginDAO.getName(username);
                int id = loginDAO.getId(username);

                // Đăng nhập thành công, lưu thông tin người dùng trong phiên làm việc
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("name", name);
                session.setAttribute("uid", id);
                response.sendRedirect("homepage.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid username or password. Please try again.");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
