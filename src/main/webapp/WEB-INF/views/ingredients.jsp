<%@page import="branches.Ingredients"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 확인</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/ingredients.css?v=3">
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

<% ArrayList<Ingredients> list = (ArrayList<Ingredients>) request.getAttribute("list"); %>

<div class="container">
    <div class="table-box">
        <table>
            <thead>
                <tr>
                    <th>상품</th>
                    <th>물품 코드</th>
                    <th>물품명</th>
                    <th>현재고</th>
                </tr>
            </thead>
            <tbody>
                <% for(Ingredients i : list) {
                    String name = i.getI_name();
                    String imgFile = "";
                    if ("닭고기".equals(name)) {
                        imgFile = "chicken.png";
                    } else if ("간장소스".equals(name)) {
                        imgFile = "soysauce.png";
                    } else if ("양념소스".equals(name)) {
                        imgFile = "chickensauce.png";
                    } else if ("뿌링클시즈닝".equals(name)){
                        imgFile = "poringcleseasoning.png";
                    } else if("슈프림소스".equals(name)){
                    	imgFile = "supremesauce.png";
                    } else{
                    	imgFile = "default.png"; // 예외 처리용
                    }
                %>
                <tr>
                    <td>
                        <div class="img-box">
                            <img src="<%= request.getContextPath() %>/img/<%= imgFile %>" alt="<%= name %>">
                        </div>
                    </td>
                    <td><%= i.getI_code() %></td>
                    <td><%= name %></td>
                    <td><input type="text" class="cnt" value="<%= i.getI_cnt() %>" readonly></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>

    <div class="btn-area">
        <a href="<%=request.getContextPath()%>/b_main" class="back-btn">가맹점 페이지로</a>
    </div>
</div>
<script src="<%= request.getContextPath() %>/js/session-check.js"></script>
</body>
</html>
