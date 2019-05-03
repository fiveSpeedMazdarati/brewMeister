<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="bootstrap-header.jsp"%>
    <title>View a Batch</title>
</head>
<body>
<div class="container">
  <div class="row ">
    <div class="panel panel-default">
      <div class = "panel-header">ID: ${batch.id}</div>
      <div class="panel-body">
             <span class="h3">Title: ${batch.title}</span>
              Brew Date: ${batch.brewDate}<br />
              ABV: ${batch.ABV}%<br />
        <a href="editBatch?id=${batch.id}" class="btn btn-default">Edit this batch</a>
      </div>
    </div>
  </div>
</div>
</body>
</html>
