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
<link rel="stylesheet" href="css/styles.css">

<title>DarkShop</title>

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
				<li class="nav-item"><a href="Home.jsp"
					class="nav-link h5 mr-2  "
					style="font-family: 'Raleway', sans-serif;" id="item"><i
						class="bi bi-house pr-2"></i><b>Home</b> </a></li>
				<li class="nav-item"><a href="customerLogin.jsp"
					class="nav-link h5 mr-2" id="item"
					style="font-family: 'Raleway', sans-serif;"> <i
						class="bi bi-info-circle pr-2"></i></i><b>Log out</b>
				</a></li>
			</ul>
		</div>
	</nav>


	<div class="form mx-auto">

		<h2 class="text-center text-white mb-5">
			<b> My profile</b>
		</h2>
		<table class="table table-striped">

			<tbody>
				<c:forEach var="cusDetails" items="${cusDetails}">
					<c:set var="id" value="${cusDetails.idCustomer}" />
					<c:set var="name" value="${cusDetails.full_Name}" />
					<c:set var="email" value="${cusDetails.email}" />
					<c:set var="phone" value="${cusDetails.phone_No}" />
					<c:set var="add" value="${cusDetails.address}" />
					<tr>
						<td>ID</td>
						<td>${cusDetails.idCustomer}</td>
					</tr>

					<tr>
						<td>Name</td>
						<td>${cusDetails.full_Name}</td>
					</tr>
					<tr>
						<td>Email</td>
						<td>${cusDetails.email}</td>
					</tr>
					<tr>
						<td>Phone Number</td>
						<td>${cusDetails.phone_No}</td>
					</tr>

					<tr>
						<td>Address</td>
						<td>${cusDetails.address}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<c:url value="CustomerUpdate.jsp" var="update">
			<c:param name="id" value="${id}" />
			<c:param name="name" value="${name}" />
			<c:param name="email" value="${email}" />
			<c:param name="phone" value="${phone}" />
			<c:param name="add" value="${add}" />
		</c:url>

		<a href="${update}">
			<button type="button" class="btn btn-primary align-items-center"
				name="update">Change My Details</button>
		</a>

		<c:url value="CustomerDelete.jsp" var="delete">

			<c:param name="id" value="${id}" />
			<c:param name="name" value="${name}" />
			<c:param name="email" value="${email}" />
			<c:param name="phone" value="${phone}" />
			<c:param name="brand" value="${brand}" />
			<c:param name="add" value="${add}" />
		</c:url>

		<a href="${delete}">
			<button type="button" class="btn btn-danger align-items-center"
				name="delete">Remove My Details</button>
		</a>

		<c:url value="userAcc.jsp" var="app">

			<c:param name="id" value="${id}" />

		</c:url>


		<a href="${app}">
			<button type="button" class="btn btn-success align-items-center"
				name="id">Make an Appointment</button>
		</a>

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
    window.onscroll = function () {
      scrollFunction();
    };

    function scrollFunction() {
      if (
        document.body.scrollTop > 20 ||
        document.documentElement.scrollTop > 20
      ) {
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


	<script>

function validateForm(){

	var name=document.myform.name.value;
	var email=document.myform.email.value;
	var phone=document.myform.phone.value;
	var add=document.myform.add.value;
	var pw=document.myform.pw.value;

	var pw=document.myform.pw.value;
	var pw2=document.myform.pw2.value;


 if(name==""){
		alert("Name can't be empty!");
		return false;
	}else if(email==""){
		alert("email can't be empty!");
		return false;
	}else if(phone==""){
		alert("Phone can't be empty!");
		return false;
	else if(add==""){
		alert("Address number can't be empty!");
		return false;
	}
	else if(pw.length<6){
		alert("Password must be at least 6 characters long!");
		return false;
	}else if(pw != pw2){
		alert("Password did not match! Try again!");
		return false;
	}
}

	</script>


</body>
</html>