<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
    <style>
        body {
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <h2>Medican Form</h2>
</div>

<form:form action="/form" method="post" modelAttribute="personalInformation">
    <table style="margin: 0 auto; border: 5px">
        <tr>
            <td>Name(*): </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>Year of birth(*): </td>
            <td>
                <form:input path="birthYear"/>
            </td>
        </tr>
        <tr>
            <td>Gender(*): </td>
            <td><form:select path="gender">
                <c:forEach var="g" items="${genderList}">
                    <form:option value="${g}"/>
                </c:forEach>
            </form:select>
            </td>
        </tr>
        <tr>
            <td>Nationality: </td>
            <td><form:select path="nationality">
                <c:forEach var="n" items="${nationList}">
                    <form:option value="${n}"/>
                </c:forEach>
            </form:select>
            </td>
        </tr>
        <tr>
            <td>Id card(*): </td>
            <td>
                <form:input path="idCard"/>
            </td>
        </tr>
        <tr>
            <td>Transport information(*): </td>
            <td>
                <form:radiobutton path="transportVehicle" value="Airplane" label="Airplane"/>
                <form:radiobutton path="transportVehicle" value="Ship" label="Ship"/>
                <form:radiobutton path="transportVehicle" value="Car" label="Car"/>
                <form:radiobutton path="transportVehicle" value="Other" label="Other"/>
            </td>
        </tr>
        <tr>
            <td>Start date(*): </td>
            <td>
                <form:input path="dayStart"/>
            </td>
        </tr>
        <tr>
            <td>End date(*): </td>
            <td>
                <form:input path="dayEnd"/>
            </td>
        </tr>
        <tr>
            <td>Visited places:(*): </td>
            <td>
                <form:input path="history"/>
            </td>
        </tr>
        <tr>
            <td>Address:(*): </td>
            <td>
                <form:input path="address"/>
            </td>
        </tr>
        <tr>
            <td>Phone number:(*): </td>
            <td>
                <form:input path="phone"/>
            </td>
        </tr>
        <tr>
            <td>Email:(*): </td>
            <td>
                <form:input path="email"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit" value="Create">Create</button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
