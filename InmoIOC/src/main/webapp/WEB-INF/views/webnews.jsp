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
			<h3>Notícies</h3>
			<p class="newstitle">- (02/01/2017 - 11:11 CET) La vivienda nueva se encarece un 3,3% en 2016</p>
			<p class="newstitle">- (02/01/2017 - 08:36 CET) Merlin vende su cartera hotelera a una inmobiliaria francesa por 535 millones</p>
			<p class="newstitle">- (31/12/2016 - 19:36 CET) Qué va a pasar con la vivienda en 2017: más obra nueva e hipotecas más caras</p>
			<p class="newstitle">- (30/12/2016 - 23:45 CET) El precio de la vivienda sube un 0,8% en el último trimestre</p>
		</div>
		
		<%@include file="footer.jsp" %>
	</body>
</html>

