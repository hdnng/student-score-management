/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.update;

import dao.SubjectDAO;
import model.Faculty;
import model.Subject;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateSubjectServlet", urlPatterns = {"/updatesubject"})
public class UpdateSubjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SubjectDAO sdb = new SubjectDAO();
        try {
            Subject s = sdb.getSubjectByID(id);
            request.setAttribute("subject", s);
            request.getRequestDispatcher("updatesubject.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int creditHour = Integer.parseInt(request.getParameter("creditHour"));
        String describe = request.getParameter("describe");
        int facultyId = Integer.parseInt(request.getParameter("facultyId"));
        Faculty f = new Faculty();
        f.setId(facultyId);
        SubjectDAO sdb = new SubjectDAO();
        try {
            sdb.update(new Subject(id, name, describe, creditHour, f));
            response.sendRedirect("subject?id=" + facultyId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
