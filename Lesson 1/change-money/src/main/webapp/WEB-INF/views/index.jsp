<%--
  Created by IntelliJ IDEA.
  User: dat01
  Date: 10/11/2021
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
        #form-calculator {
          position: relative;
          margin-top:  10%;
          margin-left: 35%;
          align-self: center;
          width: 30%;
          height: 15%;
          border: 1px solid black;
          text-align: center;
        }
    </style>
  </head>
  <body>
  <div id="form-calculator">
    <form action="change" method="post">
      <p><label>USD</label>
        <input type="number" name= "usd" value="${USD}" step="0.01">
      </p>
      <p>${VND} VND</p>
      <button type="submit">Change</button>
    </form>
  </div>
  </body>
</html>
