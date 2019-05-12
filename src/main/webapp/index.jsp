<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="bootstrap-header.jsp" %>
    <link rel="stylesheet" href="brewmeister.css" type="text/css">
    <title>Brewmeister | Track your home brews!</title>
</head>
<body>
<div class="container">
<h2 class="text-center"><img id="main-img" src="beerGlasses.png"></h2>
    <div class="panel panel-default center-block text-center">
    <p class="h3">You've found BREWMEISTER!</p>
      <div>
        <a href="getAllBatchesForUser"><span class="btn">Login</span></a>
        <span class="btn"><a href="showCreateNewUser">Sign Up</a></span>
      </div>
    </div>
</div>
</body>
</html>
