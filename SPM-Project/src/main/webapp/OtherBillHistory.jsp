<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Bill History</title>


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


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="css/styles.css">

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
				<li class="nav-item"><a href="HomePage.jsp"
					class="nav-link h5 mr-2  "
					style="font-family: 'Raleway', sans-serif;" id="item"><i
						class="bi bi-house pr-2"></i><b>Home</b> </a></li>
				<li class="nav-item"><a href="AllbillHistory.jsp"
					class="nav-link h5 mr-2" id="item"
					style="font-family: 'Raleway', sans-serif;"><i
						class="bi bi-clock-history pr-2"></i><b>Bill History</b> </a></li>
				<li class="nav-item"><a href="Emp.jsp" class="nav-link h5 mr-2"
					id="item" style="font-family: 'Raleway', sans-serif;"> <i
						class="bi bi-cash-stack pr-2"></i><b>Employee Salary</b>
				</a></li>
				<li class="nav-item"><a href="EmpHistory.jsp"
					class="nav-link h5 mr-2" id="item"
					style="font-family: 'Raleway', sans-serif;"><i
						class="bi bi-book-half pr-2"></i> <b>Salary History</b> </a></li>
			</ul>
		</div>

	</nav>

	<div class="form mx-auto w-90">
		<h2 class="text-center">
			<b>Bill History</b>
		</h2>



		<table class="table table-striped">

			<tr>
				<th>Other Electronic Repair Bill ID</th>
				<th>Repair ID</th>
				<th>Customer Name</th>
				<th>Date</th>
				<th>Spare Parts</th>
				<th>Quantity</th>
				<th>Cost</th>
				<th>Spare Part Price</th>
				<th>Bill Date</th>
				<th>Service Charges</th>
				<th>Total</th>
			</tr>


			<c:forEach var="otherBill" items="${otherBill}">
				<c:set var="billID" value="${ otherBill.billID }" />
				<c:set var="roID" value="${otherBill.roID}" />
				<c:set var="name" value="${otherBill.name}" />
				<c:set var="date" value="${ otherBill.date }" />
				<c:set var="spare" value="${ otherBill.spare }" />
				<c:set var="qty" value="${ otherBill.qty }" />
				<c:set var="cost" value="${ otherBill.cost }" />
				<c:set var="spareprice" value="${ otherBill.spareprice }" />
				<c:set var="billdate" value="${ otherBill.billdate }" />
				<c:set var="service" value="${ otherBill.service }" />
				<c:set var="total" value="${ otherBill.total }" />


				<tr>
					<td>${ otherBill.billID }</td>
					<td>${ otherBill.roID }</td>
					<td>${ otherBill.name }</td>
					<td>${ otherBill.date }</td>
					<td>${ otherBill.spare }</td>
					<td>${ otherBill.qty }</td>
					<td>${ otherBill.cost }</td>
					<td>${ otherBill.spareprice }</td>
					<td>${ otherBill.billdate }</td>
					<td>${ otherBill.service }</td>
					<td>${ otherBill.total }</td>


					<c:url value="otherBillUpdate.jsp" var="otherBillUpdate">

						<c:param name="otherbillID" value="${billID}" />
						<c:param name="otherroID" value="${roID}" />
						<c:param name="othername" value="${name}" />
						<c:param name="otherdate" value="${date}" />
						<c:param name="otherspare" value="${spare}" />
						<c:param name="otherqty" value="${qty}" />
						<c:param name="othercost" value="${cost}" />
						<c:param name="otherspareprice" value="${spareprice}" />
						<c:param name="otherbilldate" value="${billdate}" />
						<c:param name="otherservice" value="${service}" />
						<c:param name="othertotal" value="${total}" />


					</c:url>



					<td><a href="${otherBillUpdate}"> <input type="button"
							class="btn btn-primary" name="Submit" id="update" value="Update">
					</a></td>



					<c:url value="otherBillDelete.jsp" var="otherBillDelete">

						<c:param name="otherbillID" value="${billID}" />
						<c:param name="otherroID" value="${roID}" />
						<c:param name="othername" value="${name}" />
						<c:param name="otherdate" value="${date}" />
						<c:param name="otherspare" value="${spare}" />
						<c:param name="otherqty" value="${qty}" />
						<c:param name="othercost" value="${cost}" />
						<c:param name="otherspareprice" value="${spareprice}" />
						<c:param name="otherbilldate" value="${billdate}" />
						<c:param name="otherservice" value="${service}" />
						<c:param name="othertotal" value="${total}" />


					</c:url>

					<td><a href="${otherBillDelete}"> <input type="button"
							id="delete" class="btn btn-danger" name="delete" value="Delete"></a>

					</td>


				</tr>


			</c:forEach>
		</table>
		<br> <br> <br>


		<form action="OtherBillReport" method="post">

			<div class="form-group">
				<label class="mt-5">Generate Report</label> <input type="date"
					class="form-control" id="rid" name="date">
				<button type="submit" class="btn btn-success mt-5" name="Submit"
					value="Submit">Print Report</button>
			</div>

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
