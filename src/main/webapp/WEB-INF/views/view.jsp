<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Game View</title>
	</head>
	<body style="text-align: center;">
		<h1>Game (<c:out value="${game.getId()}"/>)</h1>
		<c:choose>
			<c:when test="${game.isSolved()}">
				<td colspan="2">
					<h2>Solved!</h2>
				</td>
			</c:when>
			<c:otherwise>
				<form action="/bullsandcows/game/${game.getId()}">
					<table style="margin: 0 auto;">
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
			</c:otherwise>
		</c:choose>
		<c:if test="${game.getGameInfo().getGuesses().size() > 0}">
			<h2>Previous guesses:</h2>
			<table style="margin: 0 auto;">
				<c:forEach items="${game.getGameInfo().getGuesses()}" var="guess">
					<tr>
						<td><c:out value="${guess.getGuess()}"/></td>
						<c:forEach items="${guess.getGuessResult()}" var="guessResult">
							<td><c:out value="| ${guessResult.getKey()}:${guessResult.getValue()}"/></td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	
		<form action="/bullsandcows">
			<input type="submit" value="Back" />
		</form>
	</body>
</html>