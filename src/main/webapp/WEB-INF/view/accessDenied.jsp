<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <title> הגישה נדחיתה </title>
</head>
<body>
    <h2> הגישה נדחיתה - אינך מורשה לצפות בעמוד זה </h2>
    <hr>
    <a href="${path}/home"> חזרה לעמוד הראשי </a>
</body>
</html>
