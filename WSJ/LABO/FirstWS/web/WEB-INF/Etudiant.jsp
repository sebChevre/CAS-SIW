<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Etudiant</title>
</head>
<body>

<h1>Etudiant test</h1>

<jsp:useBean id="etudiant" class="ws.firstday.bean.Etudiant"></jsp:useBean>

<jsp:setProperty property="nom" name="etudiant" value="tutu"/>
<jsp:setProperty property="enTravail" name="etudiant" value="true"/>
<c:out value="${etudiant.nom}"></c:out>

<c:out value="${etudiantReq.nom}"/>

<c:if test="${etudiantReq.enTravail}">
	<c:out value="En travail"/>
</c:if>

<c:if test="${!etudiantReq.enTravail}">
	<c:out value="En pause"/>
</c:if>

<c:if test="${etudiant.enTravail}">
	<c:out value="En travail"/>
</c:if>

<c:if test="${!etudiant.enTravail}">
	<c:out value="En pause"/>
</c:if>

<c:forEach var="comp" items="${etudiant.competences}">
	<c:out value="${comp}"></c:out>
</c:forEach>

<c:import url="resultats.xml" var="resultatsEtudiants"></c:import>

<x:parse var="doc" xml="${resultatsEtudiants}" />

<x:forEach var="etudiant" select="$doc/resultats/eleve">
      	<x:out select="math" /><br/>
      	<x:out select="fran" /><br/>
    	<x:out select="allemand"/><br/>
</x:forEach>

</body>
</html>