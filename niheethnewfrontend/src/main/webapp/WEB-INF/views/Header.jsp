<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NiheethMobiles</title>
<link rel="stylesheet" type="text/css"
	href="/ECommerceFrontEnd/resources/css/style.css" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Datatable Plugins -->

<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link
	href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"
	rel="stylesheet">

</head>
<body class="body">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-4 col-md-3 col-lg-3">
				<a href="Home"> <img
					src="/ECommerceFrontEnd/resources/images/TMLogo.jpg" alt="TouchM"
					style="float: left; width: 100px; height: 90px;" />
				</a>
			</div>
			<div class="col-xs-4 col-md-6 col-lg-6">
				<div class="middle">
					<h1 class="name">
						<b style="color: #034f84">NiheethMamidala's</b>
					</h1>
					<p>The One stop site for Smart Phones.
				</div>
			</div>
			<div class="col-xs-4 col-md-3 col-lg-3">
				<div class="myDetails">
					<p>Contact Us:</p>
					<p>
						<span class="glyphicon glyphicon-earphone" style="color: #034f84"></span>+91
						9010900643
					</p>
					<p>
						<span class="glyphicon glyphicon-envelope" style="color: #034f84"></span>mniheeth120@gmail.com
					</p>
				</div>
			</div>
		</div>
	</div>
	<nav class="navbar navbar-inverse" style="background-color: black">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">NiheethMamidala's</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">OS<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="Android">Android</a></li>
							<li><a href="IOS">IOS</a></li>
							<li><a href="Windows">Windows</a></li>
							<li><a href="BlackBerry">BlackBerry</a></li>
						</ul></li>
					<li><a href="AboutUs">About Us</a></li>
					<li><a href="Product">Phones</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">

					<!-- If user is not Logged in, he has to see this -->
					<c:choose>
						<c:when test="${empty LoggedInUser}">
							<li><a href="signup"><span
									class="glyphicon glyphicon-user"></span> Sign Up</a></li>
							<li><a href="login"><span
									class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:when>

						<c:when test="${!empty LoggedInUser}">
							<!-- If user is Logged in, he has to see this -->
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"><span
									class="glyphicon glyphicon-user"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">My Account</a></li>
									<li><a href="#">My Orders</a></li>
									<li><a href="#">Settings</a></li>
									<li><a href="perform_logout">Sign out</a></li>
								</ul></li>
							<li><a href="cart"><span
									class="glyphicon glyphicon-shopping-cart"></span></a></li>
						</c:when>
					</c:choose>

				</ul>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${not empty LoggedInUser}">

						<li class="navbar-text" style="font-size: 150%;">Welcome
							${LoggedInUser}!</li>
						<div class="media" style="float: left;">
							<!--  <div class="media-left media-top"> -->
							<img src="/ECommerceFrontEnd/resources/images/BG.jpg"
								class="media-object" style="width: 80px">
							<!-- </div> -->
						</div>
					</c:when>
					<c:when test="${loggedOut==true }">
						<li class="navbar-text" style="color:white">${LogOutMessage}</li>
					</c:when>

				</c:choose>
			</ul>
		</div>
	</nav>
</body>
</html>
