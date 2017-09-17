<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Items</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="/resources/css/common.css" rel="stylesheet">
    <link href="/resources/css/dataTables.bootstrap.min.css" rel="stylesheet">
	<link href="/resources/css/jquery.dataTables.min.css" rel="stylesheet">
	<script src="/resources/js/jquery-1.11.1.min.js"></script>
	<script src="/resources/js/jquery.dataTables.min.js"></script>
	<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/js/dataTables.bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<nav id='navbar-fixed' class='navbar navbar-static-top' >
		<div class='container-fluid clearfix header'>
			<div class="header-content">
				<div class="pull-left wel-msg">
					Purchase History
				</div>
				<div class="logout pull-right">
					<a id="logout" href="/login" target="_self" >
					  	Back
					</a>
				</div>
			</div>
		</div>
	</nav>
		<form method="post">
			<div class="form-content">
				<table id="cmnTable" class="table table-striped table-bordered" width="100%" cellspacing="0">
			    </table>
		    </div>
	    </form>
    </div>
</body>
<script src="/resources/js/history.js"></script>
</html>