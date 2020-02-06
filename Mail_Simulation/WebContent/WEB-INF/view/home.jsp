<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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
<body>
<br>
<div  class="div1">
<h2 style="text-align:center">Mail Simulation</h2><br><br>
</div>
<br>
<marquee><u><b style="color:#993366" align="center">${data.getName() }<b></u></marquee><br><br>
<ul>
<li><b><a href="inbox">Inbox</a><b></li> 
<li><b><a href="sent">Sent</a><b></li> 
<li><b><a href="draft">Draft</a><b></li> 
<li><b><a href="deleteitem">Delete Item</a><b></li> 
<li><b><a href="compose">Compose</a><b></li> 
<li><b><a href="logout">Logout</a><b></li> 
</ul>
${msg1 }
${msg }
</body>
</html>