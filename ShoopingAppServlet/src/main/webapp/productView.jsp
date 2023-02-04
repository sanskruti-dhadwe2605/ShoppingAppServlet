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
<body style="background-color:blanchedalmond;">
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
        <h1>welcome to the dashboard</h1>
                  

<%!String str=null; %>
<div style="margin: 10%; background-color: white;padding: 10px;">
<form action="DashboardController">
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Product Id</label>
  <input type="text" class="form-control" name="prodId" >
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Product Name</label>
  <input type="text" class="form-control" name="prodName" >
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Product Price</label>
  <input type="text" class="form-control" name="prodPrice" >
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Product Quantity</label>
  <input type="text" class="form-control" name="prodQty" >
</div>
<input type="submit" name="set" value="create">

<%
  str= (String)session.getAttribute("msg");
		  session.invalidate();
%>
<h3><%=str %></h3>
</div>
    </div>
</form>
</div>

</body>
</html>