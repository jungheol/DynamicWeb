<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>
    </title>
    <style>
            body {
                text-align: center;
            }
    </style>
</head>
<body>
<h1><c:out value="${count}"/></h1>
<a href="/">홈으로 가기</a>
</body>
