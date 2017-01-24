<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">

<title>InmoIOC - La teva inmobiliaria online</title>
<meta name="description" content="La teva inmobiliaria de confiança online. Troba la casa dels teus somnis o el pis de lloguer que busques.">
<meta name="keywords" content="inmobiliaria, pisos lloguer, compra casa, casa lloguer, lloguer, compra pis, compra local, lloguer loca">
<meta name="robots" content="index,follow">
<meta name="viewport" content="width=device-width, minimum-scale=0.25, maximum-scale=1.6, initial-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">

<link href="<c:url value="/resources/css/mainpage.css" />" rel="stylesheet">


<link rel="apple-touch-icon" sizes="57x57" href="/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72" href="/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76" href="/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114" href="/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120" href="/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144" href="/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152" href="/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180" href="/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"  href="/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32" href="/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96" href="/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16" href="/favicon-16x16.png">
<link rel="manifest" href="/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">

<script>
function confirmReserve(idSelling) {			    
	var confirmar = confirm("Segur que vols reservar aquest inmoble?");
	if (confirmar == true) {			    	
		reserve(idSelling);
	} else {
		return false;
	}			    
}

function reserve(idSelling){
	var userName = sessionStorage.getItem("userName");
	window.location.href = '/InmoIOC/updateSellingReserve/' + idSelling + '/' + userName;				
}

</script>

</head>
    
	<body  style="background: #222 url(<c:url value="/resources/img/fondoalternativo.jpg" />) top center no-repeat fixed; ">
		<%@include file="dataClientPortada.jsp" %>
		
	<div id="page">
		<%@include file="header.jsp" %>
		<div id="content" align="center">
		<div style="background-color:#D1D1D1">
		<h3> <c:out value="${property.name}"/></h3>		
		<p class="product_line_desc">
    	<strong><c:out value="${property.city.city}"/>, <c:out value="${property.address}"/></strong></p>
    	</div>
		<img src="data:image/jpg;base64,<c:out value='${property.getbase64()}'/>" width="370" height="288" src="" alt=""/>	
		<br><span><strong>Preu: ${property.base_price}€</strong></span>
		<br>
<%
if (objSession.getAttribute("rights") != null && objSession.getAttribute("rights") != "")
{
	 %>
	 <div style="margin-top:10px">
					<a class="button-mes"
							onclick="return confirmReserve(${selling.id_selling});"
							href="#">Reservar</a>
	</div>
	 <% 
}

%>
		<div style="background-color:#D1D1D1;margin-bottom:8px">
		
		<h3>Dades de contacte</h3>
		${property.contact}
		</div>


		</div>
		<%@include file="footer.jsp" %>
		<div class="clear"></div>
	</div>
	</body>
</html>