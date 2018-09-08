<!DOCTYPE html>

<html lang="he">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="path" value="${pageContext.request.contextPath}"></c:set>


    <head>
        <title> תם המבחן </title>

        
    </head>
    <body dir="rtl">

    <div align="center"> המבחן הסתיים, בהצלחה ${name}
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
