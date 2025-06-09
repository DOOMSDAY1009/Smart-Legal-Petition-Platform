<%@page import="com.org.entity.Lawyer"%>
<%@page import="com.org.dao.LawyerDao"%>
<%@page import="com.org.entity.Record"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.RecordDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
.backImg {
	background:
		url("../img/banner.jpg");
	height: 50vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	
	<div class="col-md-12 mt-4 m-auto">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Public Interest Litigation (PIL) Cases Filed</p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Record</th>
							<th scope="col">Email</th>
							<th scope="col">Mob No</th>
							<th scope="col">title</th>
							<th scope="col">Lawyer Name</th>
							<th scope="col">text</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>
						<%
						RecordDao dao = new RecordDao();
						LawyerDao dao2 = new LawyerDao();
						List<Record> list = dao.getAllRecord();
						for (Record ap : list) {
							Lawyer d = dao2.getLawyersById(ap.getLawyerId());
						%>
						<tr>
							<th><%=ap.getFullName()%></th>
							<td><%=ap.getGender()%></td>
							<td><%=ap.getAge()%></td>
							<td><%=ap.getrecordDate()%></td>
							<td><%=ap.getEmail()%></td>
							<td><%=ap.getPhNo()%></td>
							<td><%=ap.gettitle()%></td>
							<td><%=d.getFullName()%></td>
							<td><%=ap.gettext()%></td>
							<td><%=ap.getStatus()%></td>
						</tr>
						<%
						}
						%>


					</tbody>
				</table>

			</div>
		</div>
	</div>
	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
</body>
</html>
