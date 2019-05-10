<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="bootstrap-header.jsp"%>
    <title>Sign Up | Brewmeister</title>
</head>
<body>
  <div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 panel panel-default text-center">
            <form>
                <div class="form-group">
                  <label for="username">Username</label>
                  <input type="text" id="username" name="username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password">
                </div>
                <div class="form-group">
                    <label for="first-name">First Name</label>
                    <input type="text" id="first-name" name="first-name">
                </div>
                <div class="form-group">
                    <label for="last-name">Last Name</label>
                    <input type="text" id="last-name" name="last-name">
                </div>
                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="text" id="email" name="email">
                </div>
                <div class="form-group">
                    <label for="zip-code">ZIP Code</label>
                    <input type="text" id="zip-code" name="zip-code">
                </div>
                <div class="form-group">
                    <label for="birthdate">Birthdate</label>
                    <input type="date" id="birthdate" name="birthdate">
                </div>
                <input type="submit" formenctype="application/x-www-form-urlencoded" formmethod="POST" formaction="createNewUser">
            </form>
        </div>
    </div><!-- end row -->
  </div> <!-- end container -->
</body>
</html>
