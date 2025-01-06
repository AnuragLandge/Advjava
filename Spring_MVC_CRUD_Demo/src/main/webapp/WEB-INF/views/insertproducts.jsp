<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserting New Product</title>
</head>
<body>
<form action="addproducts" method="post">
	Product Id: <input type="text" name="pid" id="pid" placeholder="Enter Product id"><br>
	Product Name: <input type="text" name="pname" id="pname" placeholder="Enter Product name"><br>
	Product Quantity: <input type="text" name="qty" id="qty" placeholder="Enter Product quantity"><br>
	Product Price: <input type="text" name="price" id="price" placeholder="Enter Product price"><br>
	Product Expiry Date: <input type="text" name="expdate" id="expdate" placeholder="Enter Product Expiry date"><br>
	Product Category Id: <input type="text" name="cid" id="cid" placeholder="Enter Product Category id"><br>
	<button type="submit" name="btn" id="btn">Add Product</button>
</form>
</body>
</html>