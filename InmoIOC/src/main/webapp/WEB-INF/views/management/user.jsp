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
				window.location.href = '/InmoIOC/usuaris';
			}
			
			function filter(){
				var fid = document.getElementById("fid").value;
				var fname = document.getElementById("fname").value;				
				if(fid == '' && fname == ''){
					filterAll();
				} else {
					if(fid != '' && fname != ''){						
						window.location.href = '/InmoIOC/findUser/' + fid + '/' + fname;
					} else {
						if(fid != ''){
							window.location.href = '/InmoIOC/findUserById/' + fid;
						} 						
						if(fname != ''){
							window.location.href = '/InmoIOC/findUserByName/' + fname;
						}						
					}
				}
			}
		</script>
	</head>	
	<body onload="loadUserData();">
		<%@include file="../menuAdminUser.jsp" %>
		
		<%
		HttpSession objSession = request.getSession(true); 
		if ( objSession.getAttribute("rights") != "SuperAdministrador")
		{
			%>
				<p style="color:red">PRIVILEGIS INSUFICIENTS!</p>
			<%
		}
		else
		{
		
		%>

		<c:if test="${!empty message}">
			<div class="messageKO">${message}</div>
		</c:if>
		<br>		
		<form:form method="post" modelAttribute="user" action="/InmoIOC/addUser">
			<table id="noborder">
				<tr>
					<th colspan="2">Gestió d'Usuaris</th>
				</tr>
				<tr>
					<form:hidden path="id_user" />
		          	<td><form:label path="username">Usuari:</form:label></td>
		          	<td><form:input path="username" size="30" maxlength="200"></form:input></td>
		        </tr>
				<tr>
					<td><form:label path="password">Password:</form:label></td>
		          	<td><form:input path="password" size="30" maxlength="200"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="name">Nom Usuari:</form:label></td>
		          	<td><form:input path="name" size="30" maxlength="200"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="email">Email:</form:label></td>
		          	<td><form:input path="email" size="30" maxlength="200"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="role">Rol:</form:label></td>
		          	<td>		          		
		          		<form:select name="role" path="role.id_role">
		          		  <option value=""> - Seleccionar opció -</option>
						  <c:forEach items="${roleList}" var="r">						  
						    <option value="${r.id_role}"						    
						     	<c:if test="${r.id_role eq user.role.id_role}"> selected="selected" </c:if>>
						        ${r.description}
						    </option>
						  </c:forEach>
						</form:select>		          		
		          	</td>
				</tr>
				<tr>
					<td><form:label path="registration_date">Data Registre:</form:label></td>
		          	<td><form:input type="date" path="registration_date" size="30" maxlength="200"></form:input></td>
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
		<h3>Llistat Usuaris</h3>
		<table id="noborder">
			<tr>
				<th colspan="4">Cercador</th>
			</tr>
			<tr>	
				 <td>Id:</td>
		         <td><input type="number" name="fid" id="fid"/></td>				
		         <td>Usuari:</td>
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
		<c:if test="${!empty userList}">
			<table class="tg">
			<tr>
				<th width="50">Id</th>
				<th width="100">Usuari</th>
				<th width="100">Nom Usuari</th>
				<th width="50">Email</th>
				<th width="50">Rol</th>
				<th width="100">Data Registre</th>					
				<th width="100">Accions</th>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.id_user}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.role.description}</td>
					<td>${user.registration_date}</td>
					<td>
						<a class="button buttonBlack buttonTableCell" href="<c:url value='/updateUser/${user.id_user}' />" >Modificar</a>
						<a class="button buttonBlack buttonTableCell" onclick="return confirmDelete();" href="<c:url value='/deleteUser/${user.id_user}' />" >Eliminar</a>
					</td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty userList}">
			<table class="tg"><tr><th>Sense Resultats</th></tr></table>
		</c:if>	
		<%@include file="../footerapp.jsp" %>
		<%
		}
		 %>
		
	</body>
</html>