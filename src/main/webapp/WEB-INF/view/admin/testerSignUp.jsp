<!DOCTYPE html>

<html lang="he">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    <head>
        <title> יצירת בוחן חדש </title>
    </head>
    <body dir="rtl" align="right">

    <h1> הוספת בוחן חדש </h1>
    <hr>
    
    <form action="addTester" method="post">
        <p> שם משתמש: <form:input type="text" path="tester.userName" placeholder="הכנס שם משתמש"/></p>

        <p> סיסמה: <form:input type="password" path="tester.password" placeholder="הכנס סיסמה"/></p>

        <c:forEach items="${tests}" var="test">
            <form:checkbox path="tester.tests" value="${test.key}" label="${test.value}"></form:checkbox>
        </c:forEach>

        <br><br>
        <input type="submit" value="צור"/>
    </form>
    </body>
</html>