<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="o" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>발주 정보</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common-table.css">
</head>
<body>
<div class="main-header">
    <div class="header-center">
        <img class="logo" src="img/logo.png" alt="로고">
        <span class="header-title">ChillKin 콤파니</span>
    </div>
</div>
<img class="chicken-img" src="img/chillkinguy.png" alt="닭 이미지">
<div class="main-body">
    <h2>주문 정보</h2>
    <table>
        <thead>
        <tr>
            <th>주문번호</th>
            <th>가맹점 코드</th>
            <th>상품 코드</th>
            <th>수량</th>
            <th>주문일자</th>
        </tr>
        </thead>
        <tbody>
        <o:forEach var="b" items="${list }">
			<tr>
				<td>${b.getB_i_code()}</td>
				<td>${b.getB_code()}</td>
				<td>${b.getI_code()}</td>
				<td>${b.getCnt()}</td>
				<td>${b.getB_i_date()}</td>
			</tr>
		</o:forEach>
        </tbody>
	</table>
	<div class="go-to-home">
		<a href="<%= request.getContextPath() %>/h_main">본사 홈페이지</a>
	</div>
	</div>
</body>
</html>

