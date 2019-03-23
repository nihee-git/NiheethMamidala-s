<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<center>
<div class="container">
  <h3>NiheethMamidala's</h3>
  <p>The One stop site for Smart Phones</p>
</div>
</center>
<nav class="navbar navbar-inverse">
  <ul class="nav navbar-nav">
    <li><a href="index">Home</a></li>
    <li><a href="login">Login</a></li>
    <li><a href="signup">Signup</a></li>
  </ul>
  
</nav>
<div class="container">
   
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="images/hallstatt-austria-1920x1080.jpg" alt="australia" style="width:100%;">
      </div>

      <div class="item">
        <img src="images/images.jpg" alt="mobile" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="images/IMG-20170509-WA0006.jpg" alt="laptop" style="width:100%;">
      </div>
    </div>

   <!--  Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>


<%@include file="Footer.jsp" %>
    