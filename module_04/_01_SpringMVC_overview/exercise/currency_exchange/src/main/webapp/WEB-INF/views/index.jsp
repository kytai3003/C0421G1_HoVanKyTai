<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-21
  Time: 9:21 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
<form method="get" action="/calculate" style="text-align: center">
  <h1>Money exchange</h1>
  <h2> Input rate: </h2>
  <input type="number" name="rate">
  <h2> Input amount: </h2>
  <input type="number" name="amount"><br>
  <input type="submit" value="Calculate">
</form>
</body>
</html>
