<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html lang="he">
<head>
    <title> בחירת מבחן </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <style>
        /*btn{*/
            /*margin-top: 550px;*/
        /*}*/
        form{
            margin-right: 150px;
            margin-top: 50px;
        }
    </style>
</head>
<body dir="rtl">
<div>
    <div class="container">
        <nav class="navbar navbar-expand-sm bg-white navbar-white fixed-top">
            <!-- Brand/logo -->
            <a class="navbar-brand" href="/">
                <img src="${path}/images/xmlogo.jpg" alt="logo" style="width:60px;">
            </a>

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link disabled" href="#"> נבחנים </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#"> ניהול </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#"> אודות </a>
                </li>
            </ul>
        </nav>
    </div>
    <div class="container" style="margin-top: 100px" align="right">
        <h1> היי ${examinee.firstName}, אנא בחר מבחן: </h1>

        <div id="form">
            <form:form method="post" modelAttribute="examinee" action="begin">
                <form:select class="selectpicker" path="currTest">
                    <c:forEach items="${tests}" var="test">
                        <form:option value="${test.id}" label="${test.description}"></form:option>
                    </c:forEach>
                </form:select>
                <br><br>
                <form:button type="submit" class="btn btn-outline-info" id="btn"> התחל מבחן! </form:button>
            </form:form>
        </div>
    </div>
</div>
</body>

</html>