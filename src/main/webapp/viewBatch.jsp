<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="bootstrap-header.jsp"%>
    <link rel="stylesheet" href="brewmeister.css" type="text/css">
    <title>View a Batch</title>
</head>
<body>
<div class="container">
  <%@include file="topnav.jsp"%>
  <div class="row ">
    <div class="panel panel-default">
      <div class = "panel-header">ID: ${batch.id}</div>
      <div class="panel-body">
             <span class="h3">Title: ${batch.title}</span>
              Brew Date: ${batch.brewDate}<br />
              ABV: ${batch.ABV}%<br />
        <a href="editBatch?id=${batch.id}" class="btn btn-default">Edit this batch</a>
          <div><p>${weather}</p></div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
