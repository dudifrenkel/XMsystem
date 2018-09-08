<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>

    <c:url value="/css/main.css" var="jstlCss" />
    <%--<c:url value="webapp/resources/main.css" var="jstlCss" />--%>
    <link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

<div class="container" align="right">

    <div align="center" class="starter-template" >
        <h1>XM ברוכים הבאים למערכת</h1>
        <h2>,נבחן יקר</h2>
    </div>

    <p>להרשמה אנא לחץ <a href="regPage"> כאן</a> </p>
</div>

</div>

<%--<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

</body>

</html>
