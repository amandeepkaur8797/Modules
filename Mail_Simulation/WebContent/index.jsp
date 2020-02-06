<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{

background: url("https://media3.giphy.com/media/G3FEbeJJtPnwc/200w.webp?cid=790b7611023c55609468f98c559c1e87cda8aeaff603f46b&rid=200w.webp");

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

/* Change the link color to #111 (black) on hover */
li a:hover {
  background-color: #A9A9A9;
}
div {
  height: 200px;
  width: 100%;
  background-color: lightblue;
}
</style>
</head>

<body>
<div style="background-color:lightblue" width:50px; height:100px; >
<marquee><h1 style="text-align:center" "margin-top: 10px">Welcome to Mail Simulation</h1><br><br></marquee>
</div><br>
<!-- <div style="background-color:lightgrey" height:20px; width:20px;>  -->
<ul>
<li><b><a href="registration">Registration</a><b></li> |
<li><b><a href="login">Login</a><b></li>
</ul>


<!-- </div> -->
</body>
</html>