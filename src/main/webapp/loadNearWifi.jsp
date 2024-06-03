<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>와이파이 정보 구하기</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 100%;
            margin: auto;
        }
        .search-bar {
            margin-bottom: 20px;
        }
        .search-bar input[type="text"] {
            padding: 3px;
            margin-right: 10px;
            width: 150px;
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
        <h1>와이파이 정보 구하기</h1>
        <p>
            <a href="/">홈</a> |
            <a href="/history">와이파이 히스토리 목록</a> |
            <a href="/load-wifi">Open API 와이파이 정보 가져오기</a> |
            <a href="/bookmark-list">북마크 보기</a> |
            <a href="/bookmark-group">북마크 그룹 관리</a>
        </p>
        <div class="search-bar">
            <form id ="wifi-form" action="/location" method="post">
            <label for="lat">LAT:</label>
            <input type="text" id="lat" name="lat" value=<c:out value="${lat}"/>>
            <label for="lnt">LNT:</label>
            <input type="text" id="lnt" name="lnt" value=<c:out value="${lnt}"/>>
            <button id="get-location">내 위치 가져오기</button>
            <button>근처 WIFI 정보 보기</button>
            </form>
        </div>
        <table>
            <thead>
                <tr>
                    <th>거리(Km)</th>
                    <th>관리번호</th>
                    <th>자치구</th>
                    <th>와이파이명</th>
                    <th>도로명주소</th>
                    <th>상세주소</th>
                    <th>설치위치(층)</th>
                    <th>설치유형</th>
                    <th>설치기관</th>
                    <th>서비스구분</th>
                    <th>망종류</th>
                    <th>설치년도</th>
                    <th>실내외구분</th>
                    <th>WIFI접속환경</th>
                    <th>X좌표</th>
                    <th>Y좌표</th>
                    <th>작업일자</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${searchList}" var="wifi">
                <tr>
                    <td><c:out value="${wifi.distance}"/></td>
                    <td><c:out value="${wifi.mgrNo}"/></td>
                    <td><c:out value="${wifi.wrdofc}"/></td>
                    <td>
                        <p>
                            <a href="/detail?mgrNo=${wifi.mgrNo}">
                                <c:out value="${wifi.mainNm}"/>
                            </a>
                        </p>
                    </td>
                    <td><c:out value="${wifi.adres1}"/></td>
                    <td><c:out value="${wifi.adres2}"/></td>
                    <td><c:out value="${wifi.floor}"/></td>
                    <td><c:out value="${wifi.ty}"/></td>
                    <td><c:out value="${wifi.mby}"/></td>
                    <td><c:out value="${wifi.svcSe}"/></td>
                    <td><c:out value="${wifi.cmcwr}"/></td>
                    <td><c:out value="${wifi.year}"/></td>
                    <td><c:out value="${wifi.door}"/></td>
                    <td><c:out value="${wifi.remars3}"/></td>
                    <td><c:out value="${wifi.lat}"/></td>
                    <td><c:out value="${wifi.lnt}"/></td>
                    <td><c:out value="${wifi.dttm}"/></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
<script>
    document.getElementById('get-location').addEventListener('click', function(event) {
        event.preventDefault();
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
                document.getElementById('lat').value = position.coords.latitude;
                document.getElementById('lnt').value = position.coords.longitude;

                document.getElementById('location-form').submit();
            }, function(error) {
                console.error("Error Code = " + error.code + " - " + error.message);
            });
        } else {
            alert("Geolocation is not supported by this browser.");
        }
    });
</script>
</body>
</html>