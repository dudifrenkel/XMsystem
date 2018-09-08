
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<html>
<head>
   <title> ניהול משתמשים </title>
</head>
<body dir="rtl">
<h1> ניהול משתמשים </h1>
<hr>

<h2> מנהלים </h2>

<p ><table border=1 bgcolor="#e6e6fa">

    <thead>
    <tr>
        <td>ID</td>
        <td>User Name</td>
        <td>מחק מנהל</td>
    </tr>
    </thead>
    <c:forEach var="admin" items="${admins}">
    <tr>
        <td>${admin.id}</td>
        <td>${admin.userName}</td>
        <td> <a name="del" href="deleteAdmin/${admin.id}"> מחק </a></td>
    </tr>
    </c:forEach>
</table>
</p>
<a href="/admin/createAdmin"> צור מנהל חדש </a>

<br><br>

<h2> בוחנים </h2>

<p ><table border=1 bgcolor="#e6e6fa">

    <thead>
    <tr>
        <td>ID</td>
        <td>User Name</td>
        <td>מחק בוחן</td>
    </tr>
    </thead>
    <c:forEach var="tester" items="${testers}">
        <tr>
            <td>${tester.id}</td>
            <td>${tester.userName}</td>
            <td> <a name="del" href="deleteTester/${tester.id}"> מחק </a></td>
        </tr>
    </c:forEach>
</table>
</p>
<a href="/admin/createTester"> צור בוחן חדש </a>

<br>

<br><br>

<h2> נבחנים </h2>

<p ><table border=1 bgcolor="#e6e6fa">

    <thead>
    <tr>
        <td>ID</td>
        <td>ת.ז</td>
        <td>שם פרטי</td>
        <td>שם משפחה</td>
        <td>פרטים</td>
    </tr>
    </thead>
    <c:forEach var="examinee" items="${examinees}">
        <tr>
            <td>${examinee.id}</td>
            <td>${examinee.taz}</td>
            <td>${examinee.firstName}</td>
            <td>${examinee.lastName}</td>
            <td> <a name="details" href="getDetails/${examinee.id}"> פרטים </a></td>
        </tr>
    </c:forEach>
</table>
</p>

<br>
<hr>
<a href="${path}/admin/adminsEntrance"> חזרה לאיזור הניהול </a><br>
</body>

</html>