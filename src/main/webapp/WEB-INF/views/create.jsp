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
			
			.errorblock {
				color: #000;
				background-color: #ffEEEE;
				border: 3px solid #ff0000;
				padding: 8px;
				margin: 16px;
			}
		</style>
	</head>
	<body>
		<h1>New Game</h1>
		<form:form modelAttribute="game">
			<table>
				<tr>
					<td>Goal:</td>
				</tr>
				<tr>
					<td>
						<form:input path="goal"/>
					</td>
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