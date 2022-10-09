<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Sign up</title>
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
<link rel="stylesheet" href="styles/empSign.css">
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

	<div class="form mx-auto" style ="margin-top: 80px;">

		<h2 class="text-center text-white">
			<b> Employee Signup</b>
		</h2>
		<div class="container p-3">
			<form name="form" class="" method="post" action="employeeInsert">


				<div class="form-group row has-success">
					<label for="" class="col-sm-2 col-form-label">Full Name</label>
					<div class="col-sm-10">
						<input type="text" name="fname" id="fname" class="form-control"
							required />
					</div>
				</div>


				<div class="form-group row">
					<label for="" class="col-sm-2 col-form-label">NIC Number</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="nic" id="nic"
							pattern="[0-9V]{10}" required />
					</div>
				</div>


				<div class="form-group row">
					<label for="" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="email" id="email"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required />
					</div>
				</div>


				<div class="form-group row">
					<label for="" class="col-sm-2 col-form-label">Position</label>
					<div class="col-sm-10">
						<select name="position" id="position" class="form-control">
							<option value="" selected="selected">Position</option>
							<%
							try {
								Class.forName("com.mysql.jdbc.Driver").newInstance();
								Connection con = DriverManager
								.getConnection("jdbc:mysql://localhost:3306/darkshop?autoReconnect=true&useSSL=false", "root", "kl654321");
								Statement stt = con.createStatement();
								ResultSet rs = stt.executeQuery("select * from position");

								while (rs.next()) {
							%>
							<option value="<%=rs.getString("position")%>"
								<%if (request.getParameter("pID") != null) {
	                          if (rs.getInt("pID") == Integer.parseInt(request.getParameter("position"))) {
		                             out.println("selected");
	                             }
                                }%>>
								<%=rs.getString("position")%></option>
							<%
							}
							con.close();
							rs.close();
							} catch (Exception e) {
							e.printStackTrace();
							}
							%>
						</select> <a href="newPosition.jsp"> <input type="button" name="new"
							id="new" value="new" class="btn btn-primary">
						</a>
					</div>
				</div>



				<div class="form-group row">
					<label for="" class="col-sm-2 col-form-label">Working On
						Section</label>
					<div class="col-sm-10">
						<select name="section" id="section" required class="form-control">
							<option value="" selected="selected">Section</option>
							<option value="EmployeeManagement">Employee Management</option>
							<option value="RepairManagement">Repair Management</option>
							<option value="FinancialManagement">Financial Management</option>
							<option value="CustomerManagement">Customer Management</option>

						</select>
					</div>
				</div>


				<div class="form-group row">
					<label for="" class="col-sm-2 col-form-label">Basic Salary</label>
					<div class="col-sm-10">
						<input type="text" name="salary" id="salary" pattern="[0-9]{2,}"
							class="form-control" />

						<%
						String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
						int length = 8;

						try {
							StringBuilder sb = new StringBuilder();
							Random random = new Random();

							for (int i = 0; i < length; i++) {
								sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
							}

							sb.toString();
						%>

						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Password :</label>
						</div>
						<div class="col-sm-10">
							<input type="text" name="password" id="password"
								class="form-control" value="<%=sb.toString()%>" readonly>
						</div>
						<%
						} catch (Exception e) {
						e.printStackTrace();
						}
						%>


					</div>
				</div>

				<button type="submit" class="btn btn-success align-items-center" style ="width: 200px; height: 50px;"
					name="Submit">Signup</button>
			</form>
		</div>
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
