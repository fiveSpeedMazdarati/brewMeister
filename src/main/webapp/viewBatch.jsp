<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="bootstrap-header.jsp"%>
    <link rel="stylesheet" href="brewmeister.css" type="text/css" />
    <title>Viewing Batch #${batch.id} | Brewmeister</title>
    <script src="https://cloud.tinymce.com/5/tinymce.min.js?apiKey=pxx223jnojpv1eswnsldybzgdsk1xk3pbq3halc5d2hqm5d9"></script>
    <script>tinymce.init({selector:"#tinymce"});</script>
</head>
<body>
<div class="container">
  <%@include file="topnav.jsp"%>
  <div class="row ">
    <div class="panel panel-default">
      <div class = "panel-heading"><span>ID: ${batch.id}</span><span class="pull-right">ABV: ${batch.ABV}%</span><span class="h3 center-block">${batch.title}</span></div>
        <div class="panel-body">
            <fieldset disabled>
            <div class="col-xs-12 col-md-6">
            <input class="form-control" type="hidden" value="${batch.id}" name="id">
              <div class="form-group">
                <label for="title">Title</label>
                <input class="form-control" type="text" id="title" value="${batch.title}" name="title"><br />
              </div>
              <div class="form-group">
                <label for="initial-specific-gravity">Initial Specific Gravity</label>
                <input class="form-control" type="text" id="initial-specific-gravity" value="${batch.initialSpecificGravity}" name="title"><br />
              </div>
              <div class="form-group">
                <label for="final-specific-gravity">Final Specific Gravity</label>
                <input class="form-control" type="text" id="final-specific-gravity" value="${batch.finalSpecificGravity}" name="title"><br />
              </div>
              <div class="form-group">
                <label for="abv">ABV</label>
                <div class="input-group">
                  <input class="form-control" type="text" class="form-control" id="abv" aria-label="Percent alcohol by volume" value="${batch.ABV}">
                  <span class="input-group-addon">%</span>
                  </div>
              </div>
              <div class="form-group">
                <label for="tinymce">Notes</label>
                <textarea class="form-control" id="tinymce" name="tinymce" disabled>${batch.notes}</textarea>
              </div>

          </div>
          <div class="col-xs-12 col-md-6">
              <div class="form-group">
                  <label for="brew-date">Brew Date</label>
                  <input class="form-control" type="date" id="brew-date" value="${batch.brewDate}" name="brew-date"><br />
              </div>
              <div class="form-group">
                  <label for="bottle-date">Bottle Date</label>
                  <input class="form-control" type="date" id="bottle-date" value="${batch.bottleDate}" name="bottle-date"><br />
              </div>
              <div class="form-group">
                  <label for="ready-date">Ready Date</label>
                  <input class="form-control" type="date" id="ready-date" value="${batch.readyDate}" name="ready-date"><br />
              </div>
              <div class="form-group">
                  <label for="expiration-date">Expiration Date</label>
                  <input class="form-control" type="date" id="expiration-date" value="${batch.expirationDate}" name="expiration-date"><br />
              </div>
              <div class="weather-container">
                  <div class="weather-report">${weather}</div>
                  <div class="weather-report">${weather}</div>
              </div>

          </div>
          </fieldset>
          <div class="col-xs-12">
              <a href="editBatch?id=${batch.id}" class="btn btn-default top-margin">Edit this batch</a>
          </div>
    </div>
  </div>
</div>
</body>
</html>
