<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html lang="he">
    <head>
        <title>רישום נבחן</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

        <style>
            .error{color: red; font-size: 70%;}
        </style>
    </head>
    <body dir="rtl" align="right">
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

            <div align="right" style="margin-top:100px">
                <h1 align="center">רישום נבחן חדש</h1>
                <hr>

                    <%--<div class="container" dir="rtl" align="right">--%>

                <form:form method="post" action="add" modelAttribute ="examinee" style="margin-right: 100px">
                    <div class="form-group">
                        <label for="taz"> מספר תעודת זהות: </label>
                        <form:input path="taz" placeholder="הכנס ת.ז" id="taz"/>
                        <small class="form-text text-muted"> יש להכניס 9 ספרות </small>
                            <form:errors path="taz" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label for="firstName"> שם פרטי:</label>
                        <form:input path="firstName" placeholder="הכנס שם פרטי"/>
                            <form:errors path="firstName" cssClass="error"/>
                    </div>

                    <div class="form-group">
                        <label for="lastName">שם משפחה:</label>
                        <form:input path="lastName" placeholder="הכנס שם משפחה"/>
                            <form:errors path="lastName" cssClass="error"/>
                    </div>

                    <div class="form-group">
                        <label for="date">תאריך לידה:</label>
                        <form:input type="date" path="birthDate" placeholder="הכנס תאריך לידה"/>
                            <form:errors path="birthDate" cssClass="error"/>
                    </div>

                    <div class="form-group">
                        <label for="sex">מין:</label>
                        <form:radiobutton value="M" path="sex" label="זכר" checked="checked" />
                        <form:radiobutton value="F" path="sex" label="נקבה"/>
                    </div>

                    <div class="form-group">
                        <label for="currTester"> בוחן:</label>
                        <form:select path="currTester">
                            <c:forEach items="${testers}" var="tester">
                                <form:option value="${tester.key}" label="${tester.value}"></form:option>
                            </c:forEach>
                        </form:select>
                    </div>

                        <form:button type="submit" class="btn btn-outline-info">הרשם</form:button>
                    </div>
                </form:form>
            </div>
        </div>
    </body>
</html>