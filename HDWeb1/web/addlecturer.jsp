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
        <title>ADD STUDENT</title>
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
                <form action="addlecturer">
                    <h1>Add a new lecturer for <input type="text" name = "facultyID" readonly value="${param.id}"></h1>
                    <h3 style="color: red">${requestScope.error}</h3>
                    <table>
                        <tr>
                            <td>Enter name:</td>
                            <td><input type="text"  name="name" placeholder="enter name" required/></td>
                        </tr>
                        <tr>
                            <td>Enter birth:</td>
                            <td><input type="text"  name="birthday" placeholder="enter birthday" required/></td>
                        </tr>
                        <tr>
                            <td>Enter address:</td>
                            <td><input type="text"  name="address" placeholder="enter address" required/></td>
                        </tr>
                        <tr>
                            <td>Enter email:</td>
                            <td><input type="email"  name="email" placeholder="enter email" required/></td>
                        </tr>
                        <tr>
                            <td>Enter phone number:</td>
                            <td><input type="text"  name="phone" placeholder="enter phone number" required/></td>
                        </tr>
                        
                        <tr>
                            <td>Enter username:</td>
                            <td><input type="text"  name="username" placeholder="enter username" required/></td>
                        </tr>
                        
                        <tr>
                            <td>Enter password:</td>
                            <td><input type="text"  name="password" placeholder="enter password" required/></td>
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
