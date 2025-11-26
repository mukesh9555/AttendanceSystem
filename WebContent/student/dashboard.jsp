<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Student" %>
<%
  Student s = (Student) session.getAttribute("student");
  if (s == null) {
    response.sendRedirect("../login.jsp");
    return;
  }
%>
<!doctype html>
<html>
<head><title>Student Dashboard</title></head>
<body>
  <h2>Hello, <%= s.getName() %></h2>
  <p>Your roll: <%= s.getRollNo() %></p>
  <p><a href="../index.jsp">Home</a></p>
</body>
</html>
