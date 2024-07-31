<%--
  Created by IntelliJ IDEA.
  User: sam99
  Date: 2024-07-30
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>상품 리스트</h1>
    <form action="cart_save" method="GET">
        <input type="radio" name="product" value="BMW">BMW<br>
        <input type="radio" name="product" value="SM5">SM5<br>
        <input type="radio" name="product" value="K7">K7<br>
        <input type="submit" value="카트저장">
    </form>
</body>
</html>
