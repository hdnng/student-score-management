/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.add;

import dao.SubjectDAO;
import model.Faculty;
import model.Subject;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddSubjectServlet", urlPatterns = {"/addsubject"})
public class AddSubjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String describe = request.getParameter("describe");
        int creditHour = Integer.parseInt(request.getParameter("creditHour"));
        int facultyID = Integer.parseInt(request.getParameter("facultyID"));
        Faculty f = new Faculty();
        f.setId(facultyID);
        SubjectDAO sdb = new SubjectDAO();
        try {
            sdb.insert(new Subject(name, describe, creditHour, f));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        response.sendRedirect("subject?id=" + facultyID);
    }
}
