
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가맹점 메인</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/branchmain.css">
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
        <%= session.getAttribute("branch_name") != null ? session.getAttribute("branch_name") : "점" %>
    </div>
</div>

<div class="menu-container">
    <a href="<%= request.getContextPath() %>/ingredients" class="card">
        <h3>매장 재고 관리</h3>
        <p>가맹점의<br>소유 자재 수량 확인</p>
        <div class="icon-img">
            <img src="<%= request.getContextPath() %>/img/ingredients.png" alt="재고">
        </div>
    </a>
    <a href="<%= request.getContextPath() %>/B_I_Order" class="card">
        <h3>발주 신청</h3>
        <p>본사에<br>자재 발주 신청</p>
        <div class="icon-img">
            <img src="<%= request.getContextPath() %>/img/b_i_order.png" alt="발주">
        </div>
    </a>
    <a href="<%= request.getContextPath() %>/B_I_OrderList" class="card">
        <h3>발주 내역</h3>
        <p>발주 내역<br>확인</p>
        <div class="icon-img">
            <img src="<%= request.getContextPath() %>/img/b_i_orderlist.png" alt="발주내역">
        </div>
    </a>
    <a href="<%= request.getContextPath() %>/OrderList" class="card">
        <h3>픽업 주문 내역</h3>
        <p>가맹점의<br>픽업 주문 내역 확인</p>
        <div class="icon-img">
            <img src="<%= request.getContextPath() %>/img/orderlist.png" alt="픽업">
        </div>
    </a>
    <a href="<%= request.getContextPath() %>/printReview" class="card">
        <h3>건의함</h3>
        <p>가맹점 → 본사<br>건의 접수</p>
        <div class="icon-img">
            <img src="<%= request.getContextPath() %>/img/review.png" alt="문의">
        </div>
    </a>
</div>
<script src="<%= request.getContextPath() %>/js/session-check.js"></script>
</body>
</html>
