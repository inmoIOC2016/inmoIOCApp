<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head>
			<link href="<c:url value="/resources/css/mainpage.css" />" rel="stylesheet">
	</head>
	<body  style="background: url(<c:url value="/resources/img/yellowbackground.png" />);  background-size: cover;">
		<%@include file="header.jsp" %>
		<hr>
		<div>center</div>
		<%@include file="footer.jsp" %>
		<hr>
	</body>
</html>