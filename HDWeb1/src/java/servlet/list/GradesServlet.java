/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.list;

import dao.GradesDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Grade;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GradesServlet", urlPatterns = {"/grades"})
public class GradesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("uid");
        try {
            if (userId != null) {
                GradesDAO gradesDAO = new GradesDAO();
                List<Grade> gradesList = gradesDAO.getGradesByUID(Integer.parseInt(userId));
                request.setAttribute("student", gradesList);
                
                List<Grade> gradesList2 = gradesDAO.getGradesByUID2(Integer.parseInt(userId));
                request.setAttribute("student2", gradesList2);
                
                List<Grade> gradesList3 = gradesDAO.getGradesByUID3(Integer.parseInt(userId));
                request.setAttribute("student3", gradesList3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("studentinformation.jsp").forward(request, response);
    }
    
    
}
