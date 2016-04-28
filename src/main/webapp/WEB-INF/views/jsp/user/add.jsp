<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add user</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Project Name</a>
	</div>
  </div>
</nav>

<form action="/spring4/user/add" method="post">
<div class="container">

  <div class="row">
	<div class="col-md-6">
		<h2>Username</h2>
		<p>
			<input type="text" id="username" name="username"/>
		</p>
	</div>
	<div class="col-md-6">
		<h2>Password</h2>
		<p>
			<input type="password" name="password" id="password"/>
		</p>
	</div>
	<div class="col-md-6">
		<p>
			<input type="submit"/>
		</p>
	</div>
  </div>
</div>
</form>


<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>