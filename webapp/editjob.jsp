<%@page import="com.entity.job"%>
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
<title>Edit-Job</title>
<%@include file="component/allcss.jsp" %>
</head>
<body>
<%@include file="component/nav.jsp" %>
<div class="container p-2">
<div class="col-md-10 offset-md-1">
<div class="card">
<div class="card-body">
<div class="text-center">
<%
int id=Integer.parseInt(request.getParameter("id"));
jobDAO dao=new jobDAO(DBconnect.getConn()) ;
job j=dao.getJobBYId(id);
%>


<h4>EDIT JOBS</h4>
</div>
<form action="update" method="post">
<input type="hidden" value=<%=j.getId() %> name="id">

  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputtext4">ENTER TITLE</label>
      <input type="text" class="form-control" id="inputEmail4" placeholder="title" name="title" value="<%=j.getTitle() %>">
    </div>
  </div>
  <div class="form-row">
     <div class="form-group col-md-4">
      <label for="inputLocation">LOCATION</label>
      <select id="inputLocation" class="form-control" name="location">
        <option value="<%=j.getLocation() %>"><%=j.getLocation() %></option>
        <option value="Odisha">Odisha</option>
        <option value="bangalore">Bangalore</option>
        <option value="Chennai">Chennai</option>
        <option value="Kolkata">Kolkata</option>
        <option value="Pune">Pune</option>
      </select>
    </div>
    <div class="form-group col-md-4">
      <label for="inputRole">ROLE</label>
      <select id="inputRole" class="form-control" name="catergory"> 
        <option value=<%=j.getCatergory() %>><%=j.getCatergory() %></option>
        <option value="ITManager">IT Manager</option>
        <option value="DevOpsEngineer">DevOps Engineer</option>
        <option value="SoftwareDeveloper\">Software Developer</option>
        <option value="DataScientist">Data Scientist</option>
        <option value="JavaDeveloper">Java Developer</option>
      </select>
    </div>
    
    
    <div class="form-group">
    <label>ENTER DESCRIPTION</label>
    <textarea rows="6" cols="" class="form-control" name="desc"><%=j.getDescription() %></textarea>
    </div>
  </div>
  <button type="submit" class="btn btn-primary">update job</button>
</form>
</div>
</div>
</div>
</div>
</body>
</html>