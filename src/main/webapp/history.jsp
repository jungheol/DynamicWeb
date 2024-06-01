<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>와이파이 정보 구하기</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: auto;
        }
        .search-bar {
            margin-bottom: 20px;
        }
        .search-bar input[type="text"] {
            padding: 10px;
            margin-right: 10px;
            width: 150px;
        }
        .search-bar button {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
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
</head>
<body>
    <div class="container">
        <h1>위치 히스토리 목록</h1>
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
                    <th>X좌표</th>
                    <th>Y좌표</th>
                    <th>조회일자</th>
                    <th>비고</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allList}" var="history">
                    <tr class ="Info">
                        <form action="/history" method="get">
                        <input type="hidden" name="id" value="${history.id}"/>
                        <td><c:out value="${history.id}"/></td>
                        <td><c:out value="${history.lat}"/></td>
                        <td><c:out value="${history.lnt}"/></td>
                        <td><c:out value="${history.date}"/></td>
                        <td><button type ="submit" class="button"> 삭제 </button></td>
                        </form>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>