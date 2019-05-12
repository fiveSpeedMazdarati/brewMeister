<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="bootstrap-header.jsp"%>
    <link rel="stylesheet" href="brewmeister.css" type="text/css">
    <title>Sign Up | Brewmeister</title>
</head>
<body>
  <div class="container">
      <c:if test="${emailInUseError==true}">
          <div class="alert alert-danger" role="alert">That email address is already in use. Please choose a different one.</div>
      </c:if>
      <c:if test="${usernameInUseError==true}">
          <div class="alert alert-danger" role="alert">That username is already in use. Please choose a different one.</div>
      </c:if>
    <div class="row">
        <div class="col-xs-12 col-md-6 center-block">
            <form>
                <div class="form-group">
                  <label for="username">Username</label>
                  <input class="form-control" type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input class="form-control" type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="first-name">First Name</label>
                    <input class="form-control" type="text" id="first-name" name="first-name" required>
                </div>
                <div class="form-group">
                    <label for="last-name">Last Name</label>
                    <input class="form-control" type="text" id="last-name" name="last-name">
                </div>
                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input class="form-control" type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="zip-code">ZIP Code</label>
                    <input class="form-control" type="text" id="zip-code" name="zip-code" required>
                    <label for="zip-code" class="text-muted small">Optional, but providing a ZIP will enable extra features</label>
                </div>
                <div class="form-group">
                    <label for="birthdate">Birthdate</label>
                    <input class="form-control" type="date" id="birthdate" name="birthdate" required>
                    <label for="birthdate" class="text-muted small">You must be at least 21 years old to use Brewmeister</label>
                </div>
                <input type="submit" formenctype="application/x-www-form-urlencoded" formmethod="POST" formaction="createNewUser">
            </form>
        </div>
    </div> <!-- end row -->
  </div> <!-- end container -->
</body>
</html>
