<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html lang="en">
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="/css/main.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

<%--<nav class="navbar navbar-inverse">--%>
    <%--<div class="container">--%>
        <%--<div class="navbar-header">--%>
            <%--<a class="navbar-brand" href="#">Spring Boot</a>--%>
        <%--</div>--%>

        <%--<div id="navbar" class="collapse navbar-collapse">--%>
            <%--<ul class="nav navbar-nav">--%>
                <%--<li class="active"><a href="/home">Home</a></li>--%>
                <%--<li><a href="/login">About</a></li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    <%--</div>--%>

<%--</nav>--%>

<div class="container" align="right">

    <div align="center" class="starter-template" >
        <h1>XM ברוכים הבאים למערכת</h1>
        <h2>,נבחן יקר</h2>
    </div>

    <p>להרשמה אנא לחץ <a href="examinee/signup"> כאן</a> </p>
</div>

</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
