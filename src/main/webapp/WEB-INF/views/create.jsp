<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Game</title>
		<style type="text/css">
			.error {
				color: #ff0000;
			}
		</style>
	</head>
	<body style="text-align: center;">
		<h1>New Game</h1>
		<form:form modelAttribute="game">
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

		<form action="/bullsandcows">
		    <input type="submit" value="Back" />
		</form>
	</body>
</html>