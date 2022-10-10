<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
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
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet">
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

	<section class="text-center"></section>


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
				<li class="nav-item"><a href="about.html"
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


	<div class="container mt-5">
		<div class="row">
			<div class="col-md-8 ">
				<div id="car" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#car" data-slide-to="0" class="active"></li>
						<li data-target="#car" data-slide-to="1" class="active"></li>
						<li data-target="#car" data-slide-to="2" class="active"></li>
					</ol>
					<div class="carousel-inner ">
						<div class="carousel-item active">
							<img class="w-100 d-block rounded " src="images/slide1.jpg">
						</div>
						<div class="carousel-item">
							<img class="w-100 d-block rounded" src="images/computer4.jpg">
						</div>
						<div class="carousel-item">
							<img class="w-100 d-block rounded" src="images/other1.jpg">
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4  text-center " style="color: #fff;">
				<div class="h2 text-uppercase"
					style="border: 3px solid; border-radius: 20px; padding: 5px;">Our
					Mission</div>
				<p data-aos="fade-left" data-aos-duration="1000"
					style="font-family: 'Montserrat', sans-serif; border: 1px solid; border-radius: 25px; padding: 5px;">We
					are JC-Electronics, a purchasing and sales organization trading in
					industrial electronics on a global level. Our services include
					providing items for use in production processes and other automated
					environments. In the world of industrial automation, new
					technologies are rolled out in quick succession, resulting in a
					reduction in service and availability of existing technologies.
					This is where JC-Electronics comes into play. If it has worked
					before, it can certainly work again! There is no need to buy
					something new, when you already have something reliable that does
					the trick! Which is why we offer knowledge, expertise and
					continuity, We do this through purchase, sale, repair, testing and
					many more high-quality services.</p>

			</div>




		</div>
	</div>

	<div class="container mt-5">
		<div class="row">
			<div class="col-md-4  text-center" style="color: #fff;">
				<div class="h2 text-uppercase"
					style="border: 3px solid; border-radius: 20px; padding: 5px;">Our
					Mission</div>
				<p data-aos="fade-right" data-aos-duration="1000"
					style="font-family: 'Montserrat', sans-serif; border: 1px solid; border-radius: 25px; padding: 5px;">We
					are JC-Electronics, a purchasing and sales organization trading in
					industrial electronics on a global level. Our services include
					providing items for use in production processes and other automated
					environments. In the world of industrial automation, new
					technologies are rolled out in quick succession, resulting in a
					reduction in service and availability of existing technologies.
					This is where JC-Electronics comes into play. If it has worked
					before, it can certainly work again! There is no need to buy
					something new, when you already have something reliable that does
					the trick! Which is why we offer knowledge, expertise and
					continuity, We do this through purchase, sale, repair, testing and
					many more high-quality services.</p>
			</div>
			<div class="col-md-8 ">
				<div id="car" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#car" data-slide-to="0" class="active"></li>
						<li data-target="#car" data-slide-to="1" class="active"></li>
						<li data-target="#car" data-slide-to="2" class="active"></li>
					</ol>
					<div class="carousel-inner ">
						<div class="carousel-item active">
							<img class="w-100 d-block rounded " src="images/slide1.jpg">
						</div>
						<div class="carousel-item">
							<img class="w-100 d-block rounded" src="images/computer4.jpg">
						</div>
						<div class="carousel-item">
							<img class="w-100 d-block rounded" src="images/other1.jpg">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<hr class="mt-5 mb-5">

	<div class="container mt-5 ">
		<div class="h1 text-uppercase text-center mt-5"
			style="border: 2px solid #fff; color: #fff; border-radius: 15px; padding: 5px;">Our
			services</div>
		<div class="row text-center text-white">
			<div class="card-deck">


				<div class="card p-3 mx-5 " data-aos="fade-left"
					data-aos-duration="700"
					style="width: 18rem; box-shadow: -30px 30px 20px rgba(0, 0, 0, 0.6);">
					<img src="images/computer5.jpg" alt="image"
						class="card-img-top shadow bg-white rounded">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">sadf dsfsd dfsdf df df sdf dsf sdf sdf
							fieldset</p>
					</div>
					<div class="card-footer bg-transparent text-center ">
						<button type="button" class="mybuttonoverlap btn btn-info ">
							<i class="bi bi-pc-display"></i>Read More
						</button>
					</div>
				</div>


				<div class="card p-3 mx-5" data-aos="fade-up"
					data-aos-duration="700"
					style="width: 18rem; box-shadow: -30px 30px 20px rgba(0, 0, 0, 0.6);">
					<img src="images/ac1.jpg" alt="image"
						class="card-img-top shadow bg-white rounded">
					<div class="card-body">
						<h5>Air Conditioner</h5>
						<p class="card-text">sadf dsfsd dfsdf df df sdf dsf sdf sdf
							fieldset</p>
					</div>
					<div class="card-footer bg-transparent text-center ">
						<button type="button" class="mybuttonoverlap btn btn-info ">
							<i class="bi bi-wind"></i>Read More
						</button>
					</div>
				</div>



				<div class="card p-3 mx-5" data-aos="fade-right"
					data-aos-duration="700"
					style="width: 18rem; box-shadow: -30px 30px 20px rgba(0, 0, 0, 0.6);">
					<img src="images/other2.jpg" alt="image"
						class="card-img-top shadow bg-white rounded">
					<div class="card-body">
						<h5>Air Conditioner</h5>
						<p class="card-text">sadf dsfsd dfsdf df df sdf dsf sdf sdf
							fieldset</p>
					</div>
					<div class="card-footer bg-transparent text-center ">
						<button type="button" class="mybuttonoverlap btn btn-info ">
							<i class="bi bi-tools"></i>Read More
						</button>
					</div>
				</div>
			</div>
		</div>
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



	<script>
		var words = [ 'Welcome to TECHSCOPE', 'Fix Your Desktops',
				'Fix Your Laptops', ' Fix Your Air Conditioners',
				'And Many More Electronics' ], part, i = 0, offset = 0, len = words.length, forwards = true, skip_count = 0, skip_delay = 15, speed = 70;
		var wordflick = function() {
			setInterval(function() {
				if (forwards) {
					if (offset >= words[i].length) {
						++skip_count;
						if (skip_count == skip_delay) {
							forwards = false;
							skip_count = 0;
						}
					}
				} else {
					if (offset == 0) {
						forwards = true;
						i++;
						offset = 0;
						if (i >= len) {
							i = 0;
						}
					}
				}
				part = words[i].substr(0, offset);
				if (skip_count == 0) {
					if (forwards) {
						offset++;
					} else {
						offset--;
					}
				}
				$('.word').text(part);
			}, speed);
		};

		$(document).ready(function() {
			wordflick();
		});
	</script>

</body>
</html>
