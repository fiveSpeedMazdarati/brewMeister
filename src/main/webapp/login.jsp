
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In To Use Brewmeister</title>
</head>
<body>
    <form action="j_security_check" method="POST">
        <label>Username:</label><input type="text" name="j_username">
        <label>Password:</label><input type="password" name="j_password">
        <input type="submit" value="Log In">
    </form>
</body>
</html>
