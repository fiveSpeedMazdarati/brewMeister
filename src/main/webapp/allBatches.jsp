<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Batches</title>
    <%@ include file="bootstrap-header.jsp"%>
</head>
<body>
<div class="container-fluid">
    <div>All of your batches!</div>
    <div>
    <c:forEach var="batch" items="${batches}">
        <div>
            <a href="/getBatch?id=${batch.id}">${batch.title}</a><br />
            ${batch.style.description} ABV: ${batch.ABV}%<br />
        </div>
    </c:forEach>
    </div>
</div>
</body>
</html>
