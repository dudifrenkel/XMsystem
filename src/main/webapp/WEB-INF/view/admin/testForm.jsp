<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="he">
    <head>
        <title> יצירת טופס חדש </title>

        <script>
            function fieldValidation()
            {
                var x = document.getElementById("des").value;
                if (!x){
                    alert("יש להכניס תיאור למבחן");
                    return false;
                }
                return true;
            }
        </script>

    </head>
    <body dir="rtl" align="right">

    <h1> הוספת טופס חדש </h1>
    <hr>


    <form:form id="addTest" action="addTest" method="post" onsubmit="return fieldValidation()" modelAttribute="test">
        <p> תיאור המבחן: <form:input id="des" type="text" path="description"  placeholder="הכנס תיאור"/></p>

        <div> אנא בחר את השאלונים במבחן:
            <br><br>
            <c:forEach items="${questionnaires}" var="questionnaire">
                <form:checkbox path="questionnaires" value="${questionnaire.key}" label="${questionnaire.value}"></form:checkbox>
            </c:forEach>
        </div>
        <br><br>
        <form:button type="submit"> צור שאלון </form:button>
    </form:form>
    </body>
</html>