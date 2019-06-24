<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" style="color: red">书籍管理</h1>
<table align="center" border="1" >
<tr><td>id</td><td>书名</td><td>价格</td><td>操作</td><td>操作</td></tr>
<c:forEach items="${page.list }" var="b">
<tr>
<td>${b.id }</td>
<td>${b.bookname }</td>
<td>${b.price }</td>
<td><a href="editBook?id=${b.id }">编辑</a></td>
<td><a href="deleteBook?id=${b.id }">删除</a></td>
</tr>
</c:forEach>
</table><br>
<div align="center">
<a href="?start=1">[首页]</a>
<a href="?start=${page.pageNum-1 }">上一页</a>
<a href="?start=${page.pageNum+1 }">下一页</a>
<a href="?start=${page.pages }">[尾页]</a>
</div>
<div align="center" style="margin-top: 20px">
<h2 align="center"  style="color: red">书籍添加</h2>
<form action="addBook" method="post">
书名:<input type="text" name="bookname"/><br>
价格:<input type="text" name="price"/><br>
<input type="submit" value="提交"><br>
</form>
</div>


</body>
</html>