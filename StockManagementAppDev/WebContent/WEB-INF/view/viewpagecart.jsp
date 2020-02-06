<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Page Cart</title>
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
</style>
</head>
<body>
<div class="div1">
<h1 align="center">Products</h1>
</div>
<br>
<div class="div2">
<br>
<table align='center' border="1px" style="text-align:center;">
    <tr>
      <th>Product Name</th>
      <th>Product Company</th>
      <th>Product Category</th>
      <th>Total Price</th>
      <th>Total Price with gst</th>
     <!--  <th>Modify</th>
       <th>Add to Cart</th> -->
      </tr>
       <c:forEach var="list" items="${list }">
       <tr>
      <td> <c:forEach var="list2" items="${list.getPlist() }"> ${list2.getName() }</c:forEach></td>
      
      <td> <c:forEach var="list2" items="${list.getPlist() }"> ${list2.getCompany() }</c:forEach></td>
      
      <td> <c:forEach var="list2" items="${list.getPlist() }"> ${list2.getCategory() }</c:forEach></td>
       
     <td><center>${list.getTotal_price()}</center></td>
      <td><center>${list.getTotal_price_with_gst()}</center></td> 
     
     </tr>
     
       </c:forEach>
        </table>
</div>     
</body>
</html>