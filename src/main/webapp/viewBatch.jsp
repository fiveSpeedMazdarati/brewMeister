<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="bootstrap-header.jsp"%>
    <title>View a Batch</title>
</head>
<body>
<p>
  <div class="panel panel-default">
    <div class = "panel panel-header">ID: ${batch.id}</div>
    Title: <h3>${batch.title}</h3>
    Brew Date: ${batch.brewDate}<br />
    ABV: ${batch.ABV}%
  </div>
</p>
</body>
</html>
