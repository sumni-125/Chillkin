<%@page import="headquerter.Branches"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가맹점 관리</title>
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
    <h2>지점 정보</h2>
    <table>
        <thead>
	        <tr>
	            <th>지점코드</th>
	            <th>비밀번호</th>
	            <th>가맹지점</th>
	            <th>연락처</th>
	        </tr>
        </thead>
        <tbody>
  			 <c:forEach var="b" items="${list}">
				<tr>
					<td>${b.getBranch_id()}</td>
					<td>${b.getPw()}</td>
					<td>${b.getAddress()}</td>
					<td>${b.getTel()}</td>
				</tr>
			</c:forEach>
        </tbody>
    </table>
    <div class="go-to-home">
    	<a href="<%= request.getContextPath() %>/h_main">본사 홈페이지</a><br>
    </div>
</div>
</body>
</html>



