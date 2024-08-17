/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.list;

import dao.ClassDAO;
import dao.FacultyDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Clazz;
import model.Faculty;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ClassServlet", urlPatterns = {"/clazz"})
public class ClassServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String id = request.getParameter("id");
        try {
            FacultyDAO fbd = new FacultyDAO();
            List<Faculty> listF = fbd.getALL();
            request.setAttribute("faculties", listF);

            if (id != null) {
                int facultyId = Integer.parseInt(id);
                ClassDAO sdb = new ClassDAO();
                List<Clazz> listS = sdb.getClassByFID(facultyId);
                request.setAttribute("clazz", listS);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("classlist").forward(request, response);

    }
}
