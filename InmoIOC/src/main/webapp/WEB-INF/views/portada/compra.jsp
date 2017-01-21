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


<link rel="manifest" href="/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">

</head>
    
	<body  style="background: #222 url(<c:url value="/resources/img/fondoalternativo.jpg" />) top center no-repeat fixed; ">
	<div id="page">
		<%@include file="header.jsp" %>
		<div id="content">
		<div id="columna_esquerra">
		<h4 id="header_buscador">
                <img src="<c:url value="/resources/img/lupa.png" />" width="28" height="28" style="position:absolute;">
                <span style="padding-left: 33px;">Buscar per...</span>
        </h4>
        <div id="barra_buscador">
        <div style="padding: 8px 8px 8px 8px;">
        <span><b>filler</b></span><br>
        <input type="checkbox" />5<br>
        <input type="checkbox" />5<br>
        <input type="checkbox" />5
        </div>
        </div>
		</div>
		<div id="columna_centre">
		<h3>Compra</h3>
		<div id="product_count">Hi ha X productes</div>
		<ul style="list-style-type: none;">
		<li class="product_line">
		<div style="position: relative;">
			<div class="product_line_left">
				<div style="float:left;"><a href="" class="product_img_link">
					<img class="product_line_image" width="170" height="128" src="" alt="">	
				</a></div>
				<div style="float:right; padding:10px;">
    	<h3>Pis Lloguer Zona Palau</h3>		
    	<p class="product_line_desc">
    	<strong>Girona</strong></p></div>
        <div class="clear"></div>
			</div>
			<div class="product_line_right">
				<div>
					<span class="preu">25.000 €</span>
				</div>
				<a class="button-mes product_button" href="http://www.www.www">Veure detalls</a>		
			</div>
            
                    <div class="clear"></div>

			</div>
		</li>
		<li class="product_line"><h3>casa 2</h3> Preu, imatge etc...</li>
		<li class="product_line"><h3>casa 3</h3> Preu, imatge etc...</li>
		<li class="product_line"><h3>casa 4</h3> Preu, imatge etc...</li>
		<li class="product_line"><h3>casa 5</h3> Preu, imatge etc...</li>
		</ul>
		</div>
        
        <div class="clear"></div>
        
        
		</div>
		<%@include file="footer.jsp" %>
<div class="clear"></div>
	</div>
	</body>
</html>