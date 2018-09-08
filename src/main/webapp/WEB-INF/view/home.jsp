<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <style>
        body {
            padding-top: 100px;
        }
        .logo{
            padding-top: 30px;
            padding-right: 300px;
        }
        .nav-link{
            color: #95C7D8;
        }
        /*.row{*/
            /*padding-top: 100px;*/
        /*}*/
        /*h1{*/
            /*color: blue;*/
            /*font-family: Aharoni;*/
            /*font-size: 60px;*/
        /*}*/
        /*.examinees{*/
            /*color: #FF0000;*/
        /*}*/
    </style>

</head>
<body dir="rtl">
<div>
    <div class="container">
        <nav class="navbar navbar-expand-sm bg-white navbar-white fixed-top">
            <!-- Brand/logo -->
            <a class="navbar-brand" href="/">
                <img src="images/xmlogo.jpg" alt="logo" style="width:60px;">
            </a>

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="examinee/examineeEntrance"> נבחנים </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="admin/adminsEntrance"> ניהול </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/"> אודות </a>
                </li>
            </ul>
        </nav>
    </div>

    <div class="container">
        <div class="head">
            <div class="text-center display-1">
                ברוכים הבאים למערכת XM
            </div>
        </div>

        <div class="row" align="center">
            <div class="logo">
                <img src="/images/xm.jpg" style="width:500px;">
            </div>
        </div>

        <div class="row">
            <div class="text-right display-4">
                <a href="examinee/examineeEntrance"  class="btn btn-outline-info" role="button" aria-pressed="true">
                    <h3>
                        כניסת נבחנים
                    </h3>
                </a>
                    <%--#95C7D8--%>
            </div>
        </div>


        <div class="fixed-bottom ">
            <a class="btn btn-outline-info" role="button" aria-pressed="true" href="admin/adminsEntrance">
                <h4>
                כניסת מנהלים
                </h4>
            </a>
        </div>
    </div>
</div>
</body>

</html>
