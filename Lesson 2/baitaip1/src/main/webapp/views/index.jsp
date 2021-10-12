
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/save" method="get">
    <h1>Sandwich Condiments</h1>
    <input type="checkbox" name="condiment" value="tuong ot">Tương ớt
    <input type="checkbox" name="condiment" value="tuong ca">Tương cà
    <input type="checkbox" name="condiment" value="mu tat">Mù tạt
    <input type="checkbox" name="condiment" value="mayone">Mayone
    <input type="checkbox" name="condiment" value="nuoc mam">Nước mắm
    <button type="submit">Save</button>
  </form>
   <h3>${spices}</h3>
  </body>
</html>
