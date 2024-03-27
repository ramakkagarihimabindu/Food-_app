<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red">${message}</h1><br>
<form action="validateadmin" method="post">
enter email<input type="text" name="email">
enter password<input type="text" name="password">
<input type="submit">
</form>
</body>
</html>