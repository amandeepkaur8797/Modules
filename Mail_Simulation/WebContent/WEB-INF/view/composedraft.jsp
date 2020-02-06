<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.div2 {
  height: 600px;
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
<div class="div2">
<h4 align="center">
<form action="composedraftData" method="post">
<pre>
<input type="hidden" name="Id" value="${From_id.getId() }"><br>
To
<input type="email" name="To" value="${From_id.getSentto() }" required><br>
Subject
<input type="text" name="Subject" value="${From_id.getSubject() }" required><br>
Message
<input type="text" name="Message" style="height:150px;" value="${From_id.getMessage() }" required><br>
<br><br>
<input type="submit" value="SendMail">
</pre>
</form>
</div>
</body>
</html>