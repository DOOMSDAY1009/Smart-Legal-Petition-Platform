<%@page import="com.org.dao.LawyerDao"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.org.entity.Lawyer"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Record</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background:
		url("img/banner3.jpg");
	height: 50vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	
	<div class="container p-3 m-auto">
		<div class="row">

			<div class="col-md-8 m-auto">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">FILE A NEW LITIGATION</p>
						<c:if test="${empty userObj }">
								<a href="user_login.jsp" class="d-flex justify-content-center title btn-danger border border-warning m-3 p-2">* Please Login To File A New Record *</a>
								<!-- <button class="col-md-6 offset-md-3 btn btn-success">Submit</button> -->
							</c:if>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form class="row g-3" action="appRecord" method="post">

							<input type="hidden" name="userid" value="${userObj.id }">

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Full Name</label> <input
									required type="text" class="form-control" name="fullname">
							</div>

							<div class="col-md-6">
								<label>Gender</label> <select class="form-control" name="gender"
									required>
									<option value="male">Male</option>
									<option value="female">Female</option>
								</select>
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Age</label> <input
									required type="number" class="form-control" name="age">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Record
									Date</label> <input type="date" class="form-control" required
									name="appoint_date">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Email</label> <input
									required type="email" class="form-control" name="email">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Phone No</label> <input
									maxlength="10" required type="number" class="form-control"
									name="phno">
							</div>


							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Title</label> <input
									required type="text" class="form-control" name="title">
							</div>

							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Lawyer</label> <select
									required class="form-control" name="doct">
									<option value="">--select--</option>
									
									<%
									LawyerDao dao = new LawyerDao();
									List<Lawyer> list = dao.getAllLawyers() ;
									for (Lawyer d : list) {
									%>
									<option value="<%=d.getId()%>"><%=d.getFullName()%>
									</option>
									<%
									}
									%>
								</select>
							</div>

							<div class="col-md-12">
								<label>Text</label>
								<textarea required name="text" class="form-control" rows="30"
									cols=""></textarea>
							</div>

							<c:if test="${empty userObj }">
								<a href="user_login.jsp" class="col-md-6 btn btn-info m-auto mt-3">Login Here!</a>
								<!-- <button class="col-md-6 offset-md-3 btn btn-success">Submit</button> -->
							</c:if>

							<c:if test="${not empty userObj }">
								<button class="col-md-6 offset-md-3 btn btn-success">Submit</button>
							</c:if>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<%@include file="component/footer.jsp"%>

</body>
</html>

