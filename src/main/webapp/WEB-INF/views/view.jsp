<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Game View</title>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/errors.css" />" rel="stylesheet">
	</head>
	<body style="text-align: center;">
		<h1>Game (<c:out value="${game.getId()}"/>)</h1>
		<c:choose>
			<c:when test="${game.isSolved()}">
				<td colspan="2">
					<h2 style="color:#228C22;">Solved!</h2>
				</td>
			</c:when>
			<c:otherwise>
				<form:form modelAttribute="guessCreateForm" action="/bullsandcows/game/${game.getId()}/guess">
					<table style="margin: 0 auto; text-align: center;">
						<tr>
							<td>Guess:</td>
						</tr>
						<tr>
							<td>
								<form:input path="guess"/>
							</td>
						</tr>
						<tr>
							<td>
								<form:errors path="guess" cssClass="error"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="Guess"/>
							</td>
						</tr>
					</table>
				</form:form>
			</c:otherwise>
		</c:choose>
		<c:if test="${game.getGuessList().size() > 0}">
			<h2>Previous guesses:</h2>
			<table style="margin: 0 auto;">
				<c:forEach items="${game.getGuessList()}" var="guess">
					<tr>
						<td><c:out value="${guess.getGuess()}"/></td>
						<td><c:out value="| Bulls: ${guess.getBulls()}"/></td>
						<td><c:out value="| Cows: ${guess.getCows()}"/></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	
		<form action="/bullsandcows">
			<input type="submit" value="Back" />
		</form>
	</body>
</html>