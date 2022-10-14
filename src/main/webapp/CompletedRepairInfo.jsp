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
	<div class="form mx-auto">
		<table class="table table-striped">
			<tbody>
				<c:forEach var="completedAir" items="${completedAir}">

					<c:set var="raID" value="${completedAir.raID}" />
					<c:set var="cID" value="${completedAir.cID}" />
					<c:set var="company" value="${completedAir.company}" />
					<c:set var="date" value="${completedAir.date}" />
					<c:set var="description" value="${completedAir.description}" />
					<c:set var="spare" value="${completedAir.spare}" />
					<c:set var="qty" value="${completedAir.qty}" />
					<c:set var="cost" value="${completedAir.cost}" />
					<c:set var="type" value="${completedAir.type}" />
					<c:set var="comDate" value="${completedAir.comDate}" />

					<tr>
						<th colspan="2"><label>${completedAir.type} Repair</label></th>
					</tr>
					<tr>
						<td><label>Customer ID : </label></td>
						<td><label>${completedAir.cID}</label></td>
					</tr>
					<tr>
						<td><label>Company Name :</label></td>
						<td><label>${completedAir.company}</label></td>
					</tr>
					<tr>
						<td><label>Date of Acceptance :</label></td>
						<td><label>${completedAir.date}</label></td>
					</tr>
					<tr>
						<td><label>Description :</label></td>
						<td><label>${completedAir.description}</label></td>
					</tr>
					<tr>
						<td><label>Spare Parts :</label></td>
						<td><label>${completedAir.spare}</label></td>
					</tr>
					<tr>
						<td><label>Quantity :</label></td>
						<td><label>${completedAir.qty}</label></td>
					</tr>
					<tr>
						<td><label>Estimated Cost :</label></td>
						<td><label>${completedAir.cost}</label></td>
					</tr>
					<tr>
						<td><label>Completed Date :</label></td>
						<td><label>${completedAir.comDate}</label></td>
					</tr>
				</c:forEach>
			<tbody>
		</table>

		<table class="table table-striped">

			<c:forEach var="completedComputer" items="${completedComputer}">

				<c:set var="rcID" value="${completedComputer.rcID}" />
				<c:set var="cID" value="${completedComputer.cID}" />
				<c:set var="company" value="${completedComputer.company}" />
				<c:set var="deliver" value="${completedComputer.deliver}" />
				<c:set var="date" value="${completedComputer.date}" />
				<c:set var="description" value="${completedComputer.description}" />
				<c:set var="spare" value="${completedComputer.spare}" />
				<c:set var="qty" value="${completedComputer.qty}" />
				<c:set var="cost" value="${completedComputer.cost}" />
				<c:set var="type" value="${completedComputer.type}" />
				<c:set var="comDate" value="${completedComputer.comDate}" />

				<tr>
					<th colspan="2"><label>${completedComputer.type}
							Repair</label></th>
				</tr>
				<tr>
					<td><label>Customer ID : </label></td>
					<td><label>${completedComputer.cID}</label></td>
				</tr>
				<tr>
					<td><label>Company Name :</label></td>
					<td><label>${completedComputer.company}</label></td>
				</tr>
				<tr>
					<td><label>Deliver Name :</label></td>
					<td><label>${completedComputer.deliver}</label></td>
				</tr>
				<tr>
					<td><label>Date of Acceptance :</label></td>
					<td><label>${completedComputer.date}</label></td>
				</tr>
				<tr>
					<td><label>Description :</label></td>
					<td><label>${completedComputer.description}</label></td>
				</tr>
				<tr>
					<td><label>Spare Parts :</label></td>
					<td><label>${completedComputer.spare}</label></td>
				</tr>
				<tr>
					<td><label>Quantity :</label></td>
					<td><label>${completedComputer.qty}</label></td>
				</tr>
				<tr>
					<td><label>Estimated Cost :</label></td>
					<td><label>${completedComputer.cost}</label></td>
				</tr>
				<tr>
					<td><label>Completed Date :</label></td>
					<td><label>${completedComputer.comDate}</label></td>
				</tr>
			</c:forEach>
		</table>

		<table class="table table-striped">
			<tbody>
				<c:forEach var="completedOther" items="${completedOther}">

					<c:set var="roID" value="${completedOther.roID}" />
					<c:set var="cID" value="${completedOther.cID}" />
					<c:set var="company" value="${completedOther.company}" />
					<c:set var="devices" value="${completedOther.devices}" />
					<c:set var="date" value="${completedOther.date}" />
					<c:set var="description" value="${completedOther.description}" />
					<c:set var="spare" value="${completedOther.spare}" />
					<c:set var="qty" value="${completedOther.qty}" />
					<c:set var="cost" value="${completedOther.cost}" />
					<c:set var="type" value="${completedOther.type}" />
					<c:set var="comDate" value="${completedOther.comDate}" />

					<tr>
						<th colspan="2"><label>${completedOther.type} Repair</label></th>
					</tr>

					<tr>
						<td><label>Customer ID : </label></td>
						<td><label>${completedOther.cID}</label></td>
					</tr>
					<tr>
						<td><label>Company Name :</label></td>
						<td><label>${completedOther.company}</label></td>
					</tr>
					<tr>
						<td><label>Devices Name :</label></td>
						<td><label>${completedOther.devices}</label></td>
					</tr>
					<tr>
						<td><label>Date of Acceptance :</label></td>
						<td><label>${completedOther.date}</label></td>
					</tr>
					<tr>
						<td><label>Description :</label></td>
						<td><label>${completedOther.description}</label></td>
					</tr>
					<tr>
						<td><label>Spare Parts :</label></td>
						<td><label>${completedOther.spare}</label></td>
					</tr>
					<tr>
						<td><label>Quantity :</label></td>
						<td><label>${completedOther.qty}</label></td>
					</tr>
					<tr>
						<td><label>Estimated Cost :</label></td>
						<td><label>${completedOther.cost}</label></td>
					</tr>
					<tr>
						<td><label>Completed Date :</label></td>
						<td><label>${completedOther.comDate}</label></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<center>
			<a href="repairHome.jsp" class="btn btn-info mt-5">Back to Home</a>
		</center>
	</div>
</body>
</html>