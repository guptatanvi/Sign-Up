<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tanvigupta
  Date: 23/06/17
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>
<h1>List of Users</h1>
<table border="1px" cell-padding="2px">
    <thead>
    <tr>
        <th>Name</th><th>Email</th><th>Password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.pw}</td>
            <td>
                <a href="${pageContext.request.contextPath}/user/edit">Edit</a><br/>
                <a href="${pageContext.request.contextPath}/user/delete/${user.name}.html">Delete</a><br/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>
