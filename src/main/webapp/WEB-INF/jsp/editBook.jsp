<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateBook" method="post">
书名:<input type="text" name="bookname" value="${b.bookname }"><br>
价格:<input type="text" name="price" value="${b.price }"><br>
<input type="hidden" name="id" value="${b.id }"><br>
<input type="submit" value="提交"> <br>
</form>
</body>
</html>