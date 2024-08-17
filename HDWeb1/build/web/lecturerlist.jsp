
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subject list</title>
        <link rel="stylesheet" href="style.css"/>
        <script>
            function select() {
                var select = document.getElementById("sl");
                var selectedOption = select.options[select.selectedIndex].value;
                if (selectedOption && selectedOption !== "Select faculty") {
                    window.location.href = selectedOption;
                } else {
                    window.location.href = "lecturer";
                }
            }

            function updateADDButton() {
                var select = document.getElementById("sl");
                var addButton = document.getElementById("addButton");
                var selectedOption = select.options[select.selectedIndex].value;
                if (selectedOption && selectedOption !== "Select faculty") {
                    var facultyId = selectedOption.split('=')[1];
                    addButton.href = "addlecturer.jsp?id=" + facultyId;
                } else {
                    addButton.href = "addlecturer.jsp";
                }
            }

            document.addEventListener('DOMContentLoaded', function () {
                document.getElementById("sl").addEventListener('change', updateADDButton);
                updateADDButton();  // Ensure the button is updated on page load
            });

            function dodelete(id, fid) {
                if (confirm("are you sure to delete subject with id = " + id)) {
                    window.location = "deletelecturer?id=" + id + "&fid=" + fid;
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
                <table>
                    <tr>
                        <td>
                            Faculty:
                            <select id="sl" onchange="select()">
                                <option>Select faculty</option>
                                <c:forEach items="${data}" var="faculty">
                                    <option value="lecturer?id=${faculty.id}"
                                            <c:if test="${param.id == faculty.id}">selected</c:if>>
                                        ${faculty.facultyName}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <button><a id="addButton" href="addlecturer.jsp">ADD</a></button>
                        </td>
                    </tr>
                </table>
                <table border="1px">
                    <thead>
                        <tr>
                            <th>Lecturer ID</th>
                            <th>Name</th>
                            <th>Birth</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Phone Number</th>
                            <th>ACTION</th>
                        </tr>
                    </thead>
                    <tbody id="subjectTableBody">
                        <c:forEach items="${lecturer}" var="c">
                            <tr>
                                <td>${c.id}</td>
                                <td>${c.name}</td>
                                <td>${c.birthday}</td>
                                <td>${c.address}</td>
                                <td>${c.email}</td>
                                <td>${c.phoneNumber}</td>
                                <td>
                                    <a href="updatelecturer?id=${c.id}">update</a>
                                    <a href="#"onclick="dodelete('${c.id}','${param.id}')">delete</a>
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

