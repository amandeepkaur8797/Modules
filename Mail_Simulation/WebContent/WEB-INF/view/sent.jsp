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
${msg }
<div class="div1">
<h1 style="text-align:center">Sent Mails</h1>
</div>
<br>
<div class="div2">
<br>
<table border="1px" style="text-align:center;" align="center">
    <tr>
      <th>Send to</th>
      <th>Subject</th>
      <th>Delete Mail</th>
      
      </tr>
      <c:forEach var="alist" items="${From_id }">
      <tr>
        <td><c:out value="${alist.getSentto() }"/></td>
       <td><a href="mail?id=+${alist.getId() }+"><c:out value="${alist.getSubject() }"/></a></td>
         <td><a href="sentdelete?id=+${alist.getId() }+">Delete</a></td>
        </tr>
        </c:forEach>
</table>
</div>
</body>
</html>