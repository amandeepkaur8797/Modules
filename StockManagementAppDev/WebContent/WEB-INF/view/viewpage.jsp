<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Page</title>
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
      <th>Product Price</th>
      <th>Quantity</th>
      <th>Modify</th>
       <th>Add to Cart</th>
      </tr>
      <c:forEach var="list" items="${l }">
      <tr>
        <td><c:out value="${list.getName() }"/></td>
          <td><c:out value="${list.getCompany() }"/></td>
           <td><c:out value="${list.getCategory() }"/></td>
            <td><c:out value="${list.getPrice() }"/></td>
             <td><c:out value="${list.getQuantity() }"/></td>
              
      
       <td><a href="edit?id=+${list.getProductid() }+">Modify</a></td>
         <td><a href="addtocart?id=${list.getProductid() }">Add to Cart</a></td>
        </tr>
        </c:forEach>
</table>
<br>      
<b><h3 align="center"><a href="mycart" >My Cart</a></h3></b> 
</div>       
</body>
</html>