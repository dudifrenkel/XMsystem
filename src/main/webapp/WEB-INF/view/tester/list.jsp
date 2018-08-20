<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<head>
    <title>דף בוחן</title>
</head>

<body>
    <p>Welcome!! here is a list of all your tests.</p>
    <table>
        <thead>
            <tr>
                <th>מזהה מבחן</th>
                <th>תיאור</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${tests}" var="test">
                <tr>
                    <td>${test.id}</td>
                    <td>${test.description}</td>
                </tr>
            </c:forEach>
        </tbody>



    </table>


</body>

</html>