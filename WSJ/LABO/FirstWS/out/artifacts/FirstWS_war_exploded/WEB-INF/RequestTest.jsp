<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Request JSP - Servlet</title>
</head>
<body>

	<h1>Ajout de valeur dans la requete</h1>
	<form action="RequestTest" method="POST">
		<label>Paramètres:</label>
		<input name="request_param_name" type="text"/>
		
		<label>Valeur:</label>
		<input name="request_param_value" type="text"/>
		
		<input type="submit"/>
	</form>
	
	
	<c:if test="${!empty param}">
		<div id="requestContentZone">
			<h1>Contenu de la requête</h1>
			
			<span id="requestContent">
			
				<c:forEach var="pageParameter" items="${param}">
			        <li> <c:out value="${pageParameter.key}" /> = <c:out value="${pageParameter.value}" />
			    </c:forEach>
			</span>
			
		</div>
	</c:if>
	
	<h1>Ajout de valeur dans la session</h1>
	<form action="SessionTest" method="POST">
		<label>Paramètres:</label>
		<input name="session_param_name" type="text"/>
		
		<label>Valeur:</label>
		<input name="session_param_value" type="text"/>
		
		<input type="submit"/>
	</form>
	
</body>
</html>