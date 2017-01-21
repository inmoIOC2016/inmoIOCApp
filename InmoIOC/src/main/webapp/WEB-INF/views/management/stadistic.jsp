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
		<br>
		<h3>Estadístiques</h3>	
		<br>
		<c:if test="${!empty total}"><strong>Total d'inmobles a la venda:</strong> ${total}</c:if><br>
		<c:if test="${!empty totalReal}"><strong>Total d'inmobles venuts, llogats o traspassats:</strong> ${totalReal}</c:if><br>		
		<c:if test="${!empty percent}"><strong>Percentatge de venda: </strong>${percent} %</c:if>
		<br><br>	
		<c:if test="${!empty totalPayment}"><strong>Total facturat: </strong>${totalPayment} &euro;</c:if>
		<br>				
		<%@include file="../footerapp.jsp" %>
	</body>
</html>