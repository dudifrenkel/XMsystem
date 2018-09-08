
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
   <title> ניהול מבחנים </title>
</head>
<body dir="rtl">
<h1> ניהול מבחנים </h1>
<hr>

<h2> מבחנים </h2>

<p ><table border=1 bgcolor="#e6e6fa">

    <thead>
    <tr>
        <td>ID</td>
        <td>תיאור המבחן</td>
        <%--<td>עריכת מבחן</td>     //Todo: future feature--%>
        <td>מחיקת מבחן</td>
    </tr>
    </thead>
    <c:forEach var="test" items="${tests}">
    <tr>
        <td>${test.id}</td>
        <td>${test.description}</td>
        <%--<td> <a name="del" href="editTest/${test.id}"> עריכה </a></td>  //Todo: future feature--%>
        <td> <a name="del" href="deleteTest/${test.id}"> מחיקה </a></td>
    </tr>
    </c:forEach>
</table>
</p>
<%--Todo: create test controller and jsp --%>
<a href="/admin/createTest"> צור מבחן חדש </a>

<br><br>

<h2> שאלונים </h2>

<p ><table border=1 bgcolor="#e6e6fa">

    <thead >
    <tr>
        <b>
        <td> ID </td>
        <td> תיאור השאלון </td>
        <td> זמן השאלון בדקות </td>
        <%--<td> עריכת שאלון </td>  //TODO: future feature --%>
        <td> מחיקת שאלון </td>
        </b>
    </tr>
    </thead>

    <c:forEach var="questionnaire" items="${questionnaires}">
        <tr>
            <td>${questionnaire.id}</td>
            <td>${questionnaire.description}</td>
            <td>${questionnaire.durationMin}</td>
            <%--<td> <a name="editQuestionnaire" href="editQuestionnaire/${questionnaire.id}"> עריכה </a></td> //TODO: future feature --%>
            <td> <a name="delQuestionnaire" href="deleteQuestionnaire/${questionnaire.id}"> מחיקה </a></td>
        </tr>
    </c:forEach>

</table>
</p>
<a href="/admin/createQuestionnaire"> צור שאלון חדש </a>


<br><br>

<h2> שאלות </h2>

<p ><table border=1 bgcolor="#e6e6fa">

    <thead >
    <tr>
        <td> ID </td>
        <td>תיאור השאלה </td>
        <%--<td> עריכת השאלה </td>  Todo: extra feature --%>
        <td> מחיקת השאלה </td>
    </tr>
    </thead>

    <c:forEach var="question" items="${questions}">
        <tr>
            <td>${question.id}</td>
            <td>${question.body}</td>
            <%--<td> <a name="editQuestion" href="editQuestion/${questionnaire.id}"> עריכה </a></td>  Todo: extra feature--%>
                <%--Todo: deleting test controller and jsp --%>
            <td> <a name="delQuestion" href="deleteQuestion/${question.id}"> מחיקה </a></td>
        </tr>
    </c:forEach>

</table>
</p>
<a href="/admin/createQuestion"> צור שאלה חדשה </a>

<br>
<hr>
<a href="${path}/admin/adminsEntrance"> חזרה לאיזור הניהול </a><br>
</body>
</html>