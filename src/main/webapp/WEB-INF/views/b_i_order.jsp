<%@page import="branches.Hub"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자재 발주 신청</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/b_i_order.css?v=1">
</head>
<body>

<div class="top-bar">
    <div class="left">
        <a href="<%=request.getContextPath()%>/logout">가맹점 로그아웃</a>
    </div>
    <div class="center">
        <img src="<%= request.getContextPath() %>/img/logo.png" class="logo" alt="로고">
        <span>ChillKin</span>
    </div>
    <div class="right">
        <%= session.getAttribute("branch_name") != null ? session.getAttribute("branch_name") : "지점" %>
    </div>
</div>

<% ArrayList<Hub> hlist = (ArrayList<Hub>) request.getAttribute("h_list"); %>

<div class="container">
    <h2> 자재 발주 신청</h2>

    <form action="<%=request.getContextPath()%>/B_I_Order" method="post">
        <div class="table-box">
            <table>
                <thead>
                    <tr>
                        <th>상품</th>
                        <th>재료명</th>
                        <th>가격</th>
                        <th>발주 수량</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Hub h : hlist) { %>
                    <tr>
                        <td>
                            <div class="img-box">
                                <img src="<%= request.getContextPath() %>/img/<%
                                    if ("I001".equals(h.getCode())) out.print("chicken.png");
                                    else if ("I002".equals(h.getCode())) out.print("soysauce.png");
                                    else if ("I003".equals(h.getCode())) out.print("chickensauce.png");
                                    else if ("I004".equals(h.getCode())) out.print("poringcleseasoning.png");
                                    else if ("I005".equals(h.getCode())) out.print("supremesauce.png");
                                %>" alt="<%= h.getName() %>">
                            </div>
                        </td>
                        <td><%= h.getName() %></td>
                        <td><%= h.getPrice() %></td>
                        <td>
                            <input type="number" name="I_Cnt[]" value="0" min="0" max="<%= h.getCnt() %>">
                            <input type="hidden" name="I_Code[]" value="<%= h.getCode() %>">
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <div class="btn-area">
            <button type="submit" class="order-btn">발주 신청</button>
            <a href="<%=request.getContextPath()%>/b_main" class="back-btn">가맹점 페이지로</a>
        </div>
    </form>
</div>


<script src="<%= request.getContextPath() %>/js/session-check.js"></script>

</body>
</html>
