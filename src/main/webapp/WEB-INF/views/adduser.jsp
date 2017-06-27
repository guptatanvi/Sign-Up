<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tanvigupta
  Date: 21/06/17
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/add">
    <table>
        <tbody>
        <tr>
            <td> Name</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><form:input path="pw"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Sign up"></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home Page</a></p>
</body>
</html>
