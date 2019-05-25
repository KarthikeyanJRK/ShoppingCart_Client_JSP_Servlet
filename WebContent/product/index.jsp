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
			<th> ID</th>
			<th> Name</th>
			<th> Price</th>
			<th> Quantity</th>
			<th> Action</th>
			
		</tr>
		<c:forEach var="product" items="${product }">
			<tr> 
				<td> ${product.prId }</td>
				<td> ${product.name }</td>
				<td> ${product.unitPrice }</td>
				<td> ${product.qty }</td>
				<td> 
				<a href="cart?action=buy&id=${product.prId }">Buy</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>