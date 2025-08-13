<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>건의사항 작성</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/reviewWrite.css">
</head>
<body>

<div class="top-bar">
    <div class="left">
        <a href="<%= request.getContextPath() %>/logout">가맹점 로그아웃</a>
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
    <h2>건의 작성</h2>

    <form action="${pageContext.request.contextPath}/Review_Write" method="post" accept-charset="UTF-8" class="review-form">

        <%
            String branchId = (String) session.getAttribute("branch_id");
            if (branchId == null) {
                branchId = (String) session.getAttribute("loginId"); 
            }
            if (branchId == null) branchId = "";
        %>

        <div class="input-row">
            <input type="text" name="R_cityCode" value="<%= branchId %>" readonly>
            <input type="text" name="R_title" placeholder="TITLE 제목" required>
        </div>

        <textarea name="R_detail" placeholder="건의 내용 DETAIL" rows="8" required></textarea>

        <div class="btn-area">
            <input type="submit" value="보내기" class="submit-btn">
            <a href="<%= request.getContextPath() %>/b_main" class="back-btn">가맹점 페이지로</a>
        </div>
    </form>
</div>
<script src="<%= request.getContextPath() %>/js/session-check.js"></script>
</body>
</html>
