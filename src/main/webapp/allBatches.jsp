<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="bootstrap-header.jsp"%>
    <title>Your Batches | Brewmeister</title>
</head>
<body>
<div class="container-fluid">

    <c:forEach var="batch" items="${batches}">
        <div class="panel panel-default col-lg-6">
            <div class="panel-heading"><a href="/getBatch?id=${batch.id}">${batch.title}</a><span class="pull-right">${batch.ABV}%</span></div>
            <div class="panel-body">${batch.style.name}</div>
        </div>
        <div class="panel panel-default col-lg-6">
          <div class="panel-body">This is some more content used as a placeholder.</div>
        </div>
    </c:forEach>
</div>
</body>
</html>
