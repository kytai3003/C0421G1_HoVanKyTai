<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-03
  Time: 5:04 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Result:<%=request.getAttribute("first-operand")%> <%=request.getAttribute("operator")%>
    <%=request.getAttribute("second-operand")%> = <%=request.getAttribute("resultServlet")%></h3>
</body>
</html>
