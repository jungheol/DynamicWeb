<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <style>
    table {
        width: 100%;
        border-collapse: collapse;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th {
        width: 25%;
        background-color: #4CAF50;
        color: white;
        text-align: center;
    }
    td {
        padding: 10px;
        text-align: left;
    }
    .button-container {
        text-align : center;
    }
    button {
        margin-top: 10px;
    }
    </style>
    <title>북마크 그룹</title>
</head>
<body>
    <h1>북마크 그룹</h1>
    <p>
        <a href="/">홈</a> |
        <a href="/history">와이파이 히스토리 목록</a> |
        <a href="/load-wifi">Open API 와이파이 정보 가져오기</a> |
        <a href="/bookmark-list">북마크 보기</a> |
        <a href="/bookmark-group">북마크 그룹 관리</a>
    </p>
    <form id ="bookmark-form" action="/bookmark-group-modify" method="get">
        <table>
            <tr>
                <th>북마크 이름</th>
                <td><input type = "text" id="name" name="name" value=<c:out value="${name}"/>></td>
            </tr>
            <tr>
                <th>순서</th>
                <td><input type = "text" id="order_idx" name="order_idx" value=<c:out value="${order_idx}"/>></td>
            </tr>
        </table>
        <input type="hidden" name="id" value=<c:out value="${id}"/>>
        <div class="button-container">
            <a href="/bookmark-group">돌아가기</a> | <button type="submit">수정</button>
        </div>
    </form>
</body>
</html>