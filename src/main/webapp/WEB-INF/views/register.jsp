<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>가맹점 회원가입</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/login.css">
</head>
<body>

<div class="top-bar">
    <img src="<%= request.getContextPath() %>/img/logo.png" alt="로고" class="logo">
    <span>ChillKin</span>
</div>

<div class="login-wrapper">
    <h2>가맹점 회원가입</h2>
    <form action="<%= request.getContextPath() %>/signup" method="post">
        <label for="pw">비밀번호</label>
        <input type="text" name="pw" id="pw" required placeholder="비밀번호를 입력하세요">

        <label for="address">주소</label>
        <input type="text" name="address" id="address" required placeholder="주소를 입력하세요">

        <label for="tel">전화번호</label>
        <input type="text" name="tel" id="tel" required placeholder="010-XXXX-YYYY">

        <div class="button-group">
            <input type="submit" value="회원가입">
        </div>
    </form>
</div>

</body>
</html>
