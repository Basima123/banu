<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.sms.dto.StudentDTO"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
<style>
table, td, th {
	border: 1px solid;
}

table {
	width: 100%;
	border-collapse: collapse;
}
</style>
</head>
<%
ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
if (session.getAttribute("list") != null) {

	list = (ArrayList<StudentDTO>) session.getAttribute("list");
}
%>

<body>
	<h2 align="center">Delete</h2>
	<form action="home.jsp" method="post" style="background-color:">
		<input type="submit" name="back" value="BACK">
	</form>
	<br>
	<br>
	<form action="DeleteController" method="get">
		<table>
			<tr>
				<th></th>
				<th>ID</th>
				<th>Name</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Gender</th>
				<th>Language</th>
				<th>User Name</th>
				<th>Password</th>
				<th>Access</th>
				<th> </th>
				<th> </th>
			</tr>
			<%
			for (StudentDTO dto : list) {
			%>
			<tr>
				<td><input type="checkbox" name="rowkey" id="rowkey" value=<%=dto.getId()%>></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getDob()%></td>
				<td><%=dto.getAddress()%></td>
				<td><%=dto.getGender()%></td>
				<td><%=dto.getLanguage()%></td>
				<td><%=dto.getUserName()%></td>
				<td><%=dto.getPassword()%></td>
				<td><%=dto.getAccess()%></td>
				<td><a href="DeleteController?Id=<%=dto.getId() %>">Delete</a></td>
				<td><a href="UpdateController?Id=<%=dto.getId()%>">Edit</a></td>
				<%
				}
				%>
			</tr>
		</table>
		<br> <input type="submit" name="buttonAction" value="DELETE">
		<input type="submit" name="buttonAction" value="RESET">
	</form>
</body>
</html>
