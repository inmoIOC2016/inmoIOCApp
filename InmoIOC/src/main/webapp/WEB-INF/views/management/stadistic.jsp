<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
		<script>
			function loadUserData() {
				var userNameItem = document.getElementById('userNameItem');
				var userName = sessionStorage.getItem("userName");
				if(userName == null){
					window.location.href = 'http://localhost:8080/InmoIOC/login';
				} else {
					userNameItem.innerHTML += '<span style="color:white;">'+userName+'</span>';
				}
			}
			
			function disconnect() {
				sessionStorage.clear()
				return true;
			}								
		</script>
	</head>
	<body onload="loadUserData();">
		<%@include file="../menuAdminStadistic.jsp" %>			
		
		<%@include file="../footerapp.jsp" %>
	</body>
</html>