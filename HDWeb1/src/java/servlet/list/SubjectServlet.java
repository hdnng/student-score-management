package servlet.list;

import dao.FacultyDAO;
import dao.SubjectDAO;
import model.Faculty;
import model.Subject;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SubjectServlet", urlPatterns = {"/subject"})
public class SubjectServlet extends HttpServlet {

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
                SubjectDAO sdb = new SubjectDAO();
                List<Subject> listS = sdb.getSubjectsByFID(facultyId);
                request.setAttribute("subjects", listS);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("subjectlist").forward(request, response);

    }
}
