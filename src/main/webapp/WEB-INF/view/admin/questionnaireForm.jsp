<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="he">
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


        <form:form id="addQues" action="addQuestionnaire" method="post" onsubmit="return checkNum()" modelAttribute="questionnaire">
            <p> תיאור השאלון: <form:input id="body" type="text" path="description"  placeholder="הכנס תיאור"/></p>

            <p> אורך השאלון בדקות: <form:input id="dur" name="dur" type="text" path="durationMin" placeholder="הכנס את אורך השאלון"/>

            <div> אנא בחר את השאלות בטופס:
                <br><br>
            <c:forEach items="${questions}" var="question">
                <form:checkbox path="questions" value="${question.key}" label="${question.value}"></form:checkbox>
            </c:forEach>
            </div>
            <br><br>
            <form:button type="submit"> צור שאלון </form:button>
        </form:form>
    </body>
</html>