/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.list;

import dao.FacultyDAO;
import dao.UsersDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Faculty;
import model.Users;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LecturerServlet", urlPatterns = {"/lecturer"})
public class LecturerServlet extends HttpServlet {

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
                UsersDAO sdb = new UsersDAO();
                List<Users> listS = sdb.getLecturerByFID(facultyId);
                request.setAttribute("lecturer", listS);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("lecturerlist").forward(request, response);

    }

}
