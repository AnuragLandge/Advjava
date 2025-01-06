<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Select Category</h1>
	<form action="getProducts">
		<select name="cid" id="cid">
			<c:forEach var="c" items="${clist}">
				<option value="${c.cid}">${c.cname}</option>
			</c:forEach>
		</select>
		<button type="submit" name="btn" id="btn">Show Products</button>
	</form>
	<a href="showcart.jsp">Show cart</a>
</body>
</html>