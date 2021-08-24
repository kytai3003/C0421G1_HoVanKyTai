<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-24
  Time: 11:04 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h2>Edit</h2>
<form:form action="/edit" method="post" modelAttribute="setting">
    <table>
        <tr>
            <td>Language: </td>
            <td>
                <form:select path="language">
                <c:forEach var="l" items="${languages}">
                <form:option value="${l}"/>
                </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page size: </td>
            <td><form:select path="pageSize">
                <c:forEach var="p" items="${pageSize}">
                    <form:option value="${p}"/>
                </c:forEach>
            </form:select>
            </td>
        </tr>
        <tr>
            <td>Spam filters: </td>
            <td>
                <form:checkbox path="spamFilter" value="${setting.spamFilter}"/>
            </td>
        </tr>
        <tr>
            <td>Signature: </td>
            <td>
                <form:input path="signature" value="${setting.signature}"/>
            </td>
        </tr>
        <tr>
            <td><button type="submit" value="Update">Update</button></td>
            <td><button type="button" value="Cancel"><a href="/status" style="text-decoration: none">Cancel</a> </button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
