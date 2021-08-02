<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-02
  Time: 6:01 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<div style="text-align: center">
<h3>
    Discount Amount: <%=request.getAttribute("discountServlet")%>
</h3>
<h3>
    Discount Price: <%=request.getAttribute("priceServlet")%>
</h3>
<h3>
    Description: <%=request.getAttribute("desServlet")%>
</h3>
</div>
</body>
</html>
