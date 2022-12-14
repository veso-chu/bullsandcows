<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Game List</title>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	</head>
	<body style="text-align: center;">
		<h1>Created Games (<c:out value="${games.size()}"/>)</h1>
		<c:if test="${games.size() > 0}">
			<table style="margin: 0 auto; text-align: center;">
	    		<c:forEach items="${games}" var="game">
					<tr>
						<td>
							<a href="/game/${game.getId()}"><c:out value="Game(${game.getId()})"/></a>
						</td>
					</tr>
				</c:forEach>
	    	</table>
		</c:if>

		<form action="/">
		    <input type="submit" value="Back" />
		</form>
	</body>
</html>