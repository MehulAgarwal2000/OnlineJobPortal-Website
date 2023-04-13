<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login-In</title>
<%@include file="component/allcss.jsp" %>
</head>
<body>
<%@include file="component/nav.jsp" %>
<div class="container-fluid">
<div class="row-5">
<div class="col-md-4 offset-md-4">
<div class="card">
<div class="text-center">
<i class="fa-solid fa-user"></i>
<h4>Log-In</h4>
</div>
<c:if test="${not empty msg }">
<h3 class="text-center text-danger">${msg }</h3>
<c:remove var="msg"/>
</c:if>
<form action="login" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Enter email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password"> 
  </div>
  <button type="submit" class="btn btn-primary">login</button>
</form>
</div>
</div>
</div>
</div>
</body>
</html>