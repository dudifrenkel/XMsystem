<!DOCTYPE html>


<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>


<c:set var="path" value="${pageContext.request.contextPath}"></c:set>


    <head>
        <title> יצירת שאלה חדשה </title>

        <style>
            br{
                margin:0px;
                padding:0px;
                font-size:30px;
            }
        </style>
        <script type="text/javascript">

            var i = 2; // Global variable for answers

            function textBoxCreate(){

                var opt = document.createElement("option")
                opt.setAttribute("id","option_"+i)
                opt.setAttribute("name", "corrAns_"+i);
                opt.innerHTML = i;
                document.getElementById("correctAns").appendChild(opt);

                var text = document.createElement("input");
                text.setAttribute("type", "text");
                text.setAttribute("Placeholder", "תשובה מספר " + i);
                text.setAttribute("id", "answer_" + i);
                text.setAttribute("required", "true");
                text.setAttribute("name","ans_"+i);

                var br = document.createElement("br");
                br.setAttribute("id","br_" + i);

                var form = document.getElementById("questionForm");

                // insert the new field before the button "addQues"

                form.insertBefore(text,document.getElementById("addQues"));
                form.insertBefore(br,document.getElementById("addQues"));
                i++;
            }

            function textBoxDelete(){
                if (i>2) {
                    i--;
                    document.getElementById("br_"+ i).remove();
                    document.getElementById("answer_" + i).remove();
                    document.getElementById("option_"+ i).remove();
                }
                else {
                    alert("לפחות תשובה אחת לכל שאלה")
                }
            }
        </script>
    </head>
    <body dir="rtl">

    <h1> הוספת שאלה חדשה </h1>
        <hr>
            <form id="questionForm" name="questionForm" method="post" action="addQuestion" >
                <p> גוף השאלה <input size="130" type="text" name="body" placeholder="גוף השאלה" required="true" /></p>
                <p>
                    מס' התשובה הנכונה
                    <select name="correctAnswerNum" id="correctAns">
                        <option name="corrAns_1" value="1" id="1">1</option>
                </select>
                </p>

                <input type="text" name="ans_1" id="answer_1" required="true" placeholder="תשובה מספר 1">
                <br id="br_1">

                <button id="addQues" type="button" onclick="textBoxCreate()"> הוסף תשובה </button>
                <button id="rmvQues" type="button" onclick="textBoxDelete()"> הסר תשובה </button>

                <br><br>
                <button type="submit" id="submitBtn"> הוסף שאלה </button>
        </form>
    </body>
</html>