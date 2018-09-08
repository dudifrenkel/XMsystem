<!DOCTYPE html>

<html lang="he">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    <head>
        <title> יצירת טופס חדש </title>

        <script>
            function checkNum()
            {
                var x = document.getElementById("dur").value;
                var y = document.getElementById("body").value;
                if (!y){
                    alert("יש להכניס תיאור");
                    return false;
                }
                if (isNaN(x) || !x || x>300 || x<1) {
                    alert("יש להכניס לאורך השאלון מספר בין 1 ל-300");
                    return false;
                }
                return true;
            }
        </script>

    </head>
    <body dir="rtl" align="right">

    <h1> הוספת טופס חדש </h1>
    <hr>


    <form id="addQues" action="addQuestionnaire" method="post" onsubmit="return checkNum()">
        <p> תיאור השאלון: <form:input id="body" type="text" path="questionnaire.description"  placeholder="הכנס תיאור"/></p>

        <p> אורך השאלון בדקות: <form:input id="dur" name="dur" type="text" path="questionnaire.durationMin" placeholder="הכנס את אורך השאלון"/>

        <div> אנא בחר את השאלות בטופס:
            <br><br>
        <c:forEach items="${questions}" var="question">
            <form:checkbox path="questionnaire.questions" value="${question.key}" label="${question.value}"></form:checkbox>
        </c:forEach>
    </div>
        <br><br>
        <input type="submit" value="צור שאלון"/>
    </form>
    </body>
</html>