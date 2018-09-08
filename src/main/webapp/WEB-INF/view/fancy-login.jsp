<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html lang="he">

<head>
	
	<title> התחברות </title>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

	<style>
		body {
			padding-top: 100px;
		}
		.nav-link{
			color: #95C7D8;
		}
	</style>

	<%--<meta charset="utf-8">--%>
	<%--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
	<%--<!-- Reference Bootstrap files -->--%>
	<%--<link rel="stylesheet"--%>
		 <%--href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
	<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>--%>
	<%--<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

</head>

<body dir="rtl">
	<div class="container">
		<nav class="navbar navbar-expand-sm bg-white navbar-white fixed-top">
			<!-- Brand/logo -->
			<a class="navbar-brand" href="/">
				<img src="images/xmlogo.jpg" alt="logo" style="width:60px;">
			</a>

			<!-- Links -->
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="examinee/examineeEntrance"> נבחנים </a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="admin/adminsEntrance"> ניהול </a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/"> אודות </a>
				</li>
			</ul>
		</nav>
	</div>

	<div>
		<div dir="rtl" id="loginbox" style="margin-top: 50px;margin-right: 50px;"
			 class="card col-lg-3 offset-2 col-md-6 offset-2">
			<%--class="card col-lg-3 offset-2 col-md-6 offset-2">--%>
			<div class="card bg-light mb-3 mt-3">
				<div class="card-header text-right">
					 התחברות מנהלים
				</div>
				<div style="padding-top: 30px" class="card-body">

					<!-- Login Form -->
					<form:form action="${path}/authTheUser"
							   method="POST" class="form-horizontal">
						<div class="form-group">
					        <div class="col-15">
					            <div>
								<c:if test="${param.error != null}">
									<div class="alert alert-danger offset-1 col-10 text-right">
										שם משתמש / סיסמה שגויים!
									</div>
								</c:if>
								<c:if test="${param.logout != null}">
									<div class="alert alert-success offset-1 col-10 text-right">
										התנתקת בהצלחה!
									</div>
								</c:if>
					            </div>
					        </div>
					    </div>

						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
							<%--<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>--%>
							<input type="text" name="username" placeholder="שם משתמש" class="form-control">
						</div>

						<!-- Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<%--<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>--%>
							
							<input type="password" name="password" placeholder="סיסמה" class="form-control" >
						</div>

						<!-- Login/Submit Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-success"> התחברות </button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>