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
	<div class="form mx-auto" id="form">

		<table class="table table-striped">

			<c:forEach var="onGoingSoftware" items="${onGoingSoftware}">

				<c:set var="raID" value="${onGoingSoftware.raID}" />
				<c:set var="cID" value="${onGoingSoftware.cID}" />
				<c:set var="company" value="${onGoingSoftware.company}" />
				<c:set var="date" value="${onGoingSoftware.date}" />
				<c:set var="description" value="${onGoingSoftware.description}" />
		
				<c:set var="cost" value="${onGoingSoftware.cost}" />
				<c:set var="type" value="${onGoingSoftware.type}" />

				<tr>
					<th colspan="2"><label>${onGoingSoftware.type} Repair</label></th>
				</tr>
				<tr>
					<td><label>Customer ID : </label></td>
					<td><label>${onGoingSoftware.cID}</label></td>
				</tr>
				<tr>
					<td><label>Company Name :</label></td>
					<td><label>${onGoingSoftware.company}</label></td>
				</tr>
				<tr>
					<td><label>Date of Acceptance :</label></td>
					<td><label>${onGoingSoftware.date}</label></td>
				</tr>
				<tr>
					<td><label>Description :</label></td>
					<td><label>${onGoingSoftware.description}</label></td>
				</tr>
			
				<tr>
					<td><label>Estimated Cost :</label></td>
					<td><label>${onGoingSoftware.cost}</label></td>
				</tr>
				<tr>
					<td><c:url value="ongoingUpdate.jsp" var="softwareUpdate">
							<c:param name="raID" value="${raID}" />
							<c:param name="cID" value="${cID}" />
							<c:param name="company" value="${company}" />
							<c:param name="date" value="${date}" />
							<c:param name="description" value="${description}" />
							<c:param name="cost" value="${cost}" />
							<c:param name="type" value="${type}" />
						</c:url> <a href="${softwareUpdate}"> <input type="button"
							class="btn btn-success" name="update" value="Update">
					</a></td>
					<td><c:url value="ongoingDelete.jsp" var="softwareDelete">
							<c:param name="raID" value="${raID}" />
							<c:param name="cID" value="${cID}" />
							<c:param name="company" value="${company}" />
							<c:param name="date" value="${date}" />
							<c:param name="description" value="${description}" />
							<c:param name="cost" value="${cost}" />
							<c:param name="type" value="${type}" />
						</c:url> <a href="${softwareDelete}"> <input type="button"
							class="btn btn-primary" name="update" value="Delete">
					</a></td>
				</tr>
			</c:forEach>
		</table>

		<table class="table table-striped">

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
				<c:set var="type" value="${onGoingComputer.type}" />

				<tr>
					<th colspan="2"><label>${onGoingComputer.type} Repair</label></th>
				</tr>
				<tr>
					<td><label>Customer ID : </label></td>
					<td><label>${onGoingComputer.cID}</label></td>
				</tr>
				<tr>
					<td><label>Company Name :</label></td>
					<td><label>${onGoingComputer.company}</label></td>
				</tr>
				<tr>
					<td><label>Deliver Name :</label></td>
					<td><label>${onGoingComputer.deliver}</label></td>
				</tr>
				<tr>
					<td><label>Date of Acceptance :</label></td>
					<td><label>${onGoingComputer.date}</label></td>
				</tr>
				<tr>
					<td><label>Description :</label></td>
					<td><label>${onGoingComputer.description}</label></td>
				</tr>
				<tr>
					<td><label>Spare Parts :</label></td>
					<td><label>${onGoingComputer.spare}</label></td>
				</tr>
				<tr>
					<td><label>Quantity :</label></td>
					<td><label>${onGoingComputer.qty}</label></td>
				</tr>
				<tr>
					<td><label>Estimated Cost :</label></td>
					<td><label>${onGoingComputer.cost}</label></td>
				</tr>

				<tr>
					<td><c:url value="ongoingUpdate.jsp" var="comUpdate">
							<c:param name="rcID" value="${rcID}" />
							<c:param name="cID" value="${cID}" />
							<c:param name="deliver" value="${deliver}" />
							<c:param name="company" value="${company}" />
							<c:param name="date" value="${date}" />
							<c:param name="description" value="${description}" />
							<c:param name="spare" value="${spare}" />
							<c:param name="qty" value="${qty}" />
							<c:param name="cost" value="${cost}" />
							<c:param name="type" value="${type}" />
						</c:url> <a href="${comUpdate}"> <input type="button"
							class="btn btn-success" name="update" value="Update">
					</a></td>
					<td><c:url value="ongoingDelete.jsp" var="comDelete">
								  <<c:param name="rcID" value="${rcID}" />
							<c:param name="cID" value="${cID}" />
							<c:param name="deliver" value="${deliver}" />
							<c:param name="company" value="${company}" />
							<c:param name="date" value="${date}" />
							<c:param name="description" value="${description}" />
							<c:param name="spare" value="${spare}" />
							<c:param name="qty" value="${qty}" />
							<c:param name="cost" value="${cost}" />
							<c:param name="type" value="${type}" />
						</c:url> <a href="${comDelete}"> <input type="button"
							class="btn btn-primary" name="update" value="Delete">
					</a></td>
				</tr>
			</c:forEach>
		</table>

		<table class="table table-striped">

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
				<c:set var="type" value="${onGoingOther.type}" />

				<tr>
					<th><label>${onGoingOther.type} Repair</label></th>
				</tr>

				<tr>
					<td><label>Customer ID : </label></td>
					<td><label>${onGoingOther.cID}</label></td>
				</tr>
				<tr>
					<td><label>Company Name :</label></td>
					<td><label>${onGoingOther.company}</label></td>
				</tr>
				<tr>
					<td><label>Devices Name :</label></td>
					<td><label>${onGoingOther.devices}</label></td>
				</tr>
				<tr>
					<td><label>Date of Acceptance :</label></td>
					<td><label>${onGoingOther.date}</label></td>
				</tr>
				<tr>
					<td><label>Description :</label></td>
					<td><label>${onGoingOther.description}</label></td>
				</tr>
				<tr>
					<td><label>Spare Parts :</label></td>
					<td><label>${onGoingOther.spare}</label></td>
				</tr>
				<tr>
					<td><label>Quantity :</label></td>
					<td><label>${onGoingOther.qty}</label></td>
				</tr>
				<tr>
					<td><label>Estimated Cost :</label></td>
					<td><label>${onGoingOther.cost}</label></td>
				</tr>

				<tr>
					<td><c:url value="ongoingUpdate.jsp" var="otherUpdate">
							<c:param name="roID" value="${roID}" />
							<c:param name="cID" value="${cID}" />
							<c:param name="devices" value="${devices}" />
							<c:param name="company" value="${company}" />
							<c:param name="date" value="${date}" />
							<c:param name="date" value="${date}" />
							<c:param name="description" value="${description}" />
							<c:param name="spare" value="${spare}" />
							<c:param name="qty" value="${qty}" />
							<c:param name="cost" value="${cost}" />
							<c:param name="type" value="${type}" />
						</c:url> <a href="${otherUpdate}"> <input type="button"
							class="btn btn-success" name="update" value="Update">
					</a></td>
					<td><c:url value="ongoingDelete.jsp" var="otherDelete">
							<c:param name="roID" value="${roID}" />
							<c:param name="cID" value="${cID}" />
							<c:param name="devices" value="${devices}" />
							<c:param name="company" value="${company}" />
							<c:param name="date" value="${date}" />
							<c:param name="date" value="${date}" />
							<c:param name="description" value="${description}" />
							<c:param name="spare" value="${spare}" />
							<c:param name="qty" value="${qty}" />
							<c:param name="cost" value="${cost}" />
							<c:param name="type" value="${type}" />
						</c:url> <a href="${otherDelete}"> <input type="button"
							class="btn btn-primary" name="update" value="Delete">
					</a></td>
				</tr>
			</c:forEach>
		</table>


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