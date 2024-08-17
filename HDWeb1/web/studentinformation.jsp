<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                Năm học: 
                <select>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
                <br>
                <h1>Học kỳ 1</h1><br>
                <table border="1px">
                    <tr>
                        <th>mã môn</th>
                        <th>tên môn</th>
                        <th>số tín chỉ</th>
                        <th>điểm chuyên cần </th>
                        <th>điểm giữa kì</th>
                        <th>điểm cuối kì</th>
                        <th>action</th>
                    </tr>
                    <c:forEach items="${student}" var="s">
                        <tr>
                            <td>${s.subject.id}</td>
                            <td>${s.subject.subjectName}</td>
                            <td>${s.subject.creditHour}</td>
                            <td>${s.grade1}</td>
                            <td>${s.grade2}</td>
                            <td>${s.grade3}</td>
                            <td>
                                <a href="updatestudent?id=${s.id}">Update</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" onclick="dodelete('${s.id}')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <h1>Học kỳ 2</h1><br>
                <table border="1px">
                    <tr>
                        <th>mã môn</th>
                        <th>tên môn</th>
                        <th>số tín chỉ</th>
                        <th>điểm chuyên cần </th>
                        <th>điểm giữa kì</th>
                        <th>điểm cuối kì</th>
                        <th>action</th>
                    </tr>
                    <c:forEach items="${student2}" var="s">
                        <tr>
                            <td>${s.subject.id}</td>
                            <td>${s.subject.subjectName}</td>
                            <td>${s.subject.creditHour}</td>
                            <td>${s.grade1}</td>
                            <td>${s.grade2}</td>
                            <td>${s.grade3}</td>
                            <td>
                                <a href="updatestudent?id=${s.id}">Update</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" onclick="dodelete('${s.id}')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <h1>Học kỳ 3</h1><br>
                <table border="1px">
                    <tr>
                        <th>mã môn</th>
                        <th>tên môn</th>
                        <th>số tín chỉ</th>
                        <th>điểm chuyên cần </th>
                        <th>điểm giữa kì</th>
                        <th>điểm cuối kì</th>
                        <th>action</th>
                    </tr>
                    <c:forEach items="${student3}" var="s">
                        <tr>
                            <td>${s.subject.id}</td>
                            <td>${s.subject.subjectName}</td>
                            <td>${s.subject.creditHour}</td>
                            <td>${s.grade1}</td>
                            <td>${s.grade2}</td>
                            <td>${s.grade3}</td>
                            <td>
                                <a href="updatestudent?id=${s.id}">Update</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" onclick="dodelete('${s.id}')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>