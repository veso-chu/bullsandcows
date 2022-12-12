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
			<a href="game/list">Find Game</a>
			<a href="game">New Game</a>
		</div>
	</body>
</html>