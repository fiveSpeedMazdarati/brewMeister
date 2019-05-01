<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Batches</title>
    <%@ include file="bootstrap-header.jsp"%>
</head>
<body>
<div>All of your batches!</div>
<c:forEach items="batches">
    <div>
        ${}
    </div>
</c:forEach>
</body>
</html>
