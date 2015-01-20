<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP OK </title>
</head>
<body>

<h1>Test jstl</h1>

${'ok'}
${request}



<!-- Afficher l'user-agent du navigateur ou "Inconnu" si il est absent : -->
<c:out value="${header['user-agent']}" default="Inconnu"/>

<!-- Même chose en utilisant le corps du tag : -->
<c:out value="${header['user-agent']}">
	Inconnu
</c:out>
</body>
</html>