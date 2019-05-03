<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="bootstrap-header.jsp"%>
    <title>View a Batch</title>
</head>
<body>
  <div class="panel panel-default">
    <div class = "panel-header">ID: ${batch.id}</div>
    <div class="panel-body">
        Title: <h3>${batch.title}</h3>
        Brew Date: ${batch.brewDate}<br />
        ABV: ${batch.ABV}%
    </div>
  </div>
</body>
</html>
