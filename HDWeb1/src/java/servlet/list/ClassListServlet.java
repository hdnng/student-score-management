/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.list;


import dao.FacultyDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Faculty;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ClassListServlet", urlPatterns = {"/classlist"})
public class ClassListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            //processRequest(request, response);
            FacultyDAO fdb = new FacultyDAO();
            List<Faculty> list = fdb.getALL();
            request.setAttribute("data", list);
            request.getRequestDispatcher("classlist.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
