<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="bootstrap-header.jsp"%>
    <link rel="stylesheet" href="brewmeister.css" type="text/css" />
    <title>Your Batches | Brewmeister</title>
</head>
<body>
    <div class="container">
        <%@include file="topnav.jsp"%>

        <!-- display the following alert banner if a batch has been updated -->
        <c:if test="${batchUpdated==true}">
          <div class="alert alert-success alert-dismissable fade in" role="alert">${updatedBatchTitle} (Batch #${updatedBatchId}) updated successfully.
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></div>
        </c:if>

        <!-- display the following alert banner if a new batch has been created -->
        <c:if test="${newBatchAdded==true}">
            <div class="alert alert-success alert-dismissable fade in" role="alert">${newBatchName} (Batch #${newBatchId}) created successfully.
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></div>
        </c:if>
        <div class="row">

            <!-- display this message if there are currently no batches for the user -->
            <c:if test="${batches.isEmpty()}">
                <p class="text-center">No beer yet? Why not <a href="showCreateNewBatch">create a new batch?</a></p>
            </c:if>

            <!-- display all of the batches retrieved from the database. Nothing displays if the list is empty -->
            <c:forEach var="batch" items="${batches}">
                <div class="panel panel-default col-xs-12 col-sm-6 col-md-4">
                    <div class="panel-heading no-padding"><a href="getBatch?id=${batch.id}"><span class="h3">${batch.title}</span></a><span class="pull-right clear">${batch.ABV}% ABV</span></div>
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
