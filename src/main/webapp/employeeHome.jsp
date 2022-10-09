<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Employee Home Page</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://kit.fontawesome.com/8da1f1e093.js"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles/styles.css">
<link rel="stylesheet" href="styles/employeeHome.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
</head>
<body>
	<button type="button" class="btn btn-danger btn-floating btn-lg"
		id="btn-back-to-top">
		<i class="fas fa-arrow-up"></i>
	</button>





	<nav class="navbar navbar-expand-md py-4 navbar-dark red  sticky-top  ">
		<button type="button" class="navbar-toggler" data-toggle="collapse"
			data-target="#myNav">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse   ">
			<ul class="navbar-nav mr-auto  ">
				<li class="nav-item"><a href="#"
					class="nav-link h5 mr-2  "
					style="font-family: 'Raleway', sans-serif;" id="item"><i
						class="bi bi-house pr-2"></i><b>Home</b> </a></li>
				<li class="nav-item"><a href="employeeLogin.jsp"
					class="nav-link h5 mr-2" id="item"
					style="font-family: 'Raleway', sans-serif;"><i
						class="bi bi-box-arrow-in-right pr-2"></i><b>Login/Logout</b> </a></li>
				<li class="nav-item"><a href="portfolio.html"
					class="nav-link h5 mr-2" id="item"
					style="font-family: 'Raleway', sans-serif;"> <i
						class="bi bi-info-circle pr-2"></i></i><b>About</b>
				</a></li>
				<li class="nav-item"><a href="contact.html"
					class="nav-link h5 mr-2" id="item"
					style="font-family: 'Raleway', sans-serif;"><i
						class="bi bi-person-lines-fill pr-2"></i></i> <b>Contact</b> </a></li>
			</ul>
		</div>

	</nav>

	<div class="form mx-auto">

		<c:forEach var="emp" items="${empProf}">

			<c:set var="nic" value="${emp.nic}" />
			<c:set var="name" value="${emp.name}" />
			<c:set var="position" value="${emp.section}" />

			<form name="form" id="form" action="employeeProfile" method="post">

				<img src="images/profile.png" class="float-right" alt="profile"
					style="width: 10%;"><br>
				<br>
				<br>
				<br>
				<br>

				<button type="submit" name="submit" style ="width: 150px; height: 40px; border-radius: 10px;" id="profile"
					class="btn btn-primary float-right" value="${emp.nic}">${emp.name}
					Profile</button>

			</form>

			<div class="form">
				<br>
				<br>
				<br>
				<c:choose>
					<c:when test="${emp.section=='EmployeeManagement'}">
						<button type="button" style ="width: 200px; height: 50px; margin-left: 340px;"
							onclick="document.location.href='employeeManagement.jsp'"
							name="em" id="submit" class="btn btn-info">Employee
							Management</button>
						<br>
						<br>
						<br>
						<br>

						<button type="button" onclick="document.location.href='#'"
							name="em" id="submit" style="box-shadow: none;  width: 200px; height: 50px; margin-left: 340px; "
							class="btn btn-info" disabled>Repair Management</button>
						<br>
						<br>
						<br>
						<br>

						<button type="button" onclick="document.location.href='#'"
							name="em" id="submit" style="box-shadow: none;  width: 200px; height: 50px; margin-left: 340px;"
							class="btn btn-info" disabled>Financial Management</button>
						<br>
						<br>
						<br>
						<br>

						<button type="button" onclick="document.location.href='#'"
							name="em" id="submit" style="box-shadow: none;  width: 200px; height: 50px; margin-left: 340px;"
							class="btn btn-info" disabled>Customer Management</button>
						<br>
						<br>
						<br>
						<br>

					</c:when>

					<c:when test="${emp.section=='RepairManagement'}">
						<button type="button"
							onclick="document.location.href='employeeManagement.jsp'"
							name="em" id="submit" style="box-shadow: none;"
							class="btn btn-info" disabled>Employee Management</button>
						<br>
						<br>
						<br>
						<br>

						<button type="button"
							onclick="document.location.href='repairHome.jsp'" name="em"
							id="submit" class="btn btn-info">Repair Management</button>
						<br>
						<br>
						<br>
						<br>

						<button type="button" onclick="document.location.href='#'"
							name="em" id="submit" style="box-shadow: none"
							class="btn btn-info" disabled>Financial Management</button>
						<br>
						<br>
						<br>
						<br>

						<button type="button" onclick="document.location.href='#'"
							name="em" id="submit" style="box-shadow: none"
							class="btn btn-info" disabled>Customer Management</button>
						<br>
						<br>
						<br>
						<br>

					</c:when>

					<c:when test="${emp.section=='FinancialManagement'}">
						<button type="button"
							onclick="document.location.href='employeeManagement.jsp'"
							name="em" id="submit" style="box-shadow: none"
							class="btn btn-info" disabled>Employee Management</button>
						<br>
						<br>
						<br>
						<br>

						<button type="button" onclick="document.location.href='#'"
							name="em" id="submit" style="box-shadow: none"
							class="btn btn-info" disabled>Repair Management</button>
						<br>
						<br>
						<br>
						<br>

						<button type="button"
							onclick="document.location.href='HomePage.jsp'" name="em"
							id="submit" class="btn btn-info">Financial Management</button>
						<br>
						<br>
						<br>
						<br>

						<button type="button" onclick="document.location.href='#'"
							name="em" id="submit" style="box-shadow: none"
							class="btn btn-info" disabled>Customer Management</button>
						<br>
						<br>
						<br>
						<br>

					</c:when>

					<c:when test="${emp.section=='CustomerManagement'}">
						<button type="button"
							onclick="document.location.href='#'"
							name="em" id="submit" style="box-shadow: none;"
							class="btn btn-info" disabled>Employee Management</button>
						<br>
						<br>
						<br>
						<br>

						<button type="button" onclick="document.location.href='#'"
							name="em" id="submit" style="box-shadow: none"
							class="btn btn-info" disabled>Repair Management</button>
						<br>
						<br>
						<br>
						<br>

						<button type="button" onclick="document.location.href='#'"
							name="em" id="submit" style="box-shadow: none"
							class="btn btn-info" disabled>Financial Management</button>
						<br>
						<br>
						<br>
						<br>

						<button type="button" onclick="document.location.href='#'"
							name="em" id="submit" class="btn btn-info">Customer
							Management</button>
						<br>
						<br>
						<br>
						<br>
					</c:when>


				</c:choose>

			</div>

		</c:forEach>

	</div>




	<footer class="page-footer font-small cyan darken-3 text-center blue " style ="margin-top: 120px;">
		<div class="container">
			<div class="row">
				<div class="col-md-12 py-5">
					<h4 class="text-uppercase text-white"
						style="font-family: 'Quicksand', sans-serif;">Follow Us out
						there</h4>
					<div class="mb-5 flex-center mt-5">
						<ul
							class="social-icons icon-circle icon-rotate list-unstyled list-inline">
							<li class="list-inline-item"><a href="#"><i
									class="fa fa-facebook mr-md-5 mr-3 fa-2x"></i></a></li>
							<li class="list-inline-item"><a href="#"><i
									class="fa fa-twitter mr-md-5 mr-3 fa-2x"></i></a></li>
							<li class="list-inline-item"><a href="#"><i
									class="fa fa-youtube mr-md-5 mr-3 fa-2x"></i></a></li>
							<li class="list-inline-item"><a href="#"><i
									class="fa fa-google-plus mr-md-5 mr-3 fa-2x"></i></a></li>
							<li class="list-inline-item"><a href="#"><i
									class="fa fa-instagram mr-md-5 mr-3 fa-2x"></i></a></li>
							<li class="list-inline-item"><a href="#"><i
									class="fa fa-linkedin mr-md-5 mr-3 fa-2x"></i></a></li>
							<li class="list-inline-item"><a href="#"><i
									class="fa fa-pinterest mr-md-5 mr-3 fa-2x"></i></a></li>
							<li class="list-inline-item"><a href="#"><i
									class="fa fa-github mr-md-5 mr-3 fa-2x"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</footer>


















	<script src="https://unpkg.com/aos@next/dist/aos.js"></script>
	<script>
		AOS.init();
	</script>

	<script>
		//Get the button
		let mybutton = document.getElementById("btn-back-to-top");

		// When the user scrolls down 20px from the top of the document, show the button
		window.onscroll = function() {
			scrollFunction();
		};

		function scrollFunction() {
			if (document.body.scrollTop > 20
					|| document.documentElement.scrollTop > 20) {
				mybutton.style.display = "block";
			} else {
				mybutton.style.display = "none";
			}
		}
		// When the user clicks on the button, scroll to the top of the document
		mybutton.addEventListener("click", backToTop);

		function backToTop() {
			document.body.scrollTop = 0;
			document.documentElement.scrollTop = 0;
		}
	</script>

</body>
</html>



<!--




-->
