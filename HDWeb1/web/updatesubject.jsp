<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME PAGE</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <header>
            <jsp:include page="header.jsp"/>
        </header>
        <div class="container">
            <nav>
                <jsp:include page="sidebar.jsp"/>
            </nav>
            <div class="maincontent">
                <h1>Update a subject</h1>
                <s:set var="s" value="${requestScope.subject}"/>
                <form action="updatesubject" method="post">
                    <table>
                        <tr>
                            <td>Id:</td>
                            <td><input type="text" readonly name="id" value="${s.id}"/></td>
                        </tr>
                        <tr>
                            <td>Enter subject name:</td>
                            <td><input type="text" required name="name" value="${s.subjectName}"/></td>
                        </tr>
                        <tr>
                            <td>Enter describe:</td>
                            <td><input type="text" required name="describe" value="${s.describe}"/></td>
                        </tr>
                        <tr>
                            <td>Enter credit hour:</td>
                            <td><input type="text" required name="creditHour" value="${s.creditHour}"/></td>
                        </tr>
                        <tr>
                            <td>Faculty id:</td>
                            <td><input type="text" readonly name="facultyId" value="${s.faculty.getId()}"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="UPDATE"/></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>
