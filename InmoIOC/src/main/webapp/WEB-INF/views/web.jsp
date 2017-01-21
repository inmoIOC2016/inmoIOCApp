<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	</head>
	<body>
		<%@include file="headerweb.jsp" %>		
		<div style="position: relative;">
			<img src="<c:url value="/resources/img/web.jpg" />" height="100%" width="100%">
		  	<div class="info"> Comprar / vendre / Llogar / Trapasar </div>
		  	<div class="info1">És necessari que estiguis registrat a la nostra comunitat. Fes clic a Accés Usuari del menú i introdueix les teves dades d'accés si ja disposes d'usuari o bé registrat.</div>
		</div>
		<%@include file="footer.jsp" %>
	</body>
</html>

