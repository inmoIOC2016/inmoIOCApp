<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
		<script>
			function loadUserData() {
				sessionStorage["userName"] = "<c:out value='${userName}' />";
				window.location.href = 'http://localhost:8080/InmoIOC/principal';
			}				
		</script>
	</head>
	<body onload="loadUserData();">		

	</body>
</html>