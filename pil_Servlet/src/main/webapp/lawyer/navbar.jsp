<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg bg-light text-dark">
	<div class="container-fluid">
		<div class="logo">
			<a href="index.jsp"><img src="../assets/img/logo/logo.png" alt=""></a>
		</div>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button> 
		<div class="collapse navbar-collapse d-flex justify-content-end " id="navbarSupportedContent">
			<ul class="navbar-nav m-2">
				<li class="nav-ite "><a class="nav-link" href="index.jsp">HOME</a></li>
				<li class="nav-item"><a class="nav-link" href="user.jsp">CASES</a></li>
				<li class="nav-item"><a class="nav-link" href="emergency.jsp">ARCHIVE</a></li>
			</ul>

			<form class="d-flex">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						aria-expanded="false">
						<i class="fas fa-user-circle"></i> ${doctObj.fullName }
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<li><a class="dropdown-item" href="edit_profile.jsp">Edit
								Profile</a></li>
						<li><a class="dropdown-item" href="../lawyerLogout">Logout</a></li>
					</ul>
				</div>
			</form>
		</div>
	</div>
</nav>
