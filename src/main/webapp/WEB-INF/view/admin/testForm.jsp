<!DOCTYPE html>

<html lang="he">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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


    <form id="addTest" action="addTest" method="post" onsubmit="return fieldValidation()">
        <p> תיאור המבחן: <form:input id="des" type="text" path="test.description"  placeholder="הכנס תיאור"/></p>

        <div> אנא בחר את השאלונים במבחן:
            <br><br>
        <c:forEach items="${questionnaires}" var="questionnaire">
            <form:checkbox path="test.questionnaires" value="${questionnaire.key}" label="${questionnaire.value}"></form:checkbox>
        </c:forEach>
    </div>
        <br><br>
        <input type="submit" value="צור שאלון"/>
    </form>
    </body>
</html>