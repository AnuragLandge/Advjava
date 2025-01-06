<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.time.LocalDate,java.util.List,com.demo.beans.CartItem"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	User Name: ${user.uname} Date:
	<%=LocalDate.now()%><br>
	<table border="2">
		<tr>
			<th>Product pid</th>
			<th>Product name</th>
			<th>Order Qty</th>
			<th>Product Price</th>
			<th>Amount</th>
		</tr>
		<%
		double amt = 0;
		List<CartItem> clist = (List<CartItem>) session.getAttribute("cart");
		if (clist != null) {
			for (CartItem c : clist) {
		%>
		<tr>
			<td><%=c.getPid()%></td>
			<td><%=c.getPname()%></td>
			<td><%=c.getOrdQty()%></td>
			<td><%=c.getPrice()%></td>
			<td><%=c.getPrice() * c.getOrdQty()%></td>
		</tr>
		<%
		amt += c.getPrice() * c.getOrdQty();
		}
		%>
		<tr>
			<th colspan="4" align="right">Total Bill Amount:---</th>
			<td><%=amt%></td>
		</tr>
		<%
		} else {
		%>
		<tr>
			<td colspan="5">Your cart is empty.</td>
		</tr>
		<%
		}
		%>

	</table>
	<a href="categories">add more products</a>
	<form action="payment.jsp">
		<button type="submit" name="btn" id="btn">Payment</button>
	</form>
</body>
</html>

