<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="branches.B_I_Order" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>발주 내역</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/b_i_orderList.css">
</head>
<body>

<div class="fixed-ingredient-guide">
    <h3>재료 코드 안내</h3>
    <ul>
        <li>
            <img src="<%= request.getContextPath() %>/img/chicken.png" class="ing-img">
            <strong>I001</strong> - 닭고기
        </li>
        <li>
            <img src="<%= request.getContextPath() %>/img/soysauce.png" class="ing-img">
            <strong>I002</strong> - 간장소스
        </li>
        <li>
            <img src="<%= request.getContextPath() %>/img/chickensauce.png" class="ing-img">
            <strong>I003</strong> - 양념소스
        </li>
        <li>
            <img src="<%= request.getContextPath() %>/img/poringcleseasoning.png" class="ing-img">
            <strong>I004</strong> - 뿌링클시즈닝
        </li>
        <li>
            <img src="<%= request.getContextPath() %>/img/supremesauce.png" class="ing-img">
            <strong>I005</strong> - 슈프림소스
        </li>
    </ul>
</div>

<div class="top-bar">
    <div class="left">
        <a href="<%= request.getContextPath() %>/logout">로그아웃</a>
    </div>
    <div class="center">
        <img src="<%= request.getContextPath() %>/img/logo.png" class="logo" alt="로고">
        <span>ChillKin</span>
    </div>
    <div class="right">
        <%
            String branchName = (String) session.getAttribute("branch_name");
            if (branchName == null) branchName = "지점명 없음";
        %>
        <%= branchName %>
    </div>
</div>

<div class="container">
    <h2>발주 내역 조회</h2>

    <div class="table-box">
        <table>
            <thead>
                <tr>
                    <th>발주코드</th>
                    <th>발주일자</th>
                    <th>재료코드</th>
                    <th>발주수량</th>
                </tr>
            </thead>
            <tbody>
            <%
                ArrayList<B_I_Order> bi_list = (ArrayList<B_I_Order>) request.getAttribute("ordeLlist");
                if (bi_list != null && !bi_list.isEmpty()) {
                    for (B_I_Order b : bi_list) {
            %>
                <tr>
                    <td><%= b.getB_I_Code() %></td>
                    <td><%= b.getB_I_Date() %></td>
                    <td><%= b.getI_Code() %></td>
                    <td><%= b.getI_Cnt() %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="4">발주 내역이 없습니다.</td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<div style="text-align: center; margin-top: 40px;">
    <a href="<%= request.getContextPath() %>/b_main" class="back-btn">가맹점 메인으로</a>
</div>
<script src="<%= request.getContextPath() %>/js/session-check.js"></script>
</body>
</html>
