<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>가맹점 로그인</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/login.css">
</head>
<body>

<div class="top-bar">
    <img src="<%= request.getContextPath() %>/img/logo.png" alt="로고" class="logo">
    <span>ChillKin</span>
</div>

<div class="login-wrapper">
    <h2>가맹점 로그인</h2>
    <form action="<%= request.getContextPath() %>/login" method="post">
        <label for="branch_id">가맹점 코드</label>
        <input type="text" name="branch_id" id="branch_id" required>
        <div class="info">가맹점 코드는 숫자(매장번호) 및 4자리입니다.</div>

        <label for="pw">비밀번호</label>
        <input type="password" name="pw" id="pw" required>

        <div class="button-group">
            <input type="submit" value="로그인">
            <a href="<%= request.getContextPath() %>/signup" class="signup-button">회원가입</a>
        </div>
    </form>
    <div class="back-to-menu">
    	<a href="<%= request.getContextPath() %>/MenuList" class="back-btn">메뉴 리스트로 돌아가기</a>
	</div>
    
</div>

</body>
</html>
