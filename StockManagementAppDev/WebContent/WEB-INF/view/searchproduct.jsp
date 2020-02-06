<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
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
<h1 align='center'>Search Page</h1>
</div>
<br>
<div class="div2">
<h3 align="center">
<form action="searchdata" method="post">
<input type="search" name="search" placeholder="Search..">
<input type="submit" value="Search">
</form>
</h3>
</div>
</body>
</html>