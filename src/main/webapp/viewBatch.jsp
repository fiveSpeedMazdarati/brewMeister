<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="bootstrap-header.jsp"%>
    <title>View a Batch</title>
</head>
<body>
<p>
    ID: ${batch.id}<br />
    Title: ${batch.title}<br />
    Brew Date: ${batch.brewDate}<br />
    ABV: ${batch.ABV}%
</p>
</body>
</html>
