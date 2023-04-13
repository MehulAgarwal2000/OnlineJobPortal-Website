<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allcss.jsp" %>
<style type="text/css">
.back_img{
background: url("images/top-view-man-using-laptop-footage-086727392_prevstill.webp");
width:100%;
height:85vh;
background-repeat: no-repeat;
background-size: cover;
}
</style>
</head>
<body>
<c:if test="${userobj.role ne 'admin' }">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
<%@include file="component/nav.jsp" %>
<div class="container-fluid back_img">
<div class="text-center">
<h1 class="text-BLACK p-4">WELCOME ADMIN</h1>
</div>
</div>
<%@include file="component/footer.jsp" %>
</body>
</html>