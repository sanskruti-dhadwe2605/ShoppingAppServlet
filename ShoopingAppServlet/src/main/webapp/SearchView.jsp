<%@page import="Linkcode.shop.admin.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>

<body style="background-color: blanchedalmond;">
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
        

<div style="margin: 10%; background-color: white;padding: 10px;">
<form action="SearchController">
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Product Id for search...</label><br>
  <input type="text" class="form-control" name="prodId" ><br>
  <input type="submit" name="search" value="Search">
  
  
</div>
</form>
<%!
List<Product> lst=null;
Product prod=null;
%>
<%
Object o=session.getAttribute("prod");
if(o instanceof List){
	lst=(List<Product>)o;
	session.invalidate();
	if(lst!=null){
		prod=lst.get(0);
		lst=null;
%>
<table border="3px" style="margin: 10px">
		<tr style="margin: 10px; padding: 10px;">
			<td style="margin: 10px; padding: 10px;"><%=prod.getProdId()%></td>
			<td style="margin: 10px; padding: 10px;"><%=prod.getProdName()%></td>
			<td style="margin: 10px; padding: 10px;"><%=prod.getProdPrice()%></td>
			<td style="margin: 10px; padding: 10px;"><%=prod.getProdQty()%></td>
		</tr>
	</table>
	<%
	}
	} else {
	String str = (String) o;
	out.println(str);
	}
	%>
		
</div>
</div>
</div>


</body>
</html>