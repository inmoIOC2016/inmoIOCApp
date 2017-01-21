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
				window.location.href = '/InmoIOC/incidencies';
			}
			
			function filter(){
				var fid = document.getElementById("fid").value;
				var fname = document.getElementById("fname").value;				
				if(fid == '' && fname == ''){
					filterAll();
				} else {
					if(fid != '' && fname != ''){						
						window.location.href = '/InmoIOC/findIncidence/' + fid + '/' + fname;
					} else {
						if(fid != ''){
							window.location.href = '/InmoIOC/findIncidenceById/' + fid;
						} 						
						if(fname != ''){
							window.location.href = '/InmoIOC/findIncidenceByName/' + fname;
						}						
					}
				}
			}
		</script>
	</head>	
	<body onload="loadUserData();">
		<%@include file="../menuAdminIncidence.jsp" %>
				
		<c:if test="${!empty message}">
			<div class="messageKO">${message}</div>
		</c:if>
		<br>		
		<form:form method="post" modelAttribute="incidence" action="/InmoIOC/addIncidence">
			<table id="noborder">
				<tr>
					<th colspan="2">Gestió d'Incidències</th>
				</tr>				
		        <tr>
		        	<form:hidden path="id_incidence" />
					<td><form:label path="user">Usuari:</form:label></td>
		          	<td>
			          	<form:select name="user" path="user.id_user">
			          	  <option value=""> - Seleccionar opció -</option>
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
					<td><form:label path="description">Descripció:</form:label></td>
		          	<td><form:input path="description" size="100" maxlength="100"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="status">Estat incidència:</form:label></td>
		          	<td>		          		
		          		<form:select name="status" path="status.id_status">
		          		  <option value=""> - Seleccionar opció -</option>
						  <c:forEach items="${incidenceStatusList}" var="st">
						    <option value="${st.id_status}"						    
						     	<c:if test="${st.id_status eq incidence.status.id_status}"> selected="selected" </c:if>>
						        ${st.status}
						    </option>
						  </c:forEach>
						</form:select>		          		
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
		<h3>Llistat Incidències</h3>
		<table id="noborder">
			<tr>
				<th colspan="4">Cercador</th>
			</tr>
			<tr>	
				 <td>Id:</td>
		         <td><input type="number" name="fid" id="fid"/></td>				
		         <td>Descripció:</td>
		         <td><input type="text" name="fname" id="fname"/></td>
		    </tr>				
			<tr>
				<td colspan="4">
					<a class="button buttonBlack" href="#" onclick="filterAll();">Mostrar Tots</a>
					<a class="button buttonBlack" href="#" onclick="filter();">Filtrar</a>
				</td>
			</tr>
		</table>		
		<c:if test="${!empty filter}">
			<div class="messageInfo">${filter}</div>
		</c:if>
		<br>
		<c:if test="${!empty incidenceList}">
			<table class="tg">
			<tr>
				<th width="50">Id</th>
				<th width="100">Usuari</th>
				<th width="100">Descripció</th>
				<th width="100">Estat Incidència</th>
				<th width="100">Accions</th>
			</tr>
			<c:forEach items="${incidenceList}" var="incidence">
				<tr>
					<td>${incidence.id_incidence}</td>
					<td>Nom: ${incidence.user.name} - Username: ${incidence.user.username} - Rol: ${incidence.user.role.description}</td>
					<td>${incidence.description}</td>
					<td>${incidence.status.status}</td>
					<td>
						<c:if test="${incidence.status.id_status != 3 && incidence.status.id_status != 4}">
							<a class="button buttonBlack buttonTableCell" href="<c:url value='/updateIncidence/${incidence.id_incidence}' />" >Modificar</a>
							<a class="button buttonBlack buttonTableCell" onclick="return confirmDelete();" href="<c:url value='/deleteIncidence/${incidence.id_incidence}' />" >Eliminar</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty incidenceList}">
			<table class="tg"><tr><th>Sense Resultats</th></tr></table>
		</c:if>	
		<%@include file="../footerapp.jsp" %>
	</body>
</html>