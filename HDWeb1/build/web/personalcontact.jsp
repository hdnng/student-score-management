<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                <h2>Update personal contact</h2>
                <s:set var="s" value="${requestScope.user}"/>
                <form action="personalcontact" method="post">
                    <table>
                        <tr>
                        <p><i style="color:red"> Note: ......</i></p>
                        </tr>
                        <tr>
                            <td>
                                <label>Email Address:</label>
                            </td>
                            <td>
                                <input name="mail" type="text" value="${s.email}" 
                                       id="mail" class="mail" placeholder="Enter email address " >
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Phone Number:</label>
                            </td>
                            <td>
                                <input name="phone" type="text" value="${s.phoneNumber}" 
                                       id="phone" class="phone" placeholder="enter your phone number">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Current residence:</label>
                            </td>
                            <td>
                                <textarea name="address" id="address" cols="100" rows="3">${s.address}</textarea>
                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Avatar:</label>
                            </td>
                            <td>
                                <input type="file" id="avatar" name="avatar" accept="image/*">
                            </td>
                        </tr>
                        <tr>
                            <td>
                            </td>
                            <td><input type="submit" value="Lưu"></td>
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
