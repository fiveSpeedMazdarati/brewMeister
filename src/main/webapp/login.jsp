<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="bootstrap-header.jsp"%>
    <link rel="stylesheet" href="brewmeister.css" type="text/css" />
    <title>Log In To Use Brewmeister</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-centered">
        <form action="j_security_check" method="POST">
            <div class="form-group">
              <label for="j_username">Username:</label>
              <input type="text" name="j_username" id="j_username">
            </div>
            <div class="form-group">
              <label for="j_password">Password:</label>
              <input type="password" name="j_password" id="j_password">
            </div>
            <input class="btn btn-submit" type="submit" value="Log In">
        </form>
        </div>
    </div>
</div>
</body>
</html>
