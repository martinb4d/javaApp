<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
	
	<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="/resources/css/common.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form method="post">
			<div class ="form-signin">
				 <div class="form-group">
				  	<input name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
				  	<input name="password" type="password" class="form-control" placeholder="Password"/>
				  	<c:if test="${not empty actionForm.message}">
				 		<span class="has-error">${actionForm.message}</span>
				 	</c:if>
				 </div>
				<div class="form-group clearfix"> 	
					<input type="submit" value="Login" onclick="onLoginClick(this.form)" class="cmnbtn btn-half btn btn-lg btn-primary  pull-left" />
					<input type="button" value="History" onclick="onHistoryClick(this.form)" class="cmnbtn btn-half btn btn-lg btn-info  pull-right" />
				</div>
			</div>
		</form>
	</div>
</body>

<script src="/resources/js/jquery-1.11.1.min.js"></script>
<script src="/resources/js/login.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
