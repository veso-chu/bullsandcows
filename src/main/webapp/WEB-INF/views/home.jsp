<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Homepage</title>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	</head>
	<body>
		<div style="text-align: center;">
			<h1>Bulls and Cows</h1>
			<form action="game/list">
				<input type="submit" value="Find Game" />
			</form>
			<form action="game">
				<input type="submit" value="New Game" />
			</form>
		</div>
	</body>
</html>