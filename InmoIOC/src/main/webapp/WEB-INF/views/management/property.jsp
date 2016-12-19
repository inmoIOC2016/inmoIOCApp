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
		<h2>INMOBLES</h2>
		
		<c:if test="${!empty message}">
			<table>
				<tr><th class="message">${message}</th></tr>
			</table>
		</c:if>
		<br>		
		<form:form method="post" modelAttribute="property" action="/InmoIOC/addProperty">
			<table>
				<tr>
					<th colspan="2">Inmoble</th>
				</tr>
				<tr>
					<form:hidden path="id_property" />
		          	<td><form:label path="name">Nom:</form:label></td>
		          	<td><form:input path="name" size="30" maxlength="200"></form:input></td>
		        </tr>
				<tr>
					<td><form:label path="address">Adreça:</form:label></td>
		          	<td><form:input path="address" size="30" maxlength="200"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="id_category">Categoria:</form:label></td>
		          	<td>
			          	<form:select name="category" path="id_category">
						  <c:forEach items="${categoryList}" var="cat">
						    <option value="${cat.id_category}"
						    	<c:if test="${cat.id_category eq property.id_category}"> selected="selected" </c:if>>
						        ${cat.name}
						    </option>
						  </c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="sell_type">Tipus venda:</form:label></td>
		          	<td>		          		
		          		<form:select name="selltype" path="sell_type">
						  <c:forEach items="${sellTypeList}" var="sellt">
						    <option value="${sellt.id_type}"						    
						     	<c:if test="${sellt.id_type eq property.sell_type}"> selected="selected" </c:if>>
						        ${sellt.name}
						    </option>
						  </c:forEach>
						</form:select>		          		
		          	</td>
				</tr>
				<tr>
					<td><form:label path="base_price">Preu:</form:label></td>
		          	<td><form:input path="base_price" size="30" maxlength="200"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="contact">Contacte:</form:label></td>
		          	<td><form:input path="contact" size="30" maxlength="200"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="available">Available:</form:label></td>
		          	<td>
		          		<form:select name="avai" path="available">						
						    <option value="0"						    
						     	<c:if test="${0 eq property.available}"> selected="selected" </c:if>>
						        0
						    </option>
						    <option value="1"						    
						     	<c:if test="${1 eq property.available}"> selected="selected" </c:if>>
						        1
						    </option>						 
						</form:select>
					</td>		
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
		<h3>Llistat Inmobles</h3>
		<c:if test="${!empty propertyList}">
			<table class="tg">
			<tr>
				<th width="50">Id</th>
				<th width="100">Name</th>
				<th width="100">address</th>
				<th width="50">id_category</th>
				<th width="50">sell_type</th>
				<th width="100">base_price</th>
				<th width="100">contact</th>
				<th width="100">available</th>				
				<th width="50">Modificar</th>
				<th width="50">Eliminar</th>
			</tr>
			<c:forEach items="${propertyList}" var="property">
				<tr>
					<td>${property.id_property}</td>
					<td><c:out value="${property.name}"/></td>
					<td><c:out value="${property.address}"/></td>
					<td>${property.id_category}</td>
					<td>${property.sell_type}</td>
					<td>${property.base_price}</td>
					<td>${property.contact}</td>
					<td>${property.available}</td>					
					<td><a href="<c:url value='/updateProperty/${property.id_property}' />" >Modificar</a></td>
					<td><a href="<c:url value='/deleteProperty/${property.id_property}' />" >Eliminar</a></td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
	</body>
</html>