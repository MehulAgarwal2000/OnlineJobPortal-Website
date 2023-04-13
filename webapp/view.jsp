<%@page import="com.entity.job"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.dao.jobDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view jobs</title>
<%@include file="component/allcss.jsp" %>
</head>
<body>
<c:if test="${userobj.role ne 'admin' }">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
<%@include file="component/nav.jsp" %>
<div class="container">
<div class="row">
<div class="col-md-12">
<h4 class="text-center text-primary">ALL JOBS</h4>
<c:if test="${not empty msg }">
<div class="alert alert-primary" role="alert">
  ${msg}
</div>
<c:remove var="msg"/>
</c:if>

<%
jobDAO dao=new jobDAO(DBconnect.getConn());
List<job> list=dao.getJob();
for(job j:list)
{%>
	<div class="card mt-2">
<div class="card-body">
<div class="text-center text-primary">
<i class="fa-solid fa-clipboard"></i>
</div>
<h3><%=j.getTitle() %></h3>
<p><%=j.getDescription() %></p>
<br>
<div class="form-row">
<div class="form-group col-md-3">
<input type="text" class="form-control form-control-sm" value="LOCATION:<%=j.getLocation() %>" readonly>
</div>
<div class="form-group col-md-3">
<input type="text" class="form-control form-control-sm" value="ROLE:<%=j.getCatergory()%>" readonly>
</div>
</div>
<h6>PUBLISH DATE:<%=j.getPdate() %></h6>
<div class="text-center">
<a href="editjob.jsp?id=<%=j.getId() %>" class="btn btn-sm bg-success text-white">edit</a>
<a href="delete?id=<%=j.getId() %>" class="btn btn-sm bg-success text-white">delete</a>
</div>
</div>
</div>
<%}
%>

</div>
</div>
</div>
</body>
</html>