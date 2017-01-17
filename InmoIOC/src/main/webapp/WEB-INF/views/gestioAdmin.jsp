<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
		<script>
			function loadUserData() {
				sessionStorage["userName"] = "<c:out value='${userName}' />";								
			}				
		</script>
	</head>
	<body onload="loadUserData();">
		<%@include file="menuAdmin.jsp" %>
		<br><br><br>
		<img src="<c:url value="/resources/img/welcome.jpg" />">
		<br><br><br>
		<span>Benvingut!! Selecciona una opció del menú per començar a treballar.</span>
		<%@include file="footerapp.jsp" %>
	</body>
</html>