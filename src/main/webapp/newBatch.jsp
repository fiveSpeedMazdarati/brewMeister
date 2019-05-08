<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="bootstrap-header.jsp"%>
    <title>New Batch | Brewmeister</title>
    <script src="https://cloud.tinymce.com/5/tinymce.min.js?apiKey=pxx223jnojpv1eswnsldybzgdsk1xk3pbq3halc5d2hqm5d9"></script>
    <script>tinymce.init({selector:"#tinymce"});</script>
</head>
<body>
<div class="container">
  <div class="row">
    <form>
      <div class="col-md-6 col-xs-12">
        <div class="form-group">
          <label for="title">Title</label>
          <input type="text" class="form-control" id="title" name="title" placeholder="Batch Name">
        </div>
        <div class="form-group">
          <label for="style">Style</label>
          <select class="form-control" id="style" name="style">
            <!-- all of the descriptions from the Style table go here as options -->
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
          <input type="date" class="form-control" id="brew-date" name="brew-date" placeholder="Batch Name">
        </div>
        <div class="form-group">
          <label for="bottle-date">Projected Bottle Date</label>
          <input type="date" class="form-control" id="bottle-date" name="bottle-date" placeholder="Batch Name">
        </div>
      </div>
      <input type="submit" class="btn btn-submit" formaction="createNewBatch" formmethod="POST" formenctype="application/x-www-form-urlencoded">
    </form>
  </div>
</div>
</body>
</html>
