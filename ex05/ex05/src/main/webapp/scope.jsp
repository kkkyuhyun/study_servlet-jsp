<%--
  Created by IntelliJ IDEA.
  User: sam99
  Date: 2024-07-30
  Time: 오후 3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope 데이터보기</h1>

pageScope 속성값: ${pageScope.scopeName}<br>
requestScope 속성값: ${requestScope.scopeName}<br>
sessionScope 속성값: ${sessionScope.scopeName}<br>
applicationScope 속성값: ${applicationScope.scopeName}<br>

scopeName 자동 찾기: ${scopeName}<br>
member: ${member.name}(${member.userid})<br>
<%-- 객체의 주의점 필드로 접근 안했다 Getter와 Setter, 실제 호출되는 것은 java에서
 member.getName()된 것과 유사하다 JSP 멤버에 접근한 것처럼 보일 뿐! /scope.jsp--%>
</body>
</html>
