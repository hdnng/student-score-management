/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.add;

import dao.UsersDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Faculty;
import model.Users;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddClassServlet", urlPatterns = {"/addclass"})
public class AddClassServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int facultyID = Integer.parseInt(request.getParameter("facultyID"));
        Faculty f = new Faculty();
        f.setId(facultyID);
        UsersDAO udb = new UsersDAO();
        try {
            udb.insertStudent(new Users(username, password, name, birthday, address, email, phone, f));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        response.sendRedirect("student?id=" + facultyID);
    }

}
