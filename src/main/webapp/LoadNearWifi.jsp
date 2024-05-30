<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
        <h1>와이파이 정보 구하기</h1>
        <p>
        <a href="/">홈</a> |
        <a href="/history">와이파이 히스토리 목록</a> |
        <a href="/load-wifi">Open API 와이파이 정보 가져오기</a>
        </p>
        <div class="search-bar">
            <form id="location-form" action="/location" method="post">
            <label for="lat">LAT:</label>
            <input type="text" id="lat" name="lat" value="0.0">
            <label for="lnt">LNT:</label>
            <input type="text" id="lnt" name="lnt" value="0.0">
            <button id="get-location">내 위치 가져오기</button>
            </form>
            <form id ="wifi-form" action="/LoadNearWifi">
            <button>근처 WIFI 정보 보기</button>
            </form>
        </div>

        <table class="table" style="undefinedtable-layout: fixed; width: 1833px">
            <colgroup>
                <col style="width: 86px">
                <col style="width: 77px">
                <col style="width: 74px">
                <col style="width: 147px">
                <col style="width: 197px">
                <col style="width: 127px">
                <col style="width: 83px">
                <col style="width: 134px">
                <col style="width: 99px">
                <col style="width: 144px">
                <col style="width: 104px">
                <col style="width: 59px">
                <col style="width: 73px">
                <col style="width: 116px">
                <col style="width: 97px">
                <col style="width: 103px">
                <col style="width: 113px">
            </colgroup>
            <thead>
                <tr class ="near_wifi">
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
                <tr class="warning">
                    <td><c:out value="${wifi.distance}"/></td>
                    <td><c:out value="${wifi.mgrNo}"/></td>
                    <td><c:out value="${wifi.wrdofc}"/></td>
                    <td><c:out value="${wifi.mainNm}"/></td>
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