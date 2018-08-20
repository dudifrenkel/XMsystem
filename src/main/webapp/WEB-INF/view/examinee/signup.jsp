<!DOCTYPE html>

<html lang="he">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="path" value="${pageContext.request.contextPath}"></c:set>


    <head>
        <title>רישום נבחן</title>
    </head>
    <body>

        <form:form method="post" action="add" modelAttribute ="examinee" >
            <p>מספר תעודת זהות: <form:input path="taz" placeholder="הכנס ת.ז"/></p>
            <p>שם פרטי: <form:input path="firstName" placeholder="הכנס שם פרט"/></p>
            <p>שם משפחה: <form:input path="lastName" placeholder="הכנס שם משפחה"/></p>
            <p>תאריך לידה: <form:input path="birthDate" placeholder="הכנס תאריך לידה"/></p>
            <p> מין: <form:select name="sex" id="" path="sex">
                <form:option value="M" name="זכר"/>
                <form:option value="F" name="נקבה"/></p>
            </form:select>
            <form:button value="sign" name="הרשם">הרשם</form:button>
        </form:form>

        <p> מבחן: <form:select path="tests">
            <c:forEach items="${tests}" var="test">
                <form:option name="${test.id}" value="${test.description}"></form:option>
            </c:forEach>
        </form:select></p>


    </body>
</html>