<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>
<form action="/Spring_MVC_CRUD_Demo/product/updateproducts" method="post">
	Product Id: <input type="text" name="pid" id="pid" value="${p.pid}" readonly><br>
	Product Name: <input type="text" name="pname" id="pname" value="${p.pname}"><br>
	Product Quantity: <input type="text" name="qty" id="qty" value="${p.qty}"><br>
	Product Price: <input type="text" name="price" id="price" value="${p.price}"><br>
	Product Expiry Date: <input type="text" name="expdate" id="expdate" value="${p.expdate}"><br>
	Product Category Id: <input type="text" name="cid" id="cid" value="${p.cid}"><br>
	<button type="submit" name="btn" id="btn">Update Product</button>
</form>
</body>
</html>