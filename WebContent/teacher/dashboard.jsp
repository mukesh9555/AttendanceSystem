<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Teacher" %>
<%
  Teacher t = (Teacher) session.getAttribute("teacher");
  if (t == null) {
    response.sendRedirect("../login.jsp");
    return;
  }
%>
<!doctype html>
<html>
<head><title>Teacher Dashboard</title></head>
<body>
  <h2>Welcome, <%= t.getName() %></h2>
  <a href="mark.jsp">Mark Attendance</a> | <a href="report.jsp">Reports</a>
</body>
</html>
