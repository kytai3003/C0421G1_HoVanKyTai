<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-06
  Time: 11:33 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            text-align: center;
            font-size: 25px;
        }
    </style>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/users">Back to user list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>User information</legend>
        <table border="1" style="margin: 0 auto">
            <tr>
                <td>Id: </td>
                <td>${requestScope["user"].getId()}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${requestScope["user"].getName()}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${requestScope["user"].getEmail()}</td>
            </tr>
            <tr>
                <td>Country: </td>
                <td>${requestScope["user"].getCountry()}</td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center"><input style="width: 150px; height: 30px" type="submit" value="Delete user?"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>