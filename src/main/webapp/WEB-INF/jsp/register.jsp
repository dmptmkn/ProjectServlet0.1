<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <form action="/register" method="post">
        <label for="name">Name:
        <input type="text" name="name" id="name">
        </label>
        <br>
        <label for="lastname">Last name:
            <input type="text" name="lastname" id="lastname">
        </label>
        <br>
        <label for="age">Age:
            <input type="number" name="age" id="age">
        </label>
        <br>
        <label for="login">Login:
            <input type="text" name="login" id="login">
        </label>
        <br>
        <label for="password">Password:
            <input type="text" name="password" id="password">
        </label>
        <br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
