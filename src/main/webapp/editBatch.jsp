<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="bootstrap-header.jsp"%>
    <title>Edit A Batch | Brewmeister</title>
    <script src="https://cloud.tinymce.com/5/tinymce.min.js?apiKey=pxx223jnojpv1eswnsldybzgdsk1xk3pbq3halc5d2hqm5d9"></script>
    <script>tinymce.init({selector:"#tinymce"});</script>
</head>
<body>
<div class="container">
    <%@include file="topnav.jsp"%>
        <div class="row ">
            <form>
                <div class="col-xs-12 col-md-6">
                  <input type="hidden" value="${batch.id}" name="id">
                  <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" id="title" value="${batch.title}" name="title"><br />
                  </div>
                  <div class="form-group">
                    <label for="initial-specific-gravity">Initial Specific Gravity</label>
                    <input type="text" id="initial-specific-gravity" value="${batch.title}" name="title"><br />
                  </div>
                  <div class="form-group">
                    <label for="final-specific-gravity">Final Specific Gravity</label>
                    <input type="text" id="final-specific-gravity" value="${batch.title}" name="title"><br />
                  </div>
                  <div class="form-group">
                    <label for="abv">ABV</label>
                    <div class="input-group">
                      <input type="text" class="form-control" id="abv" aria-label="Percent alcohol by volume" value="${batch.ABV}">
                      <span class="input-group-addon">%</span>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="tinymce">Notes</label>
                    <textarea class="form-control" id="tinymce" name="tinymce">${batch.notes}</textarea>
                  </div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <div class="form-group">
                        <label for="brew-date">Brew Date</label><input type="date" id="brew-date" value="${batch.brewDate}" name="brew-date"><br />
                    </div>
                    <div class="form-group">
                        <label for="bottle-date">Bottle Date</label><input type="date" id="bottle-date" value="${batch.bottleDate}" name="bottle-date"><br />
                    </div>
                    <div class="form-group">
                        <label for="ready-date">Ready Date</label><input type="date" id="ready-date" value="${batch.readyDate}" name="ready-date"><br />
                    </div>
                    <div class="form-group">
                        <label for="expiration-date">Expiration Date</label><input type="date" id="expiration-date" value="${batch.expirationDate}" name="expiration-date"><br />
                    </div>
                </div>
                <!-- submit button outside of flexible rows so it's always at the bottom left -->
                <input type="submit" formaction="updateBatch" formmethod="POST" value="Save Changes">
            </form>
        </div> <!-- end row -->
    </div><!-- end container -->
</body>
</html>
