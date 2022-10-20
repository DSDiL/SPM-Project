<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<link rel="stylesheet" href="css/styles.css">
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
<title>Insert title here</title>
</head>
<body>


	<button type="button" class="btn btn-danger btn-floating btn-lg"
		id="btn-back-to-top">
		<i class="fas fa-arrow-up"></i>
	</button>
	<div class="form mx-auto">
		<%
		String raID = request.getParameter("raID");
		String rcID = request.getParameter("rcID");
		String roID = request.getParameter("roID");
		String cID = request.getParameter("cID");
		String company = request.getParameter("company");
		String description = request.getParameter("description");
		String date = request.getParameter("date");
		String cost = request.getParameter("cost");
		String type = request.getParameter("type");
		%>
		<c:set var="type" scope="session" value="<%=type%>" />

		<form action="onGoingUpdate" method="post">

			<c:if test="${type=='Software'}">
				<table class="table table-striped">
					<tr>
						<td><label>Repair ID : </label></td>
						<td><input type="text" class="form-control" name="raID"
							value="<%=raID%>" readonly></td>
					</tr>
					<tr>
						<td><label>Repair Type : </label></td>
						<td><input type="text" class="form-control" name="type"
							value="<%=type%>" readonly></td>
					</tr>
					<tr>
						<td><label>Customer ID : </label></td>
						<td><input type="text" class="form-control" name="cID"
							value="<%=cID%>" readonly></td>
					</tr>
					<tr>
						<td><label>Company Name : </label></td>
						<td><input type="text" class="form-control" name="com"
							value="<%=company%>" required></td>
					</tr>
					<tr>
						<td><label>Date of Acceptance : </label></td>
						<td><input type="date" class="form-control" name="date"
							value="<%=date%>" readonly></td>
					</tr>
					<tr>
						<td><label>Description : </label></td>
						<td><textarea name="des" class="form-control"><%=description%></textarea></td>
					</tr>
					
					<tr>
						<td><label>Estimated Cost : </label></td>
						<td><input type="number" class="form-control" name="cost"
							value="<%=cost%>" required></td>
					</tr>
					<tr>
						<td><label>Repair Status : </label></td>
						<td><select name="status" class="form-control" required>
								<option selected="selected">---Select---</option>
								<option value="Ongoing">Ongoing</option>
								<option value="Completed">Completed</option>
						</select></td>
					</tr>
					<tr>
						<td><button type="submit" class="btn btn-success">Update</button></td>
					</tr>
				</table>
			</c:if>



			<c:if test="${type=='Hardware'}">
				<table>
					<tr>
						<td><label>Repair ID : </label></td>
						<td><input type="text" name="rcID" value="<%=rcID%>" readonly></td>
					</tr>
					<tr>
						<td><label>Repair Type : </label></td>
						<td><input type="text" name="type" value="<%=type%>" readonly></td>
					</tr>
					<tr>
						<td><label>Customer ID : </label></td>
						<td><input type="text" name="cID" value="<%=cID%>" readonly></td>
					</tr>
					<tr>
						<td><label>Company Name : </label></td>
						<td><input type="text" name="com" value="<%=company%>"
							required></td>
					</tr>
					
					<tr>
						<td><label>Date of Acceptance : </label></td>
						<td><input type="date" name="date" value="<%=date%>" readonly></td>
					</tr>
					<tr>
						<td><label>Description : </label></td>
						<td><textarea name="des"><%=description%></textarea></td>
					</tr>
				
					<tr>
						<td><label>Estimated Cost : </label></td>
						<td><input type="number" name="cost" value="<%=cost%>"
							required></td>
					</tr>
					<tr>
						<td><label>Repair Status : </label></td>
						<td><select name="status" required>
								<option selected="selected">---Select---</option>
								<option value="Ongoing">Ongoing</option>
								<option value="Completed">Completed</option>
						</select></td>
					</tr>
					<tr>
						<td><button type="submit" class="btn btn-success">Update</button></td>
					</tr>
				</table>
			</c:if>



			<c:if test="${type=='Other'}">
				<table>
					<tr>
						<td><label>Repair ID : </label></td>
						<td><input type="text" name="roID" value="<%=roID%>" readonly></td>
					</tr>
					<tr>
						<td><label>Repair Type : </label></td>
						<td><input type="text" name="type" value="<%=type%>" readonly></td>
					</tr>
					<tr>
						<td><label>Customer ID : </label></td>
						<td><input type="text" name="cID" value="<%=cID%>" readonly></td>
					</tr>
					<tr>
						<td><label>Company Name : </label></td>
						<td><input type="text" name="com" value="<%=company%>"
							required></td>
					</tr>
				
					<tr>
						<td><label>Date of Acceptance : </label></td>
						<td><input type="date" name="date" value="<%=date%>" readonly></td>
					</tr>
					<tr>
						<td><label>Description : </label></td>
						<td><textarea name="des"><%=description%></textarea></td>
					</tr>
				
					<tr>
						<td><label>Estimated Cost : </label></td>
						<td><input type="number" name="cost" value="<%=cost%>"
							required></td>
					</tr>
					<tr>
						<td><label>Repair Status : </label></td>
						<td><select name="status" required>
								<option selected="selected">---Select---</option>
								<option value="Ongoing">Ongoing</option>
								<option value="Completed">Completed</option>
						</select></td>
					</tr>
					<tr>
						<td><button type="submit" class="btn btn-success">Update</button></td>
					</tr>
				</table>
			</c:if>
		</form>

	</div>



	<footer class="page-footer font-small cyan darken-3 text-center blue ">
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