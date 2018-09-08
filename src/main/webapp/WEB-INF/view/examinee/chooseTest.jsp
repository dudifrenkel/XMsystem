<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="he">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<head>

</head>
<body dir="rtl">


<h1> היי ${examinee.firstName}, אנא בחר מבחן: </h1>

<form:form method="post" modelAttribute="examinee" action="begin">
    <p> מבחן: <form:select path="currTest">
        <c:forEach items="${tests}" var="test">
            <form:option value="${test.id}" label="${test.description}"></form:option>
        </c:forEach>
    </form:select></p>

    <button type="submit" name="הרשם"> התחל מבחן! </button>
</form:form>

</body>

</html>