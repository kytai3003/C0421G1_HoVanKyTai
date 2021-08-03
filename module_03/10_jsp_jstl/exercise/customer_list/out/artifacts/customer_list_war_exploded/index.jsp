<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-03
  Time: 3:39 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Customer List</title>
    <style>
      body {
        text-align: center;
      }

      .img {
        height: 100px;
        width: 100px;
      }

      table {
        margin: 0 auto;
      }

    </style>
  </head>
  <body>
    <h1>Customer List</h1>
    <table border="1">
      <tr>
        <th>No</th>
        <th>Full name</th>
        <th>Day of birth</th>
        <th>Address</th>
        <th>Avatar</th>
      </tr>
      <c:forEach var="customerObj" items="${customerListServlet}" varStatus="loop">
        <tr>
          <td><c:out value="${loop.count}"/></td>
          <td><c:out value="${customerObj.name}"/></td>
          <td><c:out value="${customerObj.dayOfBirth}"/></td>
          <td><c:out value="${customerObj.address}"/></td>
          <td><img class="img" src="${customerObj.photoUrl}"/></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
