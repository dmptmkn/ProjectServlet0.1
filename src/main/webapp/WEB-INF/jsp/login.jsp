<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/login" method="post">
        <label for="login">Login:
        <input type="text" name="login" id="login" required>
        </label>
        <br>
        <label for="password">Password:
            <input type="text" name="password" id="password" required>
        </label>
        <br>
        <button type="submit">Sign in</button>
        <a href="/register">
        <button type="button">Register</button>
        </a>
    </form>
</body>
</html>
