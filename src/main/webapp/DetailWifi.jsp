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
    <title>와이파이 상세 정보</title>
</head>
<body>
    <h1>와이파이 상세 정보</h1>
    <p>
        <a href="/">홈</a> |
        <a href="/history">와이파이 히스토리 목록</a> |
        <a href="/load-wifi">Open API 와이파이 정보 가져오기</a> |
        <a href="/bookmark-list">북마크 보기</a> |
        <a href="/bookmark-group">북마크 그룹 관리</a>
    </p>
    <button>북마크 추가하기</button>
    <c:forEach items="${wifiDetail}" var="wifi">
        <table border="1">
            <tr>
                <th>거리(Km)</th>
                <td><c:out value="${wifi.distance}"/></td>
            </tr>
            <tr>
                <th>관리번호</th>
                <td><c:out value="${wifi.mgrNo}"/></td>
            </tr>
            <tr>
                <th>자치구</th>
                <td><c:out value="${wifi.wrdofc}"/></td>
            </tr>
            <tr>
                <th>와이파이명</th>
                <td><c:out value="${wifi.mainNm}"/></td>
            </tr>
            <tr>
                <th>도로명주소</th>
                <td><c:out value="${wifi.adres1}"/></td>
            </tr>
            <tr>
                <th>상세주소</th>
                <td><c:out value="${wifi.adres2}"/></td>
            </tr>
            <tr>
                <th>설치위치(층)</th>
                <td><c:out value="${wifi.floor}"/></td>
            </tr>
            <tr>
                <th>설치유형</th>
                <td><c:out value="${wifi.ty}"/></td>
            </tr>
            <tr>
                <th>설치기관</th>
                <td><c:out value="${wifi.mby}"/></td>
            </tr>
            <tr>
                <th>서비스구분</th>
                <td><c:out value="${wifi.svcSe}"/></td>
            </tr>
            <tr>
                <th>망종류</th>
                <td><c:out value="${wifi.cmcwr}"/></td>
            </tr>
            <tr>
                <th>설치년도</th>
                <td><c:out value="${wifi.year}"/></td>
            </tr>
            <tr>
                <th>실내외구분</th>
                <td><c:out value="${wifi.door}"/></td>
            </tr>
            <tr>
                <th>WIFI접속환경</th>
                <td><c:out value="${wifi.remars3}"/></td>
            </tr>
            <tr>
                <th>X좌표</th>
                <td><c:out value="${wifi.lat}"/></td>
            </tr>
            <tr>
                <th>Y좌표</th>
                <td><c:out value="${wifi.lnt}"/></td>
            </tr>
            <tr>
                <th>작업일자</th>
                <td><c:out value="${wifi.dttm}"/></td>
            </tr>
        </table>
    </c:forEach>
</body>
</html>