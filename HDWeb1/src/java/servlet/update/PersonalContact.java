/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.update;

import dao.UsersDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Users;

/**
 *
 * @author Admin
 */
@WebServlet(name = "PersonalContact", urlPatterns = {"/personalcontact"})
public class PersonalContact extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("uid") != null) {
            int id = (int) session.getAttribute("uid");
            UsersDAO udb = new UsersDAO();
            try {
                Users s = udb.getUsersByID(id);
                request.setAttribute("user", s);
                request.getRequestDispatcher("personalcontact.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            response.sendRedirect("personalcontact.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("uid");
        String address = request.getParameter("address");
        String email = request.getParameter("mail");
        String phoneNumber = request.getParameter("phone");
        UsersDAO userDao = new UsersDAO();
        try {
            userDao.updatePersonalInfo(new Users(id, address, email, phoneNumber));
            response.sendRedirect("personalcontact");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
