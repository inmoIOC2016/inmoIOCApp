<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page pageEncoding="UTF-8"%>

<html>
	<head>
			<link href="<c:url value="/resources/css/mainpage.css" />" rel="stylesheet">
	</head>
	<body  style="background: #222 url(<c:url value="/resources/img/fondoalternativo.jpg" />) top center no-repeat fixed; ">
	<div id="page">
	
		<%@include file="header.jsp" %>
		<hr>
		<div style="display: inline-block;">
		<div id="columna_esquerra">
		<h4 id="header_buscador">
                <img style="position:absolute;" src="<c:url value="/resources/img/lupa.png" />">
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
		<h3 style="margin-left: 40px;">Compra</h3>
		<div id="product_count">Hi ha X productes</div>
		<ul style="list-style-type: none;">
		
		<c:if test="${!empty propertyList}">
		<c:forEach items="${propertyList}" var="property">
		<li class="product_line">
		<div style="position: relative;">
			<div class="product_line_left">
				<div style="float:left;"><a href="" class="product_img_link">
					<img class="product_line_image" width="170" height="128" src="" alt="">	
				</a></div>
				<div style="float:right;"><h3><a href="">Nom del pis</a></h3>		
    	<p class="product_line_desc">
    	<strong>CIUTAT</strong></p></div>
			</div>
			<div class="product_line_right">
				<div>
					<span style="display: inline;">25.000 €</span><br>
				</div>
				<a class="product_button" href="http://www.www.www">Veure detalls</a>		
			</div>
			</div>
		</li>
		</c:forEach>
		</c:if>
		
		</ul>
		</div>
		</div>
		<%@include file="footer.jsp" %>
	</div>
	</body>
</html>