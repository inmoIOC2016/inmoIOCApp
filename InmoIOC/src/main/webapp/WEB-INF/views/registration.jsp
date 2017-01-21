<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	</head>	
	<body>
		<%@include file="header.jsp" %>		
		<c:if test="${!empty message}">
			<div class="messageKO">${message}</div>
		</c:if>
		<br>		
		<form:form method="post" modelAttribute="user" action="/InmoIOC/addUserRegistration">
			<table id="noborder">
				<tr>
					<th colspan="2">Registre d'usuari</th>
				</tr>
				<tr>
					<form:hidden path="id_user" />
		          	<td><form:label path="username">Usuari:</form:label></td>
		          	<td><form:input path="username" size="30" maxlength="200"></form:input></td>
		        </tr>
				<tr>
					<td><form:label path="password">Password:</form:label></td>
		          	<td><form:input type="password" path="password" size="30" maxlength="200"></form:input></td>
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
					<td><a href="<c:url value='/login' />" class="button buttonBlack">Tornar</a></td>
					<td><input type="submit" value="Registrar Usuari" class="button buttonBlack" /></td>					
				</tr>
			</table> 
		</form:form>
		<%@include file="footer.jsp" %>
	</body>
</html>