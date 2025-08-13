<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>발주 완료</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/b_i_orderComplete.css">
</head>
<body>

<div class="top-bar">
    <div class="left">
        <a href="<%= request.getContextPath() %>/logout">로그아웃</a>
    </div>
    <div class="center">
        <img src="<%= request.getContextPath() %>/img/logo.png" class="logo" alt="로고">
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

<div class="container">
    <h2>발주 신청이 완료되었습니다.</h2>
    <div style="text-align:center; margin-top: 40px;">
        <a href="<%= request.getContextPath() %>/b_main" class="back-btn">가맹점 페이지로</a>
    </div>
</div>

<script src="<%= request.getContextPath() %>/js/session-check.js"></script>
</body>
</html>
