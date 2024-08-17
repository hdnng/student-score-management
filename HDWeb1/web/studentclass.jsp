<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>STUDENT LIST</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <script type="text/javascript">
        function confirmDelete(id) {
            return confirm("Are you sure to delete student with ID = " + id + "?");
        }

        function toggleAddStudentForm() {
            var form = document.getElementById("addStudentForm");
            if (form.style.display === "none") {
                form.style.display = "block";
            } else {
                form.style.display = "none";
            }
        }
    </script>
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
            <h2>Students INFO</h2><br>
            <div dir="rtl">
                <button type="button" onclick="toggleAddStudentForm()">ADD STUDENT</button>
            </div>
            <div id="addStudentForm" style="display:none; margin-top: 20px;">
                <form action="addstudent" method="post">
                    <label for="studentId">Student ID:</label>
                    <input type="text" id="studentId" name="studentId" required/>
                    <button type="submit">Submit</button>
                </form>
            </div>
            <br>
            <center>
                <table border="1px">
                    <thead>
                        <tr>
                            <th>Student ID</th>
                            <th>Name</th>
                            <th>Birth</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Phone Number</th>
                            <th>ACTION</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${students}" var="s">
                            <tr>
                                <td>${s.id}</td>
                                <td><a href="grades?uid=${s.id}">${s.name}</a></td>
                                <td>${s.birthday}</td>
                                <td>${s.address}</td>
                                <td>${s.email}</td>
                                <td>${s.phoneNumber}</td>
                                <td>
                                    <a href="updatestudent?id=${s.id}">Update</a>
                                    &nbsp;&nbsp;&nbsp;
                                    <a href="#" onclick="if(confirmDelete('${s.id}')) window.location='deletestudent?id=${s.id}'">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </center>
        </div>
    </div>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</body>
</html>