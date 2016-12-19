<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	</head>
	<body>
		<c:if test="${!empty message}">
			<table>
				<tr><th class="message">${message}</th></tr>
			</table>
		</c:if>
		<br>
		<form:form method="post" modelAttribute="user" action="/InmoIOC/getUser">
			<table>
				<tr>
					<th colspan="2">Login InmoIOC</th>
				</tr>
				<tr>
					<form:hidden path="id_user" />
		          	<td><form:label path="username">Usuari:</form:label></td>
		          	<td><form:input path="username" size="30" maxlength="30"></form:input></td>
		        </tr>
				<tr>
					<td><form:label path="password">Password:</form:label></td>
		          	<td><form:input path="password" size="30" maxlength="30"></form:input></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Accedir"/></td>
				</tr>
			</table> 
		</form:form>
	</body>
</html>

