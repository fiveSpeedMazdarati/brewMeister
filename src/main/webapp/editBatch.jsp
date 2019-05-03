<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="bootstrap-header.jsp"%>
    <title>Edit A Batch | Brewmeister</title>
</head>
<body>
<div class="container">
    <div class="row ">
        <div class="panel panel-default">
            <div class = "panel-header">ID: ${batch.id}</div>
            <div class="panel-body">
                <form>
                    <label>Title:</label><input type="text" value="${batch.title}" name="title"><br />
                    <label>Brew Date:</label><input type="date" value="${batch.brewDate}" name="brewDate"><br />
                    <label>ABV:</label><input type="text" disabled="true" value="${batch.ABV}%"><br /><br />
                    <input type="submit" formaction="/updateBatch" formmethod="POST">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
