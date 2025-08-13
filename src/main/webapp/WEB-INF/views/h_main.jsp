<%@page import="java.util.List"%>
<%@page import="headquerter.Reviews"%>
<%@page import="headquerter.PagingVO" %>
<%@page import="headquerter.ReviewService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>ChillKin 콤파니</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/MVCprj0422/css/main.css">
</head>
<body>
<% List<Reviews> rlist = (List<Reviews>)request.getAttribute("rlist"); %>
<% ArrayList<Reviews> list = (ArrayList<Reviews>)request.getAttribute("list"); %>
<div class="container">
    <div class="sidebar">
        <div class="logo-row">
            <img src="${pageContext.request.contextPath}/img/logo.png" alt="logo">
            <span class="logo-title">ChillKin 콤파니</span>
        </div>
        <div class="sidebar-menu">
            <div><a href="<%=request.getContextPath()%>/h_stockmanage">창고 재고 관리</a></div>
            <div><a href="<%=request.getContextPath()%>/h_orderingInfo">발주 정보</a></div>
            <div><a href="<%=request.getContextPath()%>/h_branchesInfo">가맹점 관리</a></div>
            <div><a href="<%=request.getContextPath()%>/reviewPrint">문의접수 목록</a></div>
        </div>
        <img class="chicken-img" src="${pageContext.request.contextPath}/img/chillkinguy.png" alt="chicken">
    </div>
    <div class="main">
        <div class="title">가맹점 문의함</div>
        <!--(for 문으로 db 출력)-->
        <div class ="notice-container">
        <% for (Reviews r : rlist) { %>
    <div class="notice-box">
        <table class="notice-table">
            <tr>
                <th>접수번호</th>
                <td><%= r.getR_code() %></td>
            </tr>
            <tr>
                <th>접수 지점 코드</th>
                <td><%= r.getId() %></td>
            </tr>
            <tr>
                <th>접수 일자</th>
                <td><%= r.getR_date() %></td>
            </tr>
            <tr>
            	<th>제목</th>
                <td colspan="2" style="padding-top:10px; font-size:14.5px;">
                    <%= r.getTitle() %>
                </td>
            </tr>

            <% if (r.getAnswer() != null) { %>
            <tr>
            	<th>답변</th>
                <td colspan="2" style="padding-top:10px; font-size:14.5px;">
                    <%= r.getAnswer() %>
                </td>
            </tr>
            <% } %>
        </table>

        <% if (r.getAnswer() == null) { %>
            <div class="notice-bottom">
                <a href="<%= request.getContextPath() %>/answer123?r_code=<%= r.getR_code() %>">답변하기</a>
            </div>
        <% } %>
    </div>
<% } %>

        </div>
        <!-- 페이징 -->
        <div class="paging" style="text-align: center;">
        <%
        PagingVO paging = (PagingVO)request.getAttribute("paging");
        int first = paging.getFirstPage();
        int last = paging.getLastPage();
        int cur = paging.getCurPage();
        %>
        <% if (first >1){ %>
           <a href="h_main?page=<%=first -1 %>">이전</a>
        <%} %>
        <% for (int i = first; i <= last; i++) { %>
            <% if (i == cur) { %>
                <strong><%= i %></strong>
            <% } else { %>
                <a href="h_main?page=<%= i %>"><%= i %></a>
            <% } %>
        <% } %>

        <% if (last < paging.getTotalPageCount()) { %>
            <a href="h_main?page=<%= last + 1 %>">다음</a>
        <% } %>
        </div>
    </div>
    <%
if (rlist != null) {
    System.out.println("rlist size: " + rlist.size());
} else {
    System.out.println("rlist is null");
}
%>
</div>
</body>
</html>