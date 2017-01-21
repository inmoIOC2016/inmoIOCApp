<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	</head>
	<body>
		<%@include file="header.jsp" %>
		<c:if test="${!empty message}">			
			<div class="messageKO">${message}</div>
		</c:if>
		<br>
		<form:form method="post" modelAttribute="user" action="/InmoIOC/getUser">			
			<table id="noborder">
				<tr>
					<th colspan="2">Login</th>
				</tr>
				<tr>
					<form:hidden path="id_user" />
		          	<td><form:label path="username">Usuari:</form:label></td>
		          	<td><form:input path="username" size="30" maxlength="30"></form:input></td>
		        </tr>
				<tr>
					<td><form:label path="password">Password:</form:label></td>
		          	<td><form:input type="password" path="password" size="30" maxlength="30"></form:input></td>
				</tr>
				<tr>						
					<td><a href="<c:url value='/registration' />" class="button buttonBlack" >Registre d'usuari</a></td>
					<td><input type="submit" value="Accedir" class="button buttonBlack"/></td>
				</tr>
			</table> 
		</form:form>		
		<%@include file="footer.jsp" %>
	</body>
</html>