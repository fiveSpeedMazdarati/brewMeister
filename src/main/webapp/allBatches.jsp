<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="bootstrap-header.jsp"%>
    <title>Your Batches | Brewmeister</title>
</head>
<body>
    <div class="container">
        <div class="alert alert-success" role="alert">${}</div>
        <div class="row">
            <c:forEach var="batch" items="${batches}">
                <div class="panel panel-default col-xs-12 col-md-4 col-lg-3">
                    <div class="panel-heading"><a href="getBatch?id=${batch.id}">${batch.title}</a><span class="pull-right">${batch.ABV}%</span></div>
                    <div class="panel-body">${batch.style.name}<br />
                        <a href="deleteBatch?id=${batch.id}" class="btn btn-danger pull-left">Delete</a>
                        <a href="editBatch?id=${batch.id}" class="btn btn-info pull-right">Edit</a>
                        <a href="archiveBatch?id=${batch.id}" class="btn btn-warning pull-right">Archive</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
