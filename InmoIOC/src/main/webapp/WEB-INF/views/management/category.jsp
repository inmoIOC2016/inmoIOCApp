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
		<h2>CATEGORIES</h2>
		
		<c:if test="${!empty message}">
			<table>
				<tr><th class="message">${message}</th></tr>
			</table>
		</c:if>
		<br>		
		<form:form method="post" modelAttribute="category" action="/InmoIOC/addCategory">
			<table>
				<tr>
					<th colspan="2">Categories</th>
				</tr>
				<tr>
					<form:hidden path="id_category" />
		          	<td><form:label path="name">Nom:</form:label></td>
		          	<td><form:input path="name" size="30" maxlength="200"></form:input></td>
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
		<h3>Llistat Categories</h3>
		<c:if test="${!empty categoryList}">
			<table class="tg">
			<tr>
				<th width="50">Id</th>
				<th width="200">Name</th>							
				<th width="50">Modificar</th>
				<th width="50">Eliminar</th>
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.id_category}</td>
					<td><c:out value="${category.name}"/></td>					
					<td><a href="<c:url value='/updateCategory/${category.id_category}' />" >Modificar</a></td>
					<td><a href="<c:url value='/deleteCategory/${category.id_category}' />" >Eliminar</a></td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
	</body>
</html>