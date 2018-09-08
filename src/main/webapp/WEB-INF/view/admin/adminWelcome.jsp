<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<html>
<head>
   <title> איזור ניהול </title>
</head>
<body dir="rtl">
<h1> איזור ניהול </h1>
<hr>

<h2> <a href="/admin/manageUsers"> ניהול משתמשים </a> </h2>

<br><br>

<h2> <a href="/admin/manageTests"> ניהול מבחנים </a> </h2>

<form:form action="${path}/logout" method="post">
   <input type="submit" value="התנתק"/>
</form:form>

</body>

</html>