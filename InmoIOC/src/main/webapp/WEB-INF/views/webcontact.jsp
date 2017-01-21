<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	</head>
	<body>
		<%@include file="headerweb.jsp" %>
		
		<div>
			<h3>Contacte</h3>
			<strong>Central</strong><br><br>
			
			Passeig Gràcia, 365
			08007 BARCELONA
			932189543
			
			<br><br><img src="<c:url value="/resources/img/bcn.jpg" />" width="250px" height="250px">	
			
			<br><br><strong>Delegacions</strong><br><br>
			
			Carrer de Mallorca, 45
			08007 BARCELONA
			934567823
			
			<br><br><img src="<c:url value="/resources/img/bcn1.jpg" />" width="250px" height="250px"><br><br>
			
			Cervantes 17
			16004 CUENCA
			969221457
			
			<br><br><img src="<c:url value="/resources/img/cu.jpg" />" width="250px" height="250px">
			
		</div>
		
		<%@include file="footer.jsp" %>
	</body>
</html>

