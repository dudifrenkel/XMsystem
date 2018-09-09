<!DOCTYPE html>

<html lang="he">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="path" value="${pageContext.request.contextPath}"></c:set>


    <head>
        <title> תם המבחן </title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>

    <body dir="rtl">
    <div class="container">
        <nav class="navbar navbar-expand-sm bg-white navbar-white fixed-top">
            <!-- Brand/logo -->
            <a class="navbar-brand" href="/">
                <img src="${path}/images/xmlogo.jpg" alt="logo" style="width:60px;">
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

    <div align="center" style="margin-top: 100px">
         המבחן הסתיים, בהצלחה ${name}
        <br><br>
        <a href="/"> סיום </a>
    </div>
    </body>
</html>







<%--<form method="post" action="processQnnaire" id="qnnaireForm" name="qnnaireForm">--%>
    <%--&lt;%&ndash;modelAttribute ="questionnaireRes">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<c:forEach items="${currQuestions}" var="question">&ndash;%&gt;--%>
    <%--<c:forEach items="${currQnnaire.questions}" var="question">--%>

        <%--&lt;%&ndash;<jsp:useBean id="newExamineeAnswer" class="com.XMsystem.Model.ExamineeAnswer" scope="request"/>&ndash;%&gt;--%>
        <%--<div>--%>
            <%--<p>${question.body}</p>--%>
                <%--&lt;%&ndash;<radiobutton value="${answer.id}" path="${ans}" label="${answer.content}"/>&ndash;%&gt;--%>
            <%--<div name="answers" id="question.id">--%>
                <%--<c:forEach items="${question.answers}" var="answer">--%>
                    <%--<input type="radio" name="aa" value="${answer.id}"> ${answer.content}--%>
                    <%--&lt;%&ndash;<input type="radio"> ${answer.content}&ndash;%&gt;--%>
                <%--</c:forEach>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</c:forEach>--%>

    <%--<br><br>--%>
    <%--<button type="submit" id="subBtn" > הגש טופס </button>--%>
<%--</form>--%>


<%--</body>--%>
<%--</html>--%>
