<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<h1 align="center">Forgot Password</h1><br>
</div>
${msg1 }
<h4 align="center">
<div class="div2">
<br>
<form action="forgetPassword" method="post">
Email:<input type="text" name="email">
<h1>Security Validation</h1><br>
<select name="Question">
<option value="Question">Question</option>
<option value="What is your eye color?">What is your eye color?</option>
<option value="What is your favourite food?">What is your favourite food?</option>
<option value="What is your lucky number?">What is your lucky number?</option>
<option value="What is your birth year?">What is your birth year?</option>
</select><br>
<h2>Answer</h2><br>
<input type="answer" name="answer" required><br>
<br>
<input type="submit" value="submit">
<br>
<br>
<b><a href="login">Login</a></b>
</pre>
</form>
</div>
</body>
</html>