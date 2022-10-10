<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<title></title>

<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link
	href="https://fonts.googleapis.com/css2?family=Quicksand:wght@500&display=swap"
	rel="stylesheet">


<link rel="stylesheet" href="css/cusid.css">


</head>
<body>
	<div class="box-area">
		<header>
			<div class="wrapper">

				<nav>
					<div class="content">
						<img class="img" src="images/logo.png" alt="logo image">
					</div>
					<a href="repair_and_deliver.jsp">Bills</a> <a
						href="AllbillHistory.jsp">Bill History</a> <a href="Emp.jsp">Employee
						Salaries</a> <a href="EmpHistory.jsp">Salary History</a> <a
						href="HomePage.jsp">Home</a>

				</nav>
			</div>
		</header>
		<div class="banner-area"></div>

		<div class="content-area">
			<div class="wrapper">
				<br> <br> <br> <br> <br> <br> <br>
				<br>


				<!--Open Content Area-->
				<div class="form">
					<form action="RepairBillHistory" method="post">

						<label for="cid"><strong>Input The Date :</strong></label><br>
						<br> <br> <br> <input type="date" id="rid"
							name="date"><br> <br> <input type="submit"
							id="submit" value="Bill History">

					</form>


					</form>
				</div>


				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br>


			</div>
			<footer class="footer">
				<div class="container">
					<div class="row">
						<div class="footer-col">
							<h4>company</h4>
							<ul>
								<li><a href="#">about us</a></li>
								<li><a href="#">our services</a></li>
								<li><a href="#">privacy policy</a></li>
								<li><a href="#">affiliate program</a></li>
							</ul>
						</div>
						<div class="footer-col">
							<h4>get help</h4>
							<ul>
								<li><a href="#">FAQ</a></li>
								<li><a href="#">shipping</a></li>
								<li><a href="#">returns</a></li>
								<li><a href="#">order status</a></li>
								<li><a href="#">payment options</a></li>
							</ul>
						</div>
						<div class="footer-col">
							<h4>online shop</h4>
							<ul>
								<li><a href="#">watch</a></li>
								<li><a href="#">bag</a></li>
								<li><a href="#">shoes</a></li>
								<li><a href="#">dress</a></li>
							</ul>
						</div>
						<div class="footer-col">
							<h4>follow us</h4>
							<div class="social-links">
								<a href="#"><i class="fab fa-facebook-f"></i></a> <a href="#"><i
									class="fab fa-twitter"></i></a> <a href="#"><i
									class="fab fa-instagram"></i></a> <a href="#"><i
									class="fab fa-linkedin-in"></i></a>
							</div>
						</div>
					</div>
				</div>
			</footer>


		</div>
	</div>

</body>
</html>
