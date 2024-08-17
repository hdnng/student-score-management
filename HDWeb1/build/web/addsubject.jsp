<%-- 
    Document   : addsubject
    Created on : Jun 20, 2024, 3:15:10 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD SUBJECT</title>
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
                <form action="addsubject">
                    <h1>Add a new subject for <input type="text" name = "facultyID" readonly value="${param.id}"></h1>
                    <h3 style="color: red">${requestScope.error}</h3>
                    <table>
                        <tr>
                            <td>Enter name:</td>
                            <td><input type="text"  name="name" placeholder="name" required/></td>
                        </tr>
                        <tr>
                            <td>Enter describe:</td>
                            <td><input type="text"  name="describe" placeholder="describe" required/></td>
                        </tr>
                        <tr>
                            <td>Enter credit:</td>
                            <td><input type="text"  name="creditHour" placeholder="credit hour" required/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="SAVE"/></td>
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
