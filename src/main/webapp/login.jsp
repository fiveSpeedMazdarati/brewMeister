<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- required bootstrap meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- bootstrap v4 css -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Log In To Use Brewmeister</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col col-lg-2">
        </div>
        <div class="col col-md-auto">
                <form action="j_security_check" method="POST">
                    <label>Username:</label><input type="text" name="j_username">
                    <label>Password:</label><input type="password" name="j_password">
                    <input type="submit" value="Log In">
                </form>
        </div>
        <div class="col col-lg-2">
        </div>
    </div>
</div>

<!-- bootstrap javascript (may remove if not necessary) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
