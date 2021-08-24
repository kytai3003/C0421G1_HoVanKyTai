<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-25
  Time: 1:16 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Detail</h2>
<p>Name: ${personalInformation.name}</p>
<p>Year of birth: ${personalInformation.birthYear}</p>
<p>Gender: ${personalInformation.gender}</p>
<p>Nationality: ${personalInformation.nationality}</p>
<p>Id card: ${personalInformation.idCard}</p>
<p>Transport information: ${personalInformation.transportVehicle}</p>
<p>Start date: ${personalInformation.dayStart}</p>
<p>End date: ${personalInformation.dayEnd}</p>
<p>Visited places: ${personalInformation.history}</p>
<p>Phone number: ${personalInformation.phone}</p>
<p>Email: ${personalInformation.email}</p>
<button type="button" value="Edit"><a href="/form">Edit</a> </button>
</body>
</html>
