<!DOCTYPE html>

<html lang="he">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="path" value="${pageContext.request.contextPath}"></c:set>


    <head>
        <title> יצירת מנהל חדש </title>
    </head>
    <body dir="rtl" align="right">

    <h1> הוספת מנהל חדש </h1>
    <hr>

            <form:form method="post" action="addAdmin" modelAttribute ="admin" >
            <p> שם משתמש <form:input path="userName" placeholder="הכנס שם משתמש"/></p>
            <p> סיסמה <form:input type="password" path="password" placeholder="הכנס סיסמה"/></p>

            <form:button value="addAdmin"> הוסף </form:button>
        </form:form>


    </body>
</html>