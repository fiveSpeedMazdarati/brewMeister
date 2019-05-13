<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="bootstrap-header.jsp"%>
  <link rel="stylesheet" href="brewmeister.css" type="text/css" />
    <title>New Batch | Brewmeister</title>
    <script src="https://cloud.tinymce.com/5/tinymce.min.js?apiKey=pxx223jnojpv1eswnsldybzgdsk1xk3pbq3halc5d2hqm5d9"></script>
    <script>tinymce.init({selector:"#tinymce"});</script>
</head>
<body>
<div class="container">
  <%@include file="topnav.jsp"%>
  <div class="row">
    <form>
      <div class="col-md-6 col-xs-12">
        <div class="form-group">
          <label for="title">Title</label>
          <input type="text" class="form-control" id="title" name="title" placeholder="Batch Name" required>
        </div>
        <div class="form-group">
          <label for="style">Style</label>
          <select class="form-control" id="style" name="style">
            <!-- all of the descriptions from the Style table go here as options -->
            <option>Light Lager</option>
            <option>Porter</option>
            <option>Stout</option>
            <option>American Pale Ale</option>
            <option>American IPA</option>
            <option>English Bitter</option>
          </select>
        </div>
        <div class="form-group">
          <label for="title">Initial Specific Gravity</label>
          <input type="text" class="form-control" name="initial-specific-gravity" placeholder="Batch Name">
        </div>
        <div class="form-group">
          <label for="tinymce">Notes</label>
          <textarea class="form-control" id="tinymce" name="tinymce"></textarea>
        </div>
      </div>
      <div class="col-md-6 col-xs-12">
        <div class="form-group">
          <label for="brew-date">Brew Date</label>
          <input type="date" class="form-control" id="brew-date" name="brew-date" placeholder="Batch Name" required>
        </div>
        <div class="form-group">
          <label for="bottle-date">Projected Bottle Date</label>
          <input type="date" class="form-control" id="bottle-date" name="bottle-date" placeholder="Batch Name" required>
        </div>
      </div>
    <div class="col-xs-12">
      <div class="btn-group">
        <input class="btn btn-primary" type="submit" value="Create Batch" class="btn btn-submit" formaction="createNewBatch" formmethod="POST" formenctype="application/x-www-form-urlencoded">
        <a class="btn btn-outline btn-warning" href="getAllBatchesForUser">Cancel</a>
      </div>
    </div>
    </form>
  </div>
</div>
</body>
</html>
