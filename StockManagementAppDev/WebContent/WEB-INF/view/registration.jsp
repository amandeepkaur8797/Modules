<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<h1 align="center">Registration page</h1>
</div>
<br>
${dto }
<div class="div2">
<br>
<h4 align="center">
<form action="registrationData" method="post">
<pre>
User Name<br><input type="text" name="Username" required><br>
Email<br><input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" name="email" title="Email must contain '@' and '.' " required ><br>
Password<br><input type="password" name="password" required><br>
Contact<br><input type="tel" name="contact" required><br>
<input type="submit" value="Register"><br>
<a href="login">Login</a>
</pre>
</form>
</div>
</h4>
</body>
</html>