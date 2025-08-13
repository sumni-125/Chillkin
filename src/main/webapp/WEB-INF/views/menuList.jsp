<%@page import="java.util.ArrayList"%>
<%@page import="branches.Branches"%>
<%@page import="branches.Menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 리스트</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/menuList.css?v=6">
<script>
let currentIndex = 0;

// 지점 선택 시, 모든 폼의 hidden input값(Branch_Id)을 변경
function chageSelect() {
    const selectBranch = document.getElementById("selectBox");
    const selectedBranchId = selectBranch.value;
    const branchInputs = document.getElementsByClassName("BranchId");
    for (let i = 0; i < branchInputs.length; i++) {
        branchInputs[i].value = selectedBranchId;
    }
}

// 메뉴 스크롤 (좌/우)
function scrollMenu(direction) {
    const scrollContainer = document.getElementById("menuScroll");
    const totalCards = document.querySelectorAll(".menu-list li").length;
    const cardWidth = scrollContainer.offsetWidth;

    if (direction === "left") {
        currentIndex = (currentIndex - 1 + totalCards) % totalCards;
    } else {
        currentIndex = (currentIndex + 1) % totalCards;
    }

    scrollContainer.scrollTo({
        left: cardWidth * currentIndex,
        behavior: "smooth"
    });
}

function alertok(btn){
	
	console.log("btn click");
	console.log( btn);
    let form = btn.closest("form");
    
    console.log( form);
    let menuCode = form.querySelector("input[name='Menu_Code']").value;
    let count = form.querySelector("input[name='O_cnt']").value;

    
    //console.log(menuCode);
    //console.log(count);
    
    
    //alert( menuCode);
    //alert( count);
    
    //alert( `주문확인  메뉴코드 `  +  menuCode    +  count);
    
    switch(menuCode){
    case "CH001":
    	alert("메뉴 : 후라이드치킨\n개수 : "+count+"마리");
    	break;
    case "CH002":
    	alert("메뉴 : 간장치킨\n개수 : "+count+"마리");
    	break;
    case "CH003":
    	alert("메뉴 : 양념치킨\n개수 : "+count+"마리");
    	break;
    case "CH004":
    	alert("메뉴 : 뿌링클치킨\n개수 : "+count+"마리");
    	break;
    case "CH005":
    	alert("메뉴 : 슈프림양념치킨\n개수 : "+count+"마리");
    	break;
    }
   

    // form.submit(); // alert 창 닫힌 뒤 폼 제출
}
</script>
</head>
<body>

<%
ArrayList<Branches> bList = (ArrayList<Branches>) request.getAttribute("bList");
ArrayList<Menu> mList = (ArrayList<Menu>) request.getAttribute("mList");
%>

<div class="wrap">
    <nav class="top-bar">
        <div class="left">
            <a href="<%= request.getContextPath() %>/login">가맹점 로그인하기</a>
        </div>
        <div class="center">
            <img src="<%= request.getContextPath() %>/img/logo.png" class="logo" alt="로고">
            <span>ChillKin</span>
        </div>
        <div class="right">
            <select id="selectBox" name="Branch_Id" onchange="chageSelect()">
                <% for (Branches b : bList) { %>
                    <option value="<%= b.getBranch_Id() %>"><%= b.getAddress() %></option>
                <% } %>
            </select>
        </div>
    </nav>

    <div class="menu-wrap">
        <button class="scroll-btn prev" onclick="scrollMenu('left')">〈</button>

        <div class="menu-scroll" id="menuScroll">
            <ul class="menu-list">
                <% for (Menu m : mList) { %>
                <li>
                    <form action="<%=request.getContextPath()%>/order" method="post">
                        <div class="img-box">
                            <img src="<%=request.getContextPath()%>/img/<%=m.getMenu_Code()%>.jpg">
                        </div>
                        <p class="menu-name"><%= m.getMenu_Name() %></p>
                        <label>수량:
                            <input type="number" name="O_cnt" min="1" max="99" value="1">
                        </label>
                        <input type="hidden" name="Branch_Id" class="BranchId" value="B2222">
                        <input type="hidden" name="Menu_Code" value="<%= m.getMenu_Code() %>">
                        <button type="button" onclick="alertok(this)">주문하기</button>
                    </form>
                </li>
                <% } %>
            </ul>
        </div>

        <button class="scroll-btn next" onclick="scrollMenu('right')">〉</button>
    </div>
</div>

</body>
</html>
