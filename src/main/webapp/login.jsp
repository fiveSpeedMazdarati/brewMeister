<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="bootstrap-header.jsp"%>
    <title>Log In To Use Brewmeister</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col col-lg-2">
        </div>
        <div class="col col-md-auto">
                <form action="j_security_check" method="POST">
                    <label>Username:</label><input type="text" name="j_username"><br />
                    <label>Password:</label><input type="password" name="j_password">
                    <input type="submit" value="Log In">
                </form>
        </div>
        <div class="col col-lg-2">
        </div>
    </div>
</div>
</body>
</html>
