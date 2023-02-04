<%@page import="Linkcode.shop.admin.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" >
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body style="background-color: blanchedalmond">
<%!List<Product> lst = null;
	Product prod = null;%>

	<%
	lst =(List<Product>)  session.getAttribute("prodlst");
		session.invalidate();
%>
 <div class="container">
		<div class="sidebar" style="padding: 10px;">

			<h1 style="padding: 10px; margin: 10px;">ABC PRODUCTS</h1>
			<a href="productView.jsp">
				<button type="submit"
					style="padding: 10px; margin: 10px; border: 5px; width: 250px;">Add
					product</button>
			</a> <br> <a href="SearchView.jsp">
				<button type="submit"
					style="padding: 10px; margin: 10px; border: 5px; width: 250px;">Search
					Product</button>
			</a> <br> <a href="DeleteView.jsp">
				<button type="submit"
					style="padding: 10px; margin: 10px; border: 5px; width: 250px;">Delete
					project</button>
			</a> <br>
			<form action="DisplayController">
				<input type="submit" value="Display All"
					style="padding: 10px; margin: 10px; border: 5px; width: 250px;">
			</form>
		</div>
        <div class="main">
        <table border="3px" background="gray" style="margin: 10%">
        <tr>
        <th>Product Id</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th>
	<%		
		for(Product prod:lst){
	%>
	
		<tr>
			<td><%=prod.getProdId()%></td>
			<td><%=prod.getProdName()%></td>
			<td><%=prod.getProdPrice()%></td>
			<td><%=prod.getProdQty()%></td>
		</tr>
           <%} %>
        </div>
    </div>
</body>
</html>