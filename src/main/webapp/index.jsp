<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="CalcServlet" method="post">
    <!--    action = "CalcServlet"도 가능 제일 앞에 /가 중요하진 않은 듯-->
    <!--<form action = "cals.jsp" method="post">    -->
    숫자1 : <input type="text" name="num1"><br>
    숫자2 : <input type="text" name="num2"><br>
    이름  : <input type="text" name="userName"><br>
    <input type="submit" value="계산">
</form>
</body>
</html>