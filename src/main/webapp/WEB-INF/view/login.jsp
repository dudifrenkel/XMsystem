<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html lang="he">
<head>
    <title> התחברות </title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>

<body dir="rtl">
    <h3> התחברות למנהלים </h3>
    <form:form action="${path}/authTheUser" method="post">

        <c:if test="${param.error != null}">
            <i class="error"> שם משתמש / סיסמה שגויים </i>
        </c:if>

        <p>
            שם משתמש: <input type="text" name="username"/>
        </p>

        <p>
            סיסמה: <input type="password" name="password"/>
        </p>
        <input type="submit" value="התחבר">
    </form:form>
</body>
</html>