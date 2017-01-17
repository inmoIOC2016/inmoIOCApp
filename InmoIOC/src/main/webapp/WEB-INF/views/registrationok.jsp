<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	</head>	
	<body>
		<%@include file="header.jsp" %>
		<div class="messageOK">Registre d'usuari realitzat correctament</div>
		<br>		
		<form:form method="post" modelAttribute="user"></form:form>
		<div>
			<a href="<c:url value='/login' />" class="button buttonBlack" >Tornar</a>			
		</div>
		<%@include file="footer.jsp" %>
	</body>
</html>