<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	</head>
	<body>
		<%@include file="../dataUser.jsp" %>
		<hr>
		<%@include file="../menuUser.jsp" %>
		<hr>
		<h2>Consultar/Solicitar Lloguer</h2>
	</body>
</html>