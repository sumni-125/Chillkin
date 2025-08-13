<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="branches.Order" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>주문 내역</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/orderList.css">
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

<div class="container">
    <table>
        <thead>
            <tr>
                <th>주문번호</th>
                <th>메뉴</th>
                <th>주문 수량</th>
                <th>주문 시간</th> 
            </tr>
        </thead>
        <tbody>
            <% ArrayList<Order> olist = (ArrayList<Order>) request.getAttribute("olist"); %>
            <% for (Order o : olist) { %>
            <tr>
                <td><%= o.getO_Code() %></td>
                <td><%= o.getMenu_name() %></td>
                <td><%= o.getO_cnt() %></td>
                <td><%= o.getO_Date() %></td> 
            </tr>
            <% } %>
        </tbody>
    </table>

    <div style="text-align: right; margin-top: 30px;">
        <a href="<%= request.getContextPath() %>/b_main" class="back-btn">가맹점 페이지로</a>
    </div>
</div>
<script src="<%= request.getContextPath() %>/js/session-check.js"></script>
</body>
</html>
