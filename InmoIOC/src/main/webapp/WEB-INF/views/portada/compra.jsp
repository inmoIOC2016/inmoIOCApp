<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head>
			<link href="<c:url value="/resources/css/mainpage.css" />" rel="stylesheet">
	</head>
	<body  style="background: url(<c:url value="/resources/img/yellowbackground.png" />);  background-size: cover;">
	<div id="page">
	
		<%@include file="header.jsp" %>
		<hr>
		<div>
		<ul style="list-style-type: none;">
		<li class="product_line"><h3>casa 1</h3> Preu, imatge etc...</li>
		<li class="product_line"><h3>casa 2</h3> Preu, imatge etc...</li>
		<li class="product_line"><h3>casa 3</h3> Preu, imatge etc...</li>
		<li class="product_line"><h3>casa 4</h3> Preu, imatge etc...</li>
		<li class="product_line"><h3>casa 5</h3> Preu, imatge etc...</li>
		</ul>
		</div>
		<%@include file="footer.jsp" %>
		<hr>
	</div>
	</body>
</html>