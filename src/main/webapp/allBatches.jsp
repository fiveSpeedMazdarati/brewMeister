<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="bootstrap-header.jsp"%>
    <title>Your Batches | Brewmeister</title>
</head>
<body>
    <div class="container">
        <%@include file="topnav.jsp"%>
        <c:if test="${batchUpdated==true}">
          <div class="alert alert-success" role="alert">${updatedBatchTitle} (Batch #${updatedBatchId}) updated successfully.</div>
        </c:if>
        <div class="row">
            <c:forEach var="batch" items="${batches}">
                <div class="panel panel-default col-xs-12 col-sm-6 col-md-4 col-lg-3">
                    <div class="panel-heading"><a href="getBatch?id=${batch.id}"><span class="h3">${batch.title}</span></a><span class="pull-right">${batch.ABV}% ABV</span></div>
                    <div class="panel-body"><p class="margin-bottom-lg">${batch.style.name}</p>
                        <a href="deleteBatch?id=${batch.id}" class="btn btn-danger">Delete</a>
                        <a href="archiveBatch?id=${batch.id}" class="btn btn-warning margin-left-xl">Archive</a>
                        <a href="editBatch?id=${batch.id}" class="btn btn-info pull-right">Edit</a>

                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
