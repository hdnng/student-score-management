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
                <h1>Update a User</h1>
                <s:set var="s" value="${requestScope.user}"/>
                <form action="updatestudent" method="post">
                    <table>
                        <tr>
                            <td>Id:</td>
                            <td><input type="text" readonly name="id" value="${s.id}"/></td>
                        </tr>
                        <tr>
                            <td>Enter name:</td>
                            <td><input type="text" required name="name" value="${s.name}"/></td>
                        </tr>
                        <tr>
                            <td>Enter birthday:</td>
                            <td><input type="text" required name="birthday" value="${s.birthday}"/></td>
                        </tr>
                        <tr>
                            <td>Enter address:</td>
                            <td><input type="text" required name="address" value="${s.address}"/></td>
                        </tr>
                        <tr>
                            <td>Enter email:</td>
                            <td><input type="email" required name="email" value="${s.email}"/></td>
                        </tr>
                        <tr>
                            <td>Faculty phone number:</td>
                            <td><input type="text" readonly name="phoneNumber" value="${s.phoneNumber}"/></td>
                        </tr>
                        <tr>
                            <td>Faculty ID:</td>
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
