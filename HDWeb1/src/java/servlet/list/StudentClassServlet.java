/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.list;

import dao.UsersDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Users;

/**
 *
 * @author Admin
 */
@WebServlet(name = "StudentClassServlet", urlPatterns = {"/studentclass"})
public class StudentClassServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("cid");
        UsersDAO userDao = new UsersDAO();
        int classID = Integer.parseInt(id);
        
        List<Users> students = userDao.getStudentsByClassID(classID);
        request.setAttribute("students", students);
        request.getRequestDispatcher("studentclass.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
