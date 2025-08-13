<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 조회</title>
<link href="<%= request.getContextPath() %>/css/common-table.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	const contextPath = "<%=request.getContextPath()%>";

	document.addEventListener("DOMContentLoaded",
	    function reviewList(){
			$.ajax({
				type:"GET",
				url:"<%=request.getContextPath()%>/reviewList",
				success:function(data){  //str에 계속 누적되는게 문제인거같아서
					//let str="";  //기존에 str에 추가했던거 초기화하고 다시 받아오는거 try했는데 실패함
					console.log(data);
					$("#result tr:not(:first)").remove();
					
					for (let i = 0; i < data.length; i++) {
					    let review = data[i];
					    console.log(review);

					    let str = "<tr>";
					    str += "<td>💫 " + review.R_CODE + "</td>";
					    str += "<td>" + review.Title + "</td>";
					    str += "<td>" + review.ID + "</td>";
					    str += "<td>" + review.Detail + "</td>";
					    str += "<td>" + review.R_DATE + "</td>";
					    str += "</tr>"; 
					    if (review.Answer != null) {
					        str+= "<tr><td class='answer-style' colspan='5'>🎈 건의코드 <strong>" + review.R_CODE + "</strong>에 대한 답변 : " + review.Answer + "</td></tr>";
					    } else {
					    	str+= "<tr><td colspan='5'><a href='" + contextPath + "/answer123?r_code=" + review.R_CODE + "'>답변작성</a></td></tr>";
					    }

					    $("#result").append(str);
					}
				
				},
				error:function(err){
					alert("시스템 실행 오류 ㅜㅜ");
				}
			});
		}
	);
</script>
</head>
<body>
	
<header class="main-header">
        <img src="img/logo.png" alt="로고" class="logo">
        <span class="header-title">ChillKin 콤파니</span>
        <img src="img/chillkinguy.png" alt="칰가이" class="chicken-img">
    </header>
    <main class="main-body">
        <h2>건의사항 답변조회</h2>
	
	<div>
		<table id="result">
			<tr>
				<th>건의 코드</th>
				<th>제목</th>
				<th>점포코드</th>
				<th>내용</th>
				<th>작성일자</th>
			</tr>
		</table>
		<div class="go-to-home">
			<a href="<%= request.getContextPath() %>/h_main">홈페이지 돌아가기</a>
		</div>
	</div>
    </main>
	
</body>
</html>