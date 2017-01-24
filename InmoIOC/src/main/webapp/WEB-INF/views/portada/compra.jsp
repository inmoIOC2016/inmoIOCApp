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

function filter(){
var filter_price = document.getElementsByName('filter_price');
var filter_category = document.getElementsByName('filter_category');
var filter_city = document.getElementsByName('filter_city');
var product_count = document.getElementById('product_count');
var price = -1;
var category = "";
var city = "";
var minprice = -1;
var maxprice = 9999999;
var counter = 0;
var product_line = document.getElementsByClassName('product_line');
for (var i = 0, length = filter_price.length; i < length; i++) {
    if (filter_price[i].checked) {
        price = filter_price[i].value;
        break;
    }
}
for (var i = 0, length = filter_category.length; i < length; i++) {
    if (filter_category[i].checked) {
    	category = filter_category[i].value;
        break;
    }
}
for (var i = 0, length = filter_city.length; i < length; i++) {
    if (filter_city[i].checked) {
    	city = filter_city[i].value;
        break;
    }
}
if (price == 1){maxprice = 40000;}
else if (price == 2){minprice = 40000; maxprice = 80000;}
else if (price == 3){minprice = 80000; maxprice = 120000;}
else if (price == 4){minprice = 120000; maxprice = 160000;}
else if (price == 5){minprice = 160000;}
for (var i = 0, length = product_line.length; i < length; i++) {
    if (product_line[i].dataset.price < minprice || product_line[i].dataset.price > maxprice || (city != "" && product_line[i].dataset.city != city) || (category != "" && product_line[i].dataset.category != category)) {
    	product_line[i].style.display = "none";
    }
    else 
    {
    	product_line[i].style.display = "block";
    	counter++;
    }
}
product_count.innerHTML = "Hi han " + counter + " inmobles.";
	
}

</script>


</head>
    
	<body  style="background: #222 url(<c:url value="/resources/img/fondoalternativo.jpg" />) top center no-repeat fixed; ">
		<%@include file="dataClientPortada.jsp" %>
		
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
        <span><b>Preu</b></span><br>
        <input type="radio"  name="filter_price" value="1" onclick="filter()"/>menys de 40.000€<br>
        <input type="radio"  name="filter_price" value="2" onclick="filter()"/>40.000€ - 80.000€<br>
        <input type="radio"  name="filter_price" value="3" onclick="filter()"/>80.000€ - 120.000€<br>
        <input type="radio"  name="filter_price" value="4" onclick="filter()"/>120.000€ - 160.000€<br>
        <input type="radio"  name="filter_price" value="5" onclick="filter()"/>més de 160.000€<br>
        <br>
         <span><b>Tipus</b></span><br>
         <c:forEach items="${categoryList}" var="category">
         <input type="radio"  name="filter_category" value="${category.name}" onclick="filter()"/>${category.name}<br>
         </c:forEach>
         <span><b>Ciutat</b></span><br>
         <c:forEach items="${citiesList}" var="city">
         <input type="radio"  name="filter_city" value="${city.city}" onclick="filter()"/>${city.city}<br>
         </c:forEach>
        </div>
        </div>
		</div>
		<div id="columna_centre">
		<h3>Compra</h3>
		<div id="product_count">Hi han ${propertyList.size()} inmobles</div>
		<ul style="list-style-type: none;">
		<c:forEach items="${propertyList}" var="property">
		<li class="product_line" data-city="${property.city.city}" data-price="${property.base_price}" data-category="${property.category.name}">
		<div style="position: relative;">
			<div class="product_line_left">
				<div style="float:left;"><a href="/InmoIOC/productpage/<c:out value="${property.id_property}"/>") class="product_img_link">
				<img src="data:image/jpg;base64,<c:out value='${property.getbase64()}'/>" width="170" height="128" src="" alt=""/>	
				</a></div>
				<div class="product_line_description">
    	<h3><c:out value="${property.name}"/></h3>		
    	<p class="product_line_desc">
    	<strong><c:out value="${property.city.city}"/></strong></p></div>
        <div class="clear"></div>
			</div>
			<div class="product_line_right">
				<div>
					<span class="preu">${property.base_price}€</span>
				</div>
				<a class="button-mes product_button" href="/InmoIOC/productpage/<c:out value="${property.id_property}"/>")>Veure detalls</a>		
			</div>
            
                    <div class="clear"></div>

			</div>
		</li>
		</c:forEach>
		</ul>
		</div>
        
        <div class="clear"></div>
        
        
		</div>
		<%@include file="footer.jsp" %>
<div class="clear"></div>
	</div>
	</body>
</html>