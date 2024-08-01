<%--
  Created by IntelliJ IDEA.
  User: sam99
  Date: 2024-07-30
  Time: 오후 4:00
  To change this template use File | Settings | File Templates.
--%>
<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSTL 테스트</h1>
<hr>
<c:if test="${empty user}">
    <a href="/login_form.jsp">로그인</a> | <a href="#">회원가입</a>
</c:if>
<c:if test="${not empty user}">
    ${user.name} | <a href="/logout">로그아웃</a>
</c:if>

<br>

<c:if test="${role == 'ADMIN'}">관리자</c:if>
<c:if test="${role != 'ADMIN'}">일반회원</c:if>

<table>
    <c:forEach var="member" items="${members}" varStatus="state">
        <tr>
            <td>${state.index}</td>
            <td>${member.name}</td>
            <td>${member.userid}</td>
        </tr>
    </c:forEach>
</table>
<br>

${today}<br>
<fmt:formatDate value="${today}" type="date"/><br>
<fmt:formatDate value="${today}" type="time"/><br>
<fmt:formatDate value="${today}" type="both"/><br>
<fmt:formatDate value="${today}" dateStyle="short" timeStyle="long"/><br>
<fmt:formatDate value="${today}" dateStyle="long" timeStyle="short"/><br>
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss"/><br>
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd a hh:mm:ss"/><br>
</body>
</html>
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSTL 테스트</h1>
<%@ include file="navbar.jsp" %>
<%--표준 action 태그로도 가능
<jsp:include page="navbar.jsp"/>
--%>

<c:if test="${role == 'ADMIN'}">관리자</c:if>
<c:if test="${role != 'ADMIN'}">일반회원</c:if>

<table>
    <c:forEach var="member" items="${members}" varStatus="state">
        <tr>
            <td>${state.index}</td>
            <td>${member.name}</td>
            <td>${member.userid}</td>
        </tr>
    </c:forEach>
</table>

<br>
${today}<br>
<fmt:formatDate value="${today}" type="date"/><br>
<fmt:formatDate value="${today}" type="time"/><br>
<fmt:formatDate value="${today}" type="both"/><br>
<fmt:formatDate value="${today}" dateStyle="short" timeStyle="long"/><br>
<fmt:formatDate value="${today}" dateStyle="long" timeStyle="short"/><br>
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss"/><br>
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd a hh:mm:ss"/><br>

</body>
</html>