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
		<%@include file="../menuUserIncidence.jsp" %>
				
		<c:if test="${!empty message}">
			<div class="messageKO">${message}</div>
		</c:if>
		<br>
		<form:form method="post" modelAttribute="incidence" action="/InmoIOC/addIncidenceUser">
			<table id="noborder">
				<tr>
					<th colspan="2">Gesti� d'Incid�ncies</th>
				</tr>				
		        <tr>
		        	<form:hidden path="id_incidence" />
		        	<form:hidden path="status.id_status" value="1" />
					<td><form:label path="user">Usuari:</form:label></td>
		          	<td>
			          	<form:select name="user" path="user.id_user">
						  <c:forEach items="${userList}" var="ulist">
						    <option value="${ulist.id_user}"
						    	<c:if test="${ulist.id_user eq incidence.user.id_user}"> selected="selected" </c:if>>
						        Nom: ${ulist.name} - Username: ${ulist.username} - Rol: ${ulist.role.description}
						    </option>
						  </c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="description">Descripci�:</form:label></td>
		          	<td>
		          		<form:input path="description" size="100" maxlength="100"></form:input>
		          		<span>* Indiqui qualsevol dada identificativa si disposa d'ella</span>
		          	</td>
				</tr>	
				<tr>
					<td colspan="2">
						<input type="submit" value="Desar" class="button buttonBlack" />
						<input type="reset" value="Buidar" class="button buttonBlack" />
					</td>
				</tr>
			</table> 
		</form:form>
		<hr>
		<h3>Llistat Incid�ncies</h3>
		<span>* En estat "Solucionada": rebr�s un correu electr�nic amb el resultat de la teva incid�ncia.</span><br>		
		<c:if test="${!empty incidenceList}">
			<table class="tg">
			<tr>
				<th width="50">Id</th>
				<th width="100">Descripci�</th>
				<th width="100">Estat Incid�ncia</th>
			</tr>
			<c:forEach items="${incidenceList}" var="incidence">
				<tr>
					<td>${incidence.id_incidence}</td>					
					<td>${incidence.description}</td>
					<td>${incidence.status.status}</td>
				</tr>
			</c:forEach>
			</table>
			<span>* Nom�s es visualitzen les 10 �ltimes incid�ncies</span>
		</c:if>
		<c:if test="${empty incidenceList}">
			<table class="tg"><tr><th>Sense Resultats</th></tr></table>
		</c:if>		
		<%@include file="../footerapp.jsp" %>
	</body>
</html>