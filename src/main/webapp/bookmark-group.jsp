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
    <title>북마크 그룹 관리</title>
</head>
<body>
    <h1>북마크 그룹 관리</h1>
    <p>
        <a href="/">홈</a> |
        <a href="/history">와이파이 히스토리 목록</a> |
        <a href="/load-wifi">Open API 와이파이 정보 가져오기</a> |
        <a href="/bookmark-list">북마크 보기</a> |
        <a href="/bookmark-group">북마크 그룹 관리</a>
    </p>
    <form id ="bookmark-form" action="/bookmark-group-add.jsp">
    <button>북마크 그룹 이름 추가</button>
    </form>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>북마크 이름</th>
            <th>순서</th>
            <th>등록일자</th>
            <th>수정일자</th>
            <th>비고</th>
        </tr>
        <c:forEach items="${group}" var="group">
            <tr>
                <td><c:out value="${group.id}"/></td>
                <td><c:out value="${group.name}"/></td>
                <td><c:out value="${group.order}"/></td>
                <td><c:out value="${group.addDate}"/></td>
                <td><c:out value="${group.modifyDate}"/></td>
                <td><a href="/bookmark-group-select?id=${group.id}&action=modify"> 수정 </a>
                <a href="/bookmark-group-select?id=${group.id}&action=delete"> 삭제 </a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>