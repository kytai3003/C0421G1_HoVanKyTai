<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-02
  Time: 5:10 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/display-discount" method="post" style="background-color: bisque; text-align: center">
    <p>Product description: </p>
    <input type="text" name="description">
    <p>List price: </p>
    <input type="text" name="price">
    <p>Discount percent:</p>
    <input type="text" name="discount"><br><br>
    <input type="submit" value="Calculate Discount" style="color: blue">
  </form>
  </body>
</html>
