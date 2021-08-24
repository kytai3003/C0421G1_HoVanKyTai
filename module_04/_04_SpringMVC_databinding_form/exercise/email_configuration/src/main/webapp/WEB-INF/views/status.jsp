<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h1>Status</h1>
<p>${message}</p>
<h5>Language: ${setting.language}</h5>
<h5>Page size: ${setting.pageSize}</h5>
<h5>Spams filter:
    <c:choose>
        <c:when test="${setting.spamFilter == false}">No</c:when>
        <c:otherwise>Yes</c:otherwise>
    </c:choose>
</h5>
<h5>Signature: ${setting.signature}</h5>
<a href="/edit">Update</a>
</body>
</html>
