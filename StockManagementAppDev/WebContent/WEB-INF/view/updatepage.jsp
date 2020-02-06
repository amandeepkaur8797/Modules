<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
<style>
.div1 {
  height: 100px;
  width: 100%;
  border: 1px solid #c3c3c3;
  background-color: lightblue;
  text-align: center;
}

.div2 {
  height: 500px;
  width: 100%;
  border: 1px solid #000000;
  background-color: #FFEBCD;
  text-align: center;
}
input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 10px 20px;
  text-decoration: none;
  margin: 2px 1px;
  cursor: pointer;
}
input[type=submit]:hover {
  background-color: #A9A9A9;
}
.a {
  float: left;
  size="100px";
}
</style>
</head>
<body>
<div class="div1">
<h1 align='center'>Update Page</h1>
</div>
<h3 style="color:#00bfff">${msg1 }</h3>
	<h4 align='center'>
<div class="div2">
<br>
<form action='UpdateData' method='post'>
<input type='hidden' name='id' value="${obj.getProductid() }"><br>
Product Name<br>
<input type='text' name='name' value="${obj.getName() }"><br>
Product Category<br>
<input type='text' name='category' value="${obj.getCategory() }"><br>
Product Company<br>
<input type='text' name='company' value="${obj.getCompany() }"><br>
Product Quantity<br>
<input type='number' name='quantity' value="${obj.getQuantity() }"><br>
Product Price<br>
<input type='number' name='price' value="${obj.getPrice() }"><br>
<br>
<input type='submit' value='Update'>
</form>
</h4>
</div>
</body>
</html>