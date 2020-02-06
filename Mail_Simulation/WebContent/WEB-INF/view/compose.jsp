<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
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
<ul>
<li><b><a href="inbox">Inbox</a><b></li>
<li><b><a href="sent">Sent</a><b></li>
<li><b><a href="draft">Draft</a><b></li>
<li><b><a href="deleteitem">Delete Items</a><b></li>
<li><b><a href="compose">Compose</a><b></li>
<li><b><a href="logout">Logout</a><b></li> 
</ul>
<br>
<div class="div1">
<h2 style="text-align:center">Compose Message</h2>
</div>
<br>
<div class="div2">
<h4 align="center">
<form action="composeData" method="post"><br>
To<br>
<input type="email" name="To" required><br>
Subject<br>
<input type="text" name="Subject" required><br>
Message<br>
<input type="text" style="height:150px;" name="Message" required><br>
<br><br>
<input type="submit" value="Send">
</form>
</div>
</body>
</html>