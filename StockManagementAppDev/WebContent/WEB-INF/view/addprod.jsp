<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
<style type="text/css">
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
<h2 align="center">Add Product</h2>
</div> 
<br>
${dto1 }
<h4 align="center">
<div class="div2">
<form action="addData" method="post">
<pre>
Product Name<br>
<input type="text" name="name" required><br>
Category<br>
<input type="text" name="category" required><br>
Company Name<br>
<input type="text" name="company" required><br>
Quantity<br>
<input type="number" name="quantity" required><br>
Price<br>
<input type="number" name="price" required><br>
<br>
<input type="submit" value="Add Product">
</pre>
</form>
</div>
</body>
</html>