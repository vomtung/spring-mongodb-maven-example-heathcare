<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/medical_record.png" width="100%"></img></a>
	</head> 
	<body>
	<table>
	<form:form method="post" commandName="prescription" action="${pageContext.servletContext.contextPath}/prescription/add">
		<tr>
      		<td>Patient:</td>
      		<td><form:select path="patient.id" items="${patientList}" itemLabel="patientId" itemValue="id" /></td>
  		</tr>
  		<tr>
      		<td>Doctor:</td>
      		<td><form:select path="doctor.id" items="${doctorList}" itemLabel="employeeId" itemValue="id"/></td>
  		</tr>
  		<tr>
			<td>Description</td>
			<td><form:textarea path="description"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save"></td>
		</tr>
	</form:form> 
	</table>
	</body>
</html>
