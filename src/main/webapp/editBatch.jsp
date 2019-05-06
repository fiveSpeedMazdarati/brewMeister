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
        <div class="panel panel-default col-xs-12 col-md-6">
            <div class = "panel-header">ID: ${batch.id}</div>
            <div class="panel-body">
                <form>
                    <input type="hidden" value="${batch.id}" name="id">
                    <div class="input-group">
                      <label>Title:</label><input type="text" value="${batch.title}" name="title"><br />
                    </div>
                    <div class="input-group">
                      <label>Brew Date:</label><input type="date" value="${batch.brewDate}" name="brewDate"><br />
                    </div>
                    <div class="input-group">
                      <label>ABV:</label><input class="disabled" type="text" value="${batch.ABV}%"><span class="input-group-addon">%</span>
                    </div>
                    <input type="submit" formaction="updateBatch" formmethod="POST">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
