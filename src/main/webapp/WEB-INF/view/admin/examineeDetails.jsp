
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<html>
<head>
   <title> פרטי נבחן </title>
</head>
<body dir="rtl">
<h1> מבחנים ש${name} ביצע/ה: </h1>
<hr>

<c:forEach items="${tests}" var="test">
    <h2> שם המבחן: ${test.description} </h2>
    <h4> נעשה ב- ${test.date}</h4>
    <br>
    <table border="1" align="center">
        <thead>
        <tr>
            <td>תיאור השאלון</td>
            <td>מספר שאלות כולל</td>
            <td>מספר שאלות נכונות</td>
        </tr>
        </thead>

            <c:forEach items="${test.questionnaireResponses}" var="questionnaireRes">
                <tr>
                    <td>${questionnaireRes.description}</td>
                    <td>${questionnaireRes.totalQuestion}</td>
                    <td>${questionnaireRes.correctQuestion}</td>
                </tr>
            </c:forEach>

    </table>
    <p align="center"> הערות: ${test.notes} </p>
</c:forEach>


<br>
<hr>
<a href="${path}/admin/manageUsers"> חזרה לניהול משתמשים </a><br>
</body>

</html>