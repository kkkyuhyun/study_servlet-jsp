<%--
  Created by IntelliJ IDEA.
  User: sam99
  Date: 2024-07-29
  Time: 오전 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page import ="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="ko">
<head>
    <meta http-equiv="COntent-Type" content="text/html"; charset="UTF-8">
    <title>스크립트 실습</title>
</head>
<body>
    <h1> 현재 날짜 출력 실습</h1>
    <%
        Date d = new Date();
        int sum = 0;
        for(int i=0; i<10; i++){
            sum+=i;
        }
        Date d2 = null;
    %>
    현재 날짜: <%= d %><br>
    1~10의 합: <%= sum %><br>

    <% if(d2!=null){ %>
    <%= d2%>
<%} %>
</body>
</html>
