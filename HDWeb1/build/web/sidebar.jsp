
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String name = (String) session.getAttribute("name");
%>
<!DOCTYPE html>

<html>
    <head>
    </head>
    <body>
        <div class="menu" >
            <center>
                <img src="#aa" width="175" height="175">
                <h1><a href="personalcontact.jsp"><%= name%></a></h1>
            </center>
            <br>
            <ul>
                <li>
                    <a href="homepage.jsp">Home page</a>
                </li>
                <li>
                    <a href="studentlist">Student</a>
                </li>
                <li>
                    <a href="lecturerlist">Lecturer</a>
                </li>
                <li>
                    <a href="classlist">Class</a>
                </li>
                <li>
                    <a href="#">Class Schedule</a>
                </li>
                <li>
                    <a href="subjectlist">Subject</a>
                </li>
                <li>
                    <a href="personalcontact">Personal Contact</a>
                </li>
            </ul>

        </div>
    </body>
</html>