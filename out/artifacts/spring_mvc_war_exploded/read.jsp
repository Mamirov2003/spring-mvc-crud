<%--
  Created by IntelliJ IDEA.
  User: Onecomputers
  Date: 6/2/2022
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<p><strong>Student List is Here | <a href="create.jsp">Click for Create</a></strong></p>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Course</th>
        <th>Action</th>
    </tr>
    <c:forEach var="student" items="${listStudent}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.course}</td>
            <td><a href="update/<c:out value='${student.id}'/>">Update</a> | <a
                    href="delete/<c:out value='${student.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
