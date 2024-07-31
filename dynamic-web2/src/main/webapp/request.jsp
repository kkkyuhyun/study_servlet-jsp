<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 폼</title>
</head>
<body>
<h1>로그인 입력 화면</h1>
<form action="loginInfo.jsp" method="get">
    <fieldset>
        <legend>로그인 폼</legend>
        <ul>
            <li>
                <label for="userid">아이디</label>
                <input type="text" id="userid" name="userid">
            </li>
            <li>
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password">
            </li>
            <li>
                <label for="age">나이</label>
                <input type="number" id="age" name="age">
            </li>
            <li><input type="submit" value="전송"></li>
        </ul>
    </fieldset>
</form>
</body>
</html>
