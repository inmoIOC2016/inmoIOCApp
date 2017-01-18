<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
		<ul style="list-style-type: none;">
		<li class="product_line"><h3>casa 1</h3> Preu, imatge etc...</li>
		<li class="product_line"><h3>casa 2</h3> Preu, imatge etc...</li>
		<li class="product_line"><h3>casa 3</h3> Preu, imatge etc...</li>
		<li class="product_line"><h3>casa 4</h3> Preu, imatge etc...</li>
		<li class="product_line"><h3>casa 5</h3> Preu, imatge etc...</li>
		</ul>
		</div>
		</div>
		<%@include file="footer.jsp" %>
	</div>
	</body>
</html>