<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-06
  Time: 4:47 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            text-align: center;
        }
    </style>
</head>
<body>
<h3>
    <a href="/products?action=">Back to product list</a>
</h3>
<table border="1" style="margin: 0 auto">
    <p>
        <c:if test='${requestScope["msg"] != null}'>
            <span class="message" style="color: green">${requestScope["msg"]}</span>
        </c:if>
    </p>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Producer</th>
    </tr>
    <c:forEach items='${requestScope["listProduct"]}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProductBrand()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
