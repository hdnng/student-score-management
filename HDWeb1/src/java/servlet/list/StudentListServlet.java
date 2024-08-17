/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.list;

import dao.FacultyDAO;
import dao.UsersDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Faculty;
import model.Users;

@WebServlet(name = "StudentListServlet", urlPatterns = {"/studentlist"})
public class StudentListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            FacultyDAO fdb = new FacultyDAO();
            List<Faculty> list = fdb.getALL();
            request.setAttribute("data", list);
            request.getRequestDispatcher("studentlist.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
