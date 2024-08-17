<%-- 
    Document   : login
    Created on : Jun 12, 2024, 1:58:43 PM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="style.css"/>
        <script>
            function show() {
                var passwordField = document.getElementById("pass");
                if (passwordField.type === "password") {
                    passwordField.type = "text";
                } else {
                    passwordField.type = "password";
                }
            }
        </script>
    </head>
    <body>
    <center>
        <h2 >LOGIN</h2>
        <form action="login" method="post">
            <table>
                <tr>
                    <td>username</td>  
                    <td><input type="text" name = "user" class="user"></td>
                </tr>
                <tr>
                    <td>password</td>  
                    <td><input type="password" name = "pass" class="pass" id="pass">
                    </td>
                </tr>
            </table>
            <input type="checkbox" name="check" onclick="show()">
            <label for="check">show password </label><br>
            <input type="reset" value="reset">
            <input type="submit" value="login">
        </form>
        <% if (request.getAttribute("errorMessage") != null) {%>
        <p style="color: red;"><%= request.getAttribute("errorMessage")%></p>
        <% }%>
    </center>
</body>
</html>-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="login.css"/>
        <script>
            function show() {
                var passwordField = document.getElementById("pass");
                if (passwordField.type === "password") {
                    passwordField.type = "text";
                } else {
                    passwordField.type = "password";
                }
            }
        </script>
    </head>
    <body>
        <div class="login-container">
            <h2>LOGIN</h2>
            <form action="login" method="post">
                <table>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="user" class="user"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" class="pass" id="pass"></td>
                    </tr>
                </table>
                <input type="checkbox" name="check" onclick="show()">
                <label for="check">Show password</label><br>
                <input type="reset" value="Reset">
                <input type="submit" value="Login">
            </form>
            <% if (request.getAttribute("errorMessage") != null) { %>
            <p><%= request.getAttribute("errorMessage") %></p>
            <% } %>
        </div>
    </body>
</html>
