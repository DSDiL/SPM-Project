
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Leave of Absence Application</title>
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

	<nav class="navbar navbar-expand-md py-4 navbar-dark red  sticky-top  ">
		<button type="button" class="navbar-toggler" data-toggle="collapse"
			data-target="#myNav">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse   ">
			<ul class="navbar-nav mr-auto  ">
				<li class="nav-item"><a href="#service"
					class="nav-link h5 mr-2  "
					style="font-family: 'Raleway', sans-serif;" id="item"><i
						class="bi bi-house pr-2"></i><b>Home</b> </a></li>
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
	</div>
	</header>
	<div class="banner-area"></div>

	<div class="content-area" style ="margin-top: -100px;">
		<div class="wrapper">
			<br> <br> <br> <br> <br> <br> <br>
			<br>

			<!--Open Content Area-->


			<form name="form" class="form mx-auto" method="post"
				action="insertLeaving" onsubmit="return leaving(this)">

				<h2 style="margin-right: 50px;">
					<b>Leave of Absence Application</b>
				</h2>
				<br>
				<br>
				<br>

				<c:forEach var="leave" items="${empLeav}">

					<label class="lable"><h5>Leavings of Absences Left :</h5></label>


					<table class="table">
						<thead>
							<tr>



							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="col">Medical leavings</th>
								<td><input type="text" class="form-control text-center"
									style="width: 15%;" name="sick" id="sick" value="${leave.sick}"
									readonly></td>

							</tr>

							<tr>
								<th scope="col">Casual leavings</th>
								<td><input type="text" class="form-control text-center"
									style="width: 15%;" name="casual" id="casual"
									value="${leave.casual}" readonly></td>

							</tr>


						</tbody>
					</table>

				</c:forEach>
				<br>
				<br>

				<c:forEach var="emp" items="${empProf}">

					<label class="mt-5" style="font-size: 17px;" >NIC Number</label> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input type="text" class="form-control" name="nic" id="nic"
						value="${emp.nic}" readonly>
					<br>
					<br>
					<br>

				</c:forEach>

				<label style="font-size: 17px;">Reason for Absence</label> <select name="reason"
					class="form-control" id="reason" required>
					<option value="" selected="selected">Reason</option>
					<option value="MedicalLeaving">Medical leaving</option>
					<option value="CasualLeaving">Casual leaving</option>
					
				</select> <label class="mt-5" style="font-size: 17px;">Date of Absence</label> <input type="date"
					class="form-control" name="date" id="date" required> <label
					class="mt-5" style="font-size: 17px;">Time Period (Days)</label> <input type="number"
					class="form-control" name="days" id="days" required> <label
					class="mt-5" style="font-size: 17px;">More Details on Request</label> <br>
				<textarea name="more" class="form-control" id="more"></textarea>
				<br>
				<br>
				<br> <input type="submit" class="btn btn-success mt-5"
					id="submit" style="width: 400px; height: 50px;" name="Submit" value="APPLY"><br><br>
                </form>
				<c:forEach var="emp" items="${empProf}">

					<form action="leaveChange" method="post">
						<button type="submit" class="btn btn-primary" name="nic"
							id="change" style="width: 200px; height: 50px;" value="${emp.nic}">Check
							previous application</button>
						<br>
						<br>
						<br>
					</form>

				</c:forEach>
			


			<script type="text/javascript">
				function leaving(form) {
					reason = form.reason.value;
					days = form.days.value;
					sick = form.sick.value;
					casual = form.casual.value;

					if (casual == 0 || casual - days < 0) {
						alert("\nCasual leavings are over");
						return false;
					}

					if (reason == "MedicalLeaving") {
						alert("\nGet well soon!\nPlease present a valid Medical Certificate to Employee manager");
						return true;
					}

				}
			</script>
			<!--Close Content Area-->

			<br> <br> <br> <br> <br> <br> <br>
			<br>
		</div>

		<footer class="page-footer font-small cyan darken-3 text-center blue " style ="margin-top: -20px;">
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
