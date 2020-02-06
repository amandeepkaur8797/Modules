<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.div1 {
  height: 200px;
  width: 100%;
  border: 1px solid #c3c3c3;
  background-color: lightblue;
  text-align: center;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
  
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #A9A9A9;
}

</style>
</head>
<body>
<div class="div1">
<h1>Welcome to Stock App</h1>
</div>
<marquee><h2 style="color:#00bfff">${dto.getUsername() }</h2></marquee>
<h3 style="color:#00bfff">${msg1 }</h3>

${msg }
${dto1 }
<ul>
<li><b><a href="addproduct">Add Product</a><b></li>
<li><b><a href="search">Search Products</a><b></li>
<li><b><a href="viewproducts">View Products</a><b></li>
<li><b><a href="logout">Logout</a></h3><b></li>
</ul>
</body>
</html>