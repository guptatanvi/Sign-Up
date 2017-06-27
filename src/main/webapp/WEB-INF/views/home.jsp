<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tanvigupta
  Date: 23/06/17
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Home Page</h1>
<p>
    ${message}<br>
    <a href="<s:url value="/user/add"/>">Sign up</a><br>
    <a href="<s:url value="/user/list"/>">List of Users</a>
</p>
</body>
</html>
