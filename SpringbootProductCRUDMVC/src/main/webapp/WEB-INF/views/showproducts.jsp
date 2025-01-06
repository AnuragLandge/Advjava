<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="2px">
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Qty</th>
			<th>Product Price</th><!-- 
			<th>Product ExpDate</th>
			<th>Product Cid</th> -->
			<th>Actions</th>
		</tr>
		<c:forEach var="p" items="${plist}">
			<tr>
				<td>${p.pid}</td>
				<td>${p.pname}</td>
				<td>${p.qty}</td>
				<td>${p.price}</td><%-- 
				<td>${p.expdate}</td>
				<td>${p.cid}</td> --%>
				<td><a href="editproducts/${p.pid}">edit</a>/ <a
					href="deleteproducts/${p.pid}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<form action="addnewproducts">
		<button type="submit" id="btn" name="btn">Add New Product</button>
	</form>
</body>
</html>
