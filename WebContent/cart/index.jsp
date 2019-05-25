<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java/sun.com/jsp/jstl/core" sp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:set var="base_url" value="http:8080/ShoppingCart_Server/" ></c:set>
	<table border = "1"> 
		<tr>
			<th> Action</th>
			<th> ID</th>
			<th> Name</th>
			<th> Price</th>
			<th> Quantity</th>
			<th> Sub Total</th>
			
			
		</tr>
		<c:forEach var="item" items="${sessionScope.cart }" varStatus="i">
			<tr> 
				<td><a href="cart?action=delete&index=${i.index }">X</a></td>
				<td> ${item.productWS.prId }</td>
				<td> ${item.productWS.name }</td>
				<td> ${item.productWS.unitPrice }</td>
				<td> ${item.qty }</td>
				<td> 
					${item.productWS.unitPrice * item.qty }
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="product">Continue Shopping</a> |
	<a href="cart?action=checkout">Check Out</a>
</body>
</html>