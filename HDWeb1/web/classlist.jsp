<%-- 
    Document   : quanlylop
    Created on : Jun 12, 2024, 2:08:10 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css"/>
        <script>
            function select() {
                var select = document.getElementById("sl");
                var selectedOption = select.options[select.selectedIndex].value;
                if (selectedOption && selectedOption !== "Select faculty") {
                    window.location.href = selectedOption;
                } else {
                    window.location.href = "clazz";
                }
            }

            function updateADDButton() {
                var select = document.getElementById("sl");
                var addButton = document.getElementById("addButton");
                var selectedOption = select.options[select.selectedIndex].value;
                if (selectedOption && selectedOption !== "Select faculty") {
                    var facultyId = selectedOption.split('=')[1];
                    addButton.href = "addsubject.jsp?id=" + facultyId;
                } else {
                    addButton.href = "addsubject.jsp";
                }
            }

            document.addEventListener('DOMContentLoaded', function () {
                document.getElementById("sl").addEventListener('change', updateADDButton);
                updateADDButton();  // Ensure the button is updated on page load
            });

            function dodelete(id, fid) {
                if (confirm("are you sure to delete subject with id = " + id)) {
                    window.location = "deletesubject?id=" + id + "&fid=" + fid;
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
                <h2>Class INFO</h2><br>
                Faculty: 
                <select id="sl" onchange="select()">
                    <option>Select faculty</option>
                    <c:forEach items="${data}" var="faculty">
                        <option value="clazz?id=${faculty.id}"
                                <c:if test="${param.id == faculty.id}">selected</c:if>>
                            ${faculty.facultyName}
                        </option>
                    </c:forEach>
                </select>
                <div dir="rtl">
                    <button>add</button>
                </div>
                <table border="1px">
                    <thead>
                        <tr>
                            <th>Class ID</th>
                            <th>Class Name</th>
                            <th>Lecturer Name</th>
                            <th>Action</th>
                        </tr> 
                    </thead>
                    <tbody id="classTableBody">
                        <c:forEach items="${clazz}" var="s">
                            <tr>
                                <td>${s.id}</td>
                                <td><a href="studentclass?cid=${s.id}">${s.className}</a></td>
                                <td>${s.lecturer.name}</td>
                                <td>
                                    <a href="updatesubject?id=${s.id}">Update</a>&nbsp;&nbsp;&nbsp;
                                    <a href="#" onclick="dodelete('${s.id}', '${s.faculty.id}')">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>
