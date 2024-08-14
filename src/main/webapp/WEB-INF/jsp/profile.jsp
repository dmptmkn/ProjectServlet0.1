<%@ page import="org.example.dto.UserDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% UserDto user = (UserDto) request.getSession().getAttribute("user"); %>
<html>
<head>
    <title>Your Profile</title>
</head>
<body>
    <h2>Your profile</h2>
    <h3>Id: <%=user.getId()%></h3>
    <h3>Name: <%=user.getName()%></h3>
    <h3>Last name: <%=user.getLastName()%></h3>
    <h3>Age: <%=user.getAge()%></h3>
</body>
</html>
