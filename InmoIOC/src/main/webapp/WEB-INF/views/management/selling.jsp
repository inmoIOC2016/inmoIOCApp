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
		<h2>VENDES</h2>
		
		<c:if test="${!empty message}">
			<table>
				<tr><th class="message">${message}</th></tr>
			</table>
		</c:if>
		<br>		
		<form:form method="post" modelAttribute="selling" action="/InmoIOC/addSelling">
			<table>
				<tr>
					<th colspan="2">Venda</th>
				</tr>				
		        <tr>
		        	<form:hidden path="id_selling" />
					<td><form:label path="id_user">User:</form:label></td>
		          	<td>
			          	<form:select name="id_user" path="id_user">
						  <c:forEach items="${userList}" var="ulist">
						    <option value="${ulist.id_user}"
						    	<c:if test="${ulist.id_user eq selling.id_user}"> selected="selected" </c:if>>
						        ${ulist.username}
						    </option>
						  </c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="id_property">Inmoble:</form:label></td>
		          	<td>
			          	<form:select name="id_property" path="id_property">
						  <c:forEach items="${propertyList}" var="plist">
						    <option value="${plist.id_property}"
						    	<c:if test="${plist.id_property eq selling.id_property}"> selected="selected" </c:if>>
						        ${plist.name}
						    </option>
						  </c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="expected_price">Preu:</form:label></td>
		          	<td><form:input path="expected_price" size="30" maxlength="200"></form:input></td>
				</tr>				
				<tr>
					<td><form:label path="sell_type">Tipus venda:</form:label></td>
		          	<td>		          		
		          		<form:select name="selltype" path="sell_type">
						  <c:forEach items="${sellTypeList}" var="slist">
						    <option value="${slist.id_type}"						    
						     	<c:if test="${slist.id_type eq selling.sell_type}"> selected="selected" </c:if>>
						        ${slist.name}
						    </option>
						  </c:forEach>
						</form:select>		          		
		          	</td>
				</tr>
				<tr>
					<td><form:label path="date_start">Data inici:</form:label></td>
		          	<td><form:input path="date_start" size="30" maxlength="200"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="date_end">Data fi:</form:label></td>
		          	<td><form:input path="date_end" size="30" maxlength="200"></form:input></td>
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
		<h3>Llistat Vendes</h3>
		<c:if test="${!empty sellingList}">
			<table class="tg">
			<tr>
				<th width="50">Id</th>
				<th width="100">Id user</th>
				<th width="100">Id property</th>
				<th width="50">price</th>
				<th width="50">sell_type</th>
				<th width="100">date_start</th>
				<th width="100">date_end</th>		
				<th width="50">Modificar</th>
				<th width="50">Eliminar</th>
			</tr>
			<c:forEach items="${sellingList}" var="selling">
				<tr>
					<td>${selling.id_selling}</td>
					<td>${selling.id_user}</td>
					<td>${selling.id_property}</td>
					<td>${selling.expected_price}</td>
					<td>${selling.sell_type}</td>
					<td>${selling.date_start}</td>
					<td>${selling.date_end}</td>						
					<td><a href="<c:url value='/updateSelling/${selling.id_selling}' />" >Modificar</a></td>
					<td><a href="<c:url value='/deleteSelling/${selling.id_selling}' />" >Eliminar</a></td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
	</body>
</html>