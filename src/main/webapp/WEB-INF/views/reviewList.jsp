<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%= request.getContextPath() %>/css/reviewList.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	const contextPath = "<%=request.getContextPath()%>";

	document.addEventListener("DOMContentLoaded",
	    function reviewList(){
			$.ajax({
				type:"GET",
				url:"<%=request.getContextPath()%>/myReview",
				success:function(data){  
					console.log(data);
					$("#result tr:not(:first)").remove();
					
					for (let i = 0; i < data.length; i++) {
					    let review = data[i];
					    console.log(review);

					    let str = "<tr>";
					    str += "<td>" + review.R_CODE + "</td>";
					    str += "<td>" + review.Title + "</td>";
					    str += "<td>" + review.ID + "</td>";
					    str += "<td>" + review.Detail + "</td>";
					    str += "<td>" + review.R_DATE + "</td>";
					    str += "</tr>";  // <-- 이건 항상 들어가도 OK

					    if (review.Answer != null) {
					        str+= "<tr><td class='answer-style' colspan='5'>🎈 건의코드 <strong>" + review.R_CODE + "</strong>에 대한 답변 : " + review.Answer + "</td></tr>";
					    } else {
					    	str+= "<tr><td colspan='5'>답변이 아직 없습니다</td></tr>";
					    }
					    
					    //str+=str_;
	
					    $("#result").append(str);
					}
				},
				error:function(err){
					alert("시스템 오류");
				}
			});
		}
	);
</script>
</head>
<body>
	<header>
		<h2>건의사항 조회 페이지</h2>
		<a href="<%= request.getContextPath() %>/b_main">홈페이지 돌아가기</a>		
	</header>

	<div>
		<table id="result">
			<tr>
				<th>건의 코드</th>
				<th>제목</th>
				<th>작성자</th>
				<th>내용</th>
				<th>작성일자</th>
			</tr>
		</table>
	<div class="btn-wrapper">
		<a href="<%= request.getContextPath() %>/Review_Write" class="write-btn">건의작성하기</a>
	</div>
	</div>
	<script src="/Chillkin/js/session-check.js"></script>
	
</body>
</html>