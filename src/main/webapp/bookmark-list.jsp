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
    th, td {
        padding: 8px;
        text-align: center;
    }
    th {
        background-color: #4CAF50;
        color: white;
    }
    </style>
    <title>북마크 리스트</title>
</head>
<body>
    <h1>북마크 리스트</h1>
    <p>
        <a href="/">홈</a> |
        <a href="/history">와이파이 히스토리 목록</a> |
        <a href="/load-wifi">Open API 와이파이 정보 가져오기</a> |
        <a href="/bookmark-list">북마크 보기</a> |
        <a href="/bookmark-group">북마크 그룹 관리</a>
    </p>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>북마크 이름</th>
            <th>와이파이명</th>
            <th>등록일자</th>
            <th>비고</th>
        </tr>
        <c:forEach items="${list}" var="list">
            <tr>
                <td><c:out value="${list.id}"/></td>
                <td><c:out value="${list.groupName}"/></td>
                <td><c:out value="${list.wifiName}"/></td>
                <td><c:out value="${list.date}"/></td>
                <td>
                <a href="/bookmark-list-select?id=${list.id}"> 삭제 </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>