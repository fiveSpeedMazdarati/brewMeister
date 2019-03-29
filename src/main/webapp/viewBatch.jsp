<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/29/19
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>View a Batch</title>
</head>
<body>
<p>
    ID: ${batch.id}<br />
    Title: ${batch.title}<br />
    Brew Date: ${batch.brewDate}<br />
    ABV: ${batch.ABV}%
</p>


</body>
</html>
