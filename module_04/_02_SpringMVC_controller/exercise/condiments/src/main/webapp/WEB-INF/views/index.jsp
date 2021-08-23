<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-23
  Time: 8:31 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>List of condiments</h2>
  <form method="post" action="/save">
    <input type="checkbox" id="lecture" name="condiment" value="Letture">
    <label for="lecture"> Letture</label><br>
    <input type="checkbox" id="tomato" name="condiment" value="Tomato">
    <label for="tomato"> Tomato</label><br>
    <input type="checkbox" id="mustard" name="condiment" value="Mustard">
    <label for="mustard"> Mustard</label><br>
    <input type="checkbox" id="sprouts" name="condiment" value="Sprouts">
    <label for="sprouts"> Sprouts</label><br>
    <input type="submit" value="Submit">
  </form>
  </body>
</html>
