<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Game</title>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/errors.css" />" rel="stylesheet">
	</head>
	<body style="text-align: center;">
		<h1>New Game</h1>
		<form:form modelAttribute="gameCreateForm">
			<table style="margin: 0 auto; text-align: center;">
				<tr>
					<td>Goal:</td>
				</tr>
				<tr>
					<td>
						<form:input path="goal"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:errors path="goal" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Create game"/>
					</td>
				</tr>
			</table>
		</form:form>

		<form action="/">
		    <input type="submit" value="Back" />
		</form>
	</body>
</html>