<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	</head>	
	<body>
		<%@include file="../dataUser.jsp" %>
		<hr>
		<%@include file="../menuAdmin.jsp" %>
		<hr>
		<h2>USUARIS</h2>
		
		<c:if test="${!empty message}">
			<table>
				<tr><th class="message">${message}</th></tr>
			</table>
		</c:if>
		<br>		
		<form:form method="post" modelAttribute="user" action="/InmoIOC/addUser">
			<table>
				<tr>
					<th colspan="2">Usuari</th>
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
					<td><form:label path="email">Email:</form:label></td>
		          	<td><form:input path="email" size="30" maxlength="200"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="rights">Rol:</form:label></td>
		          	<td><form:input path="rights" size="30" maxlength="200"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="registration_date">Data Registre:</form:label></td>
		          	<td><form:input path="registration_date" size="30" maxlength="200"></form:input></td>
				</tr>				
				<tr>
					<td colspan="2">
						<input type="submit" value="Desar" />
						<input type="reset" value="Buidar">
					</td>
				</tr>
			</table> 
		</form:form>
		<br>
		<h3>Llistat Usuaris</h3>
		<c:if test="${!empty userList}">
			<table class="tg">
			<tr>
				<th width="50">Id</th>
				<th width="100">Usuari</th>
				<th width="100">Password</th>
				<th width="50">Email</th>
				<th width="50">Rol</th>
				<th width="100">Data Registre</th>					
				<th width="50">Modificar</th>
				<th width="50">Eliminar</th>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.id_user}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.email}</td>
					<td>${user.rights}</td>
					<td>${user.registration_date}</td>			
					<td><a href="<c:url value='/updateUser/${user.id_user}' />" >Modificar</a></td>
					<td><a href="<c:url value='/deleteUser/${user.id_user}' />" >Eliminar</a></td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
	</body>
</html>