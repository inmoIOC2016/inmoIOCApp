<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
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
		<%@include file="../menuUserSellUser.jsp" %>
				
		<c:if test="${!empty message}">
			<div class="messageKO">${message}</div>
		</c:if>
		<br>		
		<hr>
		<h3>Llistat dels meus immobles en Venda</h3>
		<span>* Immobles publicats validats</span><br>
		<span>** En estat de venda "Reservat": InmoIOC es posarà en contacte amb vostè per realitzar els tràmits</span>
		<c:if test="${!empty sellingList}">
			<table class="tg">
			<tr>
				<th width="50">Id</th>
				<th width="100">Inmoble</th>
				<th width="50">Preu</th>
				<th width="50">Tipus Venda</th>
				<th width="100">Data Inici</th>
				<th width="100">Data Fi</th>
				<th width="100">Estat Venda</th>
				<th width="100">Accions</th>
			</tr>
			<c:forEach items="${sellingList}" var="selling">
				<tr>
					<td>${selling.id_selling}</td>
					<td>${selling.property.name}</td>
					<td>${selling.expected_price}</td>
					<td>${selling.sellType.name}</td>
					<td>${selling.date_start}</td>
					<td>${selling.date_end}</td>
					<td>${selling.status.status}</td>
					<td>
						
					</td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty sellingList}">
			<table class="tg"><tr><th>Sense Resultats</th></tr></table>
		</c:if>	
		<%@include file="../footerapp.jsp" %>
	</body>
</html>