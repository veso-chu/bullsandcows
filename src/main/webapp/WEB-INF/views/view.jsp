<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Game View</title>
	</head>
	<body>
		<h1>Game (<c:out value="${game.getId()}"/>)</h1>
		
		<form action="/bullsandcows/game/${game.getId()}">
			<table>
				<tr>
					<td>Guess:</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="guess"/>
					</td>
				</tr>
				<c:if test="${guessResult != null}">
					<c:forEach items="${guessResult}" var="result">
						<tr>
							<td><c:out value="${result.getKey()}: ${result.getValue()}"/></td>
						</tr>
					</c:forEach>
				</c:if>
				<tr>
					<td colspan="2">
						<input type="submit" value="Guess"/>
					</td>
				</tr>
			</table>
		</form>
	
		<form action="/bullsandcows">
			<input type="submit" value="Back" />
		</form>
	</body>
</html>