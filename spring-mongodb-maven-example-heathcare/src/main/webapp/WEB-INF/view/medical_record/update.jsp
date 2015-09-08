<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/medical_record.png"></img>
	</a>
	<h1>Edit Medical History</h1>
	</head> 
	<body>
	<h2>Medical History</h2>
	<table border="1">
	<tr>
          <td>Question </td>
          <td>Answer</td>
          <td>Option</td>
    </tr>
	<c:forEach items="${questionAnswerMap}" var="qa">
            <tr>
                <td>${qa.question.question}</td>
                <td>${qa.answer.answer}</td>
                <td><a href="${pageContext.servletContext.contextPath}/answer/update/${patientId}/${qa.answer.id}">Answer</a></td>
            </tr>
    </c:forEach>
	</table>
	</body>
</html>