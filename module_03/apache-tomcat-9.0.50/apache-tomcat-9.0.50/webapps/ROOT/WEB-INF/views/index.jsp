<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-21
  Time: 11:37 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Dictionary</title>
  <style>
    * {
      text-align: center;
    }
  </style>
</head>
<body>
<form action="/search">
  <h1>Dictionary</h1>
  <h3>Input word: </h3>
  <input type="text" name="wordSearch">
  <input type="submit" value="Search">

</form>
  <h3>Vietnamese: ${wordResult}</h3>
</body>
</html>
