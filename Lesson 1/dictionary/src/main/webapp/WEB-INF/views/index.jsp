
<%--
  Created by IntelliJ IDEA.
  User: dat01
  Date: 10/11/2021
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
  <form action="dictionary" method="post">
    <p>
      <lable>English</lable>
      <input type="text" name="input" value="${input}">
    </p>
    <p><c:out value="${result}"></c:out></p>
    <button>Search</button>
  </form>
  </body>
</html>
