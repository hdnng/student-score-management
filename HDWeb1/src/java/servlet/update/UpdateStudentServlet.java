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
import model.Faculty;
import model.Users;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateStudentServlet", urlPatterns = {"/updatestudent"})
public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UsersDAO sdb = new UsersDAO();
        try {
            Users s = sdb.getUsersByID(id);
            request.setAttribute("user", s);
            request.getRequestDispatcher("updateuser.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birth = request.getParameter("birthday");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        int facultyId = Integer.parseInt(request.getParameter("facultyId"));
        Faculty f = new Faculty();
        f.setId(facultyId);
        UsersDAO sdb = new UsersDAO();
        try {
            sdb.update(new Users(id, name, birth, address, email, phoneNumber, f));
            response.sendRedirect("student?id=" + facultyId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
