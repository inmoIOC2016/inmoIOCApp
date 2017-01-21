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
			
			function confirmDelete() {			    
				var confirmar = confirm("Segur que vols eliminar aquest registre?");
				if (confirmar == true) {			    	
					return true;
				} else {
					return false;
				}			    
			}
			
			function filterAll(){
				window.location.href = '/InmoIOC/pagaments';
			}
			
			function filter(){
				var fid = document.getElementById("fid").value;		
				if(fid == ''){
					filterAll();
				} else {
					if(fid != ''){						
						window.location.href = '/InmoIOC/findPaymentById/' + fid;
					}
				}
			}
		</script>
	</head>	
	<body onload="loadUserData();">
		<%@include file="../menuAdminPayment.jsp" %>
				
		<c:if test="${!empty message}">
			<div class="messageKO">${message}</div>
		</c:if>
		<br>
		<h3>Llistat Pagaments</h3>
		<table id="noborder">
			<tr>
				<th colspan="2">Cercador</th>
			</tr>
			<tr>	
				 <td>Id:</td>
		         <td><input type="number" name="fid" id="fid"/></td>
		    </tr>				
			<tr>
				<td colspan="2">
					<a class="button buttonBlack" href="#" onclick="filterAll();">Mostrar Tots</a>
					<a class="button buttonBlack" href="#" onclick="filter();">Filtrar</a>
				</td>
			</tr>
		</table>		
		<c:if test="${!empty filter}">
			<div class="messageInfo">${filter}</div>
		</c:if>
		<br>
		<c:if test="${!empty sellingList}">
			<table class="tg">
			<tr>
				<th width="50">Id</th>				
				<th width="100">Inmoble Venda</th>
				<th width="50">Preu</th>				
				<th width="100">Data Pagament</th>
				<th width="100">Usuari Pagament</th>
				<!--  <th width="100">Accions</th>-->
			</tr>
			<c:forEach items="${paymentList}" var="payment">
				<tr>
					<td>${payment.id_payment}</td>					
					<td>${payment.selling.property.name}</td>
					<td>${payment.amount}</td>
					<td>${payment.date_payment}</td>					
					<td>Nom: ${payment.selling.userPayment.name} - Username: ${payment.selling.userPayment.username} - Rol: ${payment.selling.userPayment.role.description}</td>
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