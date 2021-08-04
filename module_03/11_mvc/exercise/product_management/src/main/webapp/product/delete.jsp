<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-04
  Time: 10:05 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting product</title>
    <style>
        body {
            text-align: center;
            font-size: 25px;
        }

        table {
            margin: 0 auto;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table border="1">
            <tr>
                <td>Id: </td>
                <td>${requestScope["product"].getId()}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Product description: </td>
                <td>${requestScope["product"].getDescription()}</td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td>${requestScope["product"].getProductBrand()}</td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center"><input style="width: 150px; height: 30px" type="submit" value="Delete product?"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
