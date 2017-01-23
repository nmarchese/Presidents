<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Presidents</title>
<link rel="stylesheet" type="text/css" href="./presidentCSS.css">
<link href="https://fonts.googleapis.com/css?family=Merienda" rel="stylesheet">
</head>
<body>
	<div id="everything">
		<div class="text" id="name"><c:out value="${president.name}"></c:out></div>
		<div id="presPic">
	    	<img src="${president.imgUrl}"/>
	    </div><br>
	    <div id="info">
	    		<div class="text" id="years">In Office: <c:out value="${president.dates}"></c:out></div>
	    		<div class="text" id="party">Political Party: <c:out value="${president.party}"></c:out></div>
	    		<div class="text" id="fact">Fun Fact: <c:out value="${president.fact}"></c:out></div>
	    </div> <br>
	    <form action="president.do" method="GET">
		    	<c:if test="${term != 1}">
		    		<button name="nav" value="previous">Previous</button>
		    	</c:if>
		    	<c:if test="${term == 1}">
		    		<button class="inactive" disabled>Previous</button>
		    	</c:if>
		    <span>Jump to Term: </span><input type="number" name="searchTerm" min="1" max="45" step="1">
		    	<input type="submit" value="GO">
		    	<c:if test="${term != 45}">
		    		<button name="nav" value="next">Next</button>
		    	</c:if>
		    	<c:if test="${term == 45}">
		    		<button class="inactive" disabled>Next</button>
		    	</c:if>
	    </form>
    </div>
</body>
</html>