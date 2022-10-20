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
<body onclick="window.print();">



	<div class="form mx-auto">
		<h3 class="mt-5">Software</h3>

		<table class="table table-striped">

			<tr>
				<th>Customer ID</th>
				<th>Company Name</th>
				<th>Date of Acceptance</th>
				<th>Description</th>
				<th>Spare Parts</th>
				<th>Quantity</th>
				<th>Estimated Cost</th>
			</tr>

			<c:forEach var="onGoingSoftware" items="${onGoingSoftware}">

				<c:set var="raID" value="${onGoingSoftware.raID}" />
				<c:set var="cID" value="${onGoingSoftware.cID}" />
				<c:set var="company" value="${onGoingSoftware.company}" />
				<c:set var="date" value="${onGoingSoftware.date}" />
				<c:set var="description" value="${onGoingSoftware.description}" />
				<c:set var="cost" value="${onGoingSoftware.cost}" />

				<tr>
					<td><label>${onGoingSoftware.cID}</label></td>
					<td><label>${onGoingSoftware.company}</label></td>
					<td><label>${onGoingSoftware.date}</label></td>
					<td><label>${onGoingSoftware.description}</label></td>
					<td><label>${onGoingSoftware.cost}</label></td>
				</tr>
			</c:forEach>
		</table>

		<h3 class="mt-5">Hardware</h3>

		<table class="table table-striped">

			<tr>
				<th>Customer ID</th>
				<th>Company Name</th>
				<th>Date of Acceptance</th>
				<th>Description</th>
				<th>Estimated Cost</th>
			</tr>

			<c:forEach var="onGoingHardware" items="${onGoingHardware}">

				<c:set var="rcID" value="${onGoingHardware.rcID}" />
				<c:set var="cID" value="${onGoingHardware.cID}" />
				<c:set var="company" value="${onGoingHardware.company}" />
				<c:set var="date" value="${onGoingHardware.date}" />
				<c:set var="description" value="${onGoingHardware.description}" />
				<c:set var="cost" value="${onGoingHardware.cost}" />

				<tr>
					<td><label>${onGoingHardware.cID}</label></td>
					<td><label>${onGoingHardware.company}</label></td>
					<td><label>${onGoingHardware.date}</label></td>
					<td><label>${onGoingHardware.description}</label></td>
					<td><label>${onGoingHardware.cost}</label></td>
				</tr>
			</c:forEach>
		</table>

		<h3 class="mt-5">Other Repairs</h3>

		<table class="table table-striped">

			<tr>
				<th>Customer ID</th>
				<th>Company Name</th>
				<th>Date of Acceptance</th>
				<th>Description</th>
				<th>Estimated Cost</th>
			</tr>

			<c:forEach var="onGoingOther" items="${onGoingOther}">

				<c:set var="roID" value="${onGoingOther.roID}" />
				<c:set var="cID" value="${onGoingOther.cID}" />
				<c:set var="company" value="${onGoingOther.company}" />
				<c:set var="date" value="${onGoingOther.date}" />
				<c:set var="description" value="${onGoingOther.description}" />
				<c:set var="cost" value="${onGoingOther.cost}" />

				<tr>
					<td><label>${onGoingOther.cID}</label></td>
					<td><label>${onGoingOther.company}</label></td>
					<td><label>${onGoingOther.date}</label></td>
					<td><label>${onGoingOther.description}</label></td>
					<td><label>${onGoingOther.cost}</label></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<br>


	</div>





</body>
</html>