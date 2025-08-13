<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 관리</title>
    <link href="<%= request.getContextPath() %>/css/common-table.css" rel="stylesheet" type="text/css">
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
    <h2>재고 관리</h2>
    <table>
        <thead>
        <tr>
            <th>상품코드</th>
            <th>상품명</th>
            <th>수량</th>
            <th>상품가격</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="h" items="${list}">
        
			<tr>
				<td>${h.getCode()}</td>
				<td>${h.getName()}</td>
				<td>${h.getCnt()}</td>
				<td class="price">${h.getPrice()}</td>
			</tr>
			
		</c:forEach>
		</tbody>
	</table>	
	
	<script type="text/javascript">
		document.addEventListener("DOMContentLoaded", function () {
		    let items = document.querySelectorAll(".price");
		    items.forEach(item => {
		        let num = Number(item.innerText);
		        item.innerText = num.toLocaleString() + '원';
		    });
		});
	</script>
	<div class="go-to-home">
		<a href="<%= request.getContextPath() %>/h_main">본사 홈페이지</a>
	</div>
        </div>
        </body>
</html>

