<!DOCTYPE html>

<html lang="he">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="path" value="${pageContext.request.contextPath}"></c:set>


    <head>
        <title> שאלון ${currQnnaire.description} </title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

        <script type="text/javascript">
            var tim;
            // var min = '0';
            // var sec = '4';

            var min = '${currQnnaire.durationMin}';
            var sec = '0';
            
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
                var header = document.createElement("h1");
                el.setAttribute("class","alert alert-danger");
                el.setAttribute("role","alert");
                el.setAttribute("align","center");
                header.innerHTML = "תם הזמן !!!"
                el.appendChild(header)
                document.body.appendChild(el);
                setTimeout(function(){
                    el.parentNode.removeChild(el);
                    document.qnnaireForm.submit()
                },2500);
            }
        </script>
        
        
    </head>
    <body dir="rtl" align="right" onload="examTimer()" style="margin-top: 100px">
        <div class="container">
            <nav class="navbar navbar-expand-sm bg-white navbar-white fixed-top">
                <!-- Brand/logo -->
                <a class="navbar-brand" href="#">
                    <img src="${path}/images/xmlogo.jpg" alt="logo" style="width:60px;">
                </a>

                <!-- Links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#"> נבחנים </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#"> ניהול </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#"> אודות </a>
                    </li>
                </ul>
                <div class="mx-auto order-0">
                    <span class="navbar-text">
                        <h1> שאלון ${currQnnaire.description}  </h1>
                    </span>
                </div>
                <span class="navbar-text right">
                    <h2 id="showtime"></h2>
                </span>
            </nav>
        </div>
        <hr>

        <form:form method="post" action="processQnnaire" id="qnnaireForm" name="qnnaireForm">
            <div align="right" class="container">
                <c:forEach items="${currQnnaire.questions}" var="question">
                    <div class="card mb-3 mt-3">
                        <h3> ${question.body} </h3>
                        <c:forEach items="${question.answers}" var="answer">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="${question.id}" value="${answer.id}"> ${answer.content}
                                </label>
                            </div>
                        </c:forEach>
                    </div>
                </c:forEach>

                        <br><br>
                        <button type="submit" id="subBtn" class="btn btn-outline-info"> הגש טופס </button>
                </form:form>
                <br><br>
            </div>
    </body>
</html>