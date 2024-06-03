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
    .spacing {
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
    <a> 북마크를 삭제하시겠습니까? </a>
    <form id ="bookmark-form" action="/bookmark-delete" method="get">
        <table class="spacing">
            <tr>
                <th>북마크 이름</th>
                <td><c:out value="${bookmark_name}"/></td>
            </tr>
            <tr>
                <th>와이파이명</th>
                <td><c:out value="${wifi_name}"/></td>
            </tr>
            <tr>
                <th>등록일자</th>
                <td><c:out value="${date}"/></td>
            </tr>
        </table>
        <input type="hidden" name="id" value=<c:out value="${id}"/>>
        <div class="button-container">
            <a href="/bookmark-list">돌아가기</a> | <button type="submit">삭제</button>
        </div>
    </form>
</body>
</html>