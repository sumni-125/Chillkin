<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>리뷰 작성 완료</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/reviewComplete.css">
</head>
<body>

<div class="top-bar">
    <div class="left">
        <a href="<%= request.getContextPath() %>/logout">가맹점 로그아웃</a>
    </div>
    <div class="center">
        <img src="<%= request.getContextPath() %>/img/logo.png" class="logo">
        <span>ChillKin</span>
    </div>
    <div class="right">
        <%
            String branchName = (String) session.getAttribute("branch_name");
            if (branchName == null) branchName = "지점명 없음";
        %>
        <%= branchName %>
    </div>
</div>

<div class="complete-container">
    <h2>건의가 성공적으로 등록되었습니다!</h2>
    <p>감사합니다. 빠르게 확인하도록 하겠습니다 😊 -본사</p>

    <div class="btn-area">
        <a href="<%= request.getContextPath() %>/Review_Write" class="btn">다른 건의 작성하기</a>
        <a href="<%= request.getContextPath() %>/printReview" class="btn">목록으로</a>
        <a href="<%= request.getContextPath() %>/b_main" class="btn">가맹점 페이지로</a>
    </div>
</div>
<script src="<%= request.getContextPath() %>/js/session-check.js"></script>
</body>
</html>
