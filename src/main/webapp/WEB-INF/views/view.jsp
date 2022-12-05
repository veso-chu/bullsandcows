<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Game View</title>
	</head>
	<body>
		<h1>Game (${game.getId()})</h1>
		
		<form:form modelAttribute="game">
			<table>
				<tr>
					<td>Guess:</td>
				</tr>
				<tr>
					<td>
						<form:input path="goal"/>
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