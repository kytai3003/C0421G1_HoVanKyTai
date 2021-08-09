<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-05
  Time: 8:56 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<center>
    <h1>User Management</h1>
    <div>
        <form method="post" action="/users?action=search">
            <input type="text" name="country" placeholder="Country name">
            <input type="submit" value="Search by country">
        </form>
    </div>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
    <h2>
        <a href="/users?action=sort">Sorting by name</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <h2>List of Users</h2>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="#" onclick="onDelete(${user.id})" class="btn btn-danger" data-toggle="modal" data-target="#modelId">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Confirm delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/users">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="" id="idUserDel">
                <div class="modal-body">
                    Ban co muon xoa user name?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">OK</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/jquery/popper.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script>
    function onDelete(id) {
        document.getElementById("idUserDel").value = id;
    }
</script>
</body>
</html>