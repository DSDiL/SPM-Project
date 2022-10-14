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
		<h3 class="mt-5">Air Condition Repairs</h3>

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

			<c:forEach var="onGoingAir" items="${onGoingAir}">

				<c:set var="raID" value="${onGoingAir.raID}" />
				<c:set var="cID" value="${onGoingAir.cID}" />
				<c:set var="company" value="${onGoingAir.company}" />
				<c:set var="date" value="${onGoingAir.date}" />
				<c:set var="description" value="${onGoingAir.description}" />
				<c:set var="spare" value="${onGoingAir.spare}" />
				<c:set var="qty" value="${onGoingAir.qty}" />
				<c:set var="cost" value="${onGoingAir.cost}" />

				<tr>
					<td><label>${onGoingAir.cID}</label></td>
					<td><label>${onGoingAir.company}</label></td>
					<td><label>${onGoingAir.date}</label></td>
					<td><label>${onGoingAir.description}</label></td>
					<td><label>${onGoingAir.spare}</label></td>
					<td><label>${onGoingAir.qty}</label></td>
					<td><label>${onGoingAir.cost}</label></td>
				</tr>
			</c:forEach>
		</table>

		<h3 class="mt-5">Computer Repairs</h3>

		<table class="table table-striped">

			<tr>
				<th>Customer ID</th>
				<th>Company Name</th>
				<th>Deliver Name</th>
				<th>Date of Acceptance</th>
				<th>Description</th>
				<th>Spare Parts</th>
				<th>Quantity</th>
				<th>Estimated Cost</th>
			</tr>

			<c:forEach var="onGoingComputer" items="${onGoingComputer}">

				<c:set var="rcID" value="${onGoingComputer.rcID}" />
				<c:set var="cID" value="${onGoingComputer.cID}" />
				<c:set var="company" value="${onGoingComputer.company}" />
				<c:set var="deliver" value="${onGoingComputer.deliver}" />
				<c:set var="date" value="${onGoingComputer.date}" />
				<c:set var="description" value="${onGoingComputer.description}" />
				<c:set var="spare" value="${onGoingComputer.spare}" />
				<c:set var="qty" value="${onGoingComputer.qty}" />
				<c:set var="cost" value="${onGoingComputer.cost}" />

				<tr>
					<td><label>${onGoingComputer.cID}</label></td>
					<td><label>${onGoingComputer.company}</label></td>
					<td><label>${onGoingComputer.deliver}</label></td>
					<td><label>${onGoingComputer.date}</label></td>
					<td><label>${onGoingComputer.description}</label></td>
					<td><label>${onGoingComputer.spare}</label></td>
					<td><label>${onGoingComputer.qty}</label></td>
					<td><label>${onGoingComputer.cost}</label></td>
				</tr>
			</c:forEach>
		</table>

		<h3 class="mt-5">Other Electronic Repairs</h3>

		<table class="table table-striped">

			<tr>
				<th>Customer ID</th>
				<th>Company Name</th>
				<th>Devices Name</th>
				<th>Date of Acceptance</th>
				<th>Description</th>
				<th>Spare Parts</th>
				<th>Quantity</th>
				<th>Estimated Cost</th>
			</tr>

			<c:forEach var="onGoingOther" items="${onGoingOther}">

				<c:set var="roID" value="${onGoingOther.roID}" />
				<c:set var="cID" value="${onGoingOther.cID}" />
				<c:set var="company" value="${onGoingOther.company}" />
				<c:set var="devices" value="${onGoingOther.devices}" />
				<c:set var="date" value="${onGoingOther.date}" />
				<c:set var="description" value="${onGoingOther.description}" />
				<c:set var="spare" value="${onGoingOther.spare}" />
				<c:set var="qty" value="${onGoingOther.qty}" />
				<c:set var="cost" value="${onGoingOther.cost}" />

				<tr>
					<td><label>${onGoingOther.cID}</label></td>
					<td><label>${onGoingOther.company}</label></td>
					<td><label>${onGoingOther.devices}</label></td>
					<td><label>${onGoingOther.date}</label></td>
					<td><label>${onGoingOther.description}</label></td>
					<td><label>${onGoingOther.spare}</label></td>
					<td><label>${onGoingOther.qty}</label></td>
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