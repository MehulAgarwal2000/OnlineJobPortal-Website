<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-Up</title>
<%@include file="component/allcss.jsp" %>
</head>
<body>
<%@include file="component/nav.jsp" %><div class="container-fluid">
<div class="row-5">
<div class="col-md-4 offset-md-4">
<div class="card">
<div class="text-center">
<i class="fa-solid fa-user-plus"></i>
<h4>Sign-Up</h4>
</div>
<c:if test="${not empty msg }">
<div class="alert alert-primary" role="alert">
  ${msg}
</div>
<c:remove var="msg"/>
</c:if>

<form action="signup" method="post">

   <div class="form-group">
    <label for="exampleInputName1">Enter Name</label>
    <input type="text" class="form-control" id="exampleInputName1"  placeholder="Enter Name" name="name">
  </div>
  <div class="form-group">
    <label for="exampleInputQualification1">Enter Qualification</label>
    <input type="text" class="form-control" id="exampleInputQualification1"  placeholder="Enter Qualification" name="qua">
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Enter email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="em">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="ps">
  </div>
  <button type="submit" class="btn btn-primary">submit</button>
</form>
</div>
</div>
</div>
</div>



</body>
</html>