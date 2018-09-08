<!DOCTYPE html>

<html lang="he">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="path" value="${pageContext.request.contextPath}"></c:set>


    <head>
        <title> שאלון ${currQnnaire.description} </title>

        <script type="text/javascript">
            var tim;
            <%--var min = '${currQnnaire.durationMin}';--%>
            <%--var sec = '0';--%>

            var min = '0';
            var sec = '10';

            function customSubmit(someValue){
                document.questionForm.minute.value = min;
                document.questionForm.second.value = sec;
                document.questionForm.submit();
            }

            function examTimer() {
                if (parseInt(sec) >0) {

                    document.getElementById("showtime").innerHTML = "הזמן שנותר "+min+":"+sec;
                    sec = parseInt(sec) - 1;
                    tim = setTimeout("examTimer()", 1000);
                }
                else {

                    if (parseInt(min)==0 && parseInt(sec)==0){
                        document.getElementById("showtime").innerHTML = "הזמן שנותר "+min+":"+sec;
                        myAlert();
                        document.qnnaireForm.submit();

                    }

                    if (parseInt(sec) == 0) {
                        document.getElementById("showtime").innerHTML = "הזמן שנותר "+min+":"+sec;
                        min = parseInt(min) - 1;
                        sec=59;
                        tim = setTimeout("examTimer()", 1000);
                    }

                }
            }
            function myAlert()
            {
                var el = document.createElement("div");
                el.setAttribute("style","position:absolute;top:40%;left:50%;background-color:red;font-size:70px;");
                el.innerHTML = "תם הזמן";
                setTimeout(function(){
                    el.parentNode.removeChild(el);
                },2000);
                document.body.appendChild(el);
            }
        </script>
        
        
    </head>
    <body dir="rtl" align="right" onload="examTimer()">


    <h1> שאלון ${currQnnaire.description}  </h1>

    <h2 id="showtime"></h2>

    <hr>

    <form method="post" action="processQnnaire" id="qnnaireForm" name="qnnaireForm">
        <c:forEach items="${currQnnaire.questions}" var="question">
            <fieldset>
                <br>
                <p>${question.body}</p>
                <c:forEach items="${question.answers}" var="answer">
                    <input type="radio" name="${question.id}" value="${answer.id}"> ${answer.content}
                </c:forEach>
                <br>
            </fieldset>
        </c:forEach>
        <br><br>
        <button type="submit" id="subBtn" > הגש טופס </button>
    </form>



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