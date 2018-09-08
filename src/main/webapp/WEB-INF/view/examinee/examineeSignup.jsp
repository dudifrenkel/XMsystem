<!DOCTYPE html>

<html lang="he">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="path" value="${pageContext.request.contextPath}"></c:set>


    <head>
        <title>רישום נבחן</title>

        <style>
            .error{color: red; font-size: 70%;}
        </style>
    </head>
    <body dir="rtl" align="right">

    <h1>רישום נבחן חדש</h1>
    <hr>

        <%--<div class="container" dir="rtl" align="right">--%>

    <form:form method="post" action="add" modelAttribute ="examinee" >
        <p>מספר תעודת זהות: <form:input path="taz" placeholder="הכנס ת.ז"/>
            <form:errors path="taz" cssClass="error"/> </p>

        <p>שם פרטי: <form:input path="firstName" placeholder="הכנס שם פרטי"/>
            <form:errors path="firstName" cssClass="error"/></p>
        <p>שם משפחה: <form:input path="lastName" placeholder="הכנס שם משפחה"/>
            <form:errors path="lastName" cssClass="error"/></p>
        <p>תאריך לידה: <form:input type="date" path="birthDate" placeholder="הכנס תאריך לידה"/>
            <form:errors path="birthDate" cssClass="error"/></p>
        <p> מין: <form:radiobutton value="M" path="sex" label="זכר" checked="checked" />
                <form:radiobutton value="F" path="sex" label="נקבה"/>
                <%--<form:option value="M" label="זכר"/>--%>
                <%--<form:option value="F" label="נקבה"/></p>--%>


        <p> בוחן: <form:select path="currTester">
            <c:forEach items="${testers}" var="tester">
                <%--<form:option value="${tester.id}" label="${tester.userName}"></form:option>--%>
                <form:option value="${tester.key}" label="${tester.value}"></form:option>
            </c:forEach>
        </form:select></p>


        <form:button value="sign" name="הרשם">הרשם</form:button>
    </form:form>














            <%--<form:form method="post" action="add" modelAttribute ="examinee" >--%>
            <%--<p>מספר תעודת זהות: <form:input path="taz" placeholder="הכנס ת.ז"/>--%>
                <%--<form:errors path="taz" cssClass="error"/> </p>--%>

            <%--<p>שם פרטי: <form:input path="firstName" placeholder="הכנס שם פרטי"/>--%>
                <%--<form:errors path="firstName" cssClass="error"/></p>--%>
            <%--<p>שם משפחה: <form:input path="lastName" placeholder="הכנס שם משפחה"/>--%>
                <%--<form:errors path="lastName" cssClass="error"/></p>--%>
            <%--<p>תאריך לידה: <form:input type="date" path="birthDate" placeholder="הכנס תאריך לידה"/>--%>
                <%--<form:errors path="birthDate" cssClass="error"/></p>--%>
            <%--<p> מין: <form:radiobutton value="M" path="sex" label="זכר" checked="checked" />--%>
                <%--<form:radiobutton value="F" path="sex" label="נקבה"/>--%>
                <%--&lt;%&ndash;<form:option value="M" label="זכר"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<form:option value="F" label="נקבה"/></p>&ndash;%&gt;--%>


            <%--<p> בוחן: <form:select path="currTester">--%>
                <%--<c:forEach items="${testers}" var="tester">--%>
                    <%--&lt;%&ndash;<form:option value="${tester.id}" label="${tester.userName}"></form:option>&ndash;%&gt;--%>
                    <%--<form:option value="${tester.key}" label="${tester.value}"></form:option>--%>
                <%--</c:forEach>--%>
            <%--</form:select></p>--%>


            <%--<form:button value="sign" name="הרשם">הרשם</form:button>--%>
        <%--</form:form>--%>



        <%--</div>--%>
    </body>
</html>