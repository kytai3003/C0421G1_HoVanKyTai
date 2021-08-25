<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-23
  Time: 10:12 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Calculator</h2>
  <form action="/calculate" method="post">
  <input type="number" name="numb1" value="${numb1}">
  <input type="number" name="numb2" value="${numb2}">
    <br>
  <button type="submit" name="operator" value="+">Addition(+)</button>
  <button type="submit" name="operator" value="-">Subtraction(-)</button>
  <button type="submit" name="operator" value="*">Multiplication(*)</button>
  <button type="submit" name="operator" value="/">Division(/)</button>
  </form>

  <h4 style="color: red">
    <c:if test='${requestScope["result"] == null}'>
      <span>Warning: ${requestScope["mess"]}</span>
    </c:if>
  </h4>

  <h4>Result: ${result}</h4>
  </body>
</html>
