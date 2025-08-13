<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>건의 답변 작성</title>
<link href="<%= request.getContextPath() %>/css/answer.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>건의 답변 작성</h1>
    <p>${param.r_code}번 글에 대한 답변을 작성해주세요</p>

    <form action="<%= request.getContextPath() %>/updateanswer" method="POST">
        <input type="hidden" name="r_code" value="${param.r_code}">
        <textarea class="answer" name="h_answer" placeholder="답변을 입력하세요."></textarea>
        <input type="submit" value="답변 제출">
    </form>
</body>
</html>
