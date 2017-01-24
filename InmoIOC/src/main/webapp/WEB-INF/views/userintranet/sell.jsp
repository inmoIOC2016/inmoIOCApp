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
	
		<%@include file="../menuUserSell.jsp" %>		
		
		<c:if test="${!empty message}">
			<div class="messageKO">${message}</div>
		</c:if>
		<br>		
		<form:form method="post" modelAttribute="property" enctype="multipart/form-data"  action="/InmoIOC/addPropertyUser">
			<table id="noborder">
				<tr>
					<th colspan="2">Alta i Gestió d'Inmobles</th>
				</tr>
				<tr>
					<form:hidden path="id_property" />
		          	<td><form:label path="name">Nom:</form:label></td>
		          	<td><form:input path="name" size="30" maxlength="200"></form:input></td>
		        </tr>
		        <tr>
					<td><form:label path="image">Imatge:</form:label></td>					
		          	<td><img src="${property.image}" />	<form:input type="file" path="image"></form:input></td>
				</tr>		        
				<tr>
					<td><form:label path="address">Adreça:</form:label></td>
		          	<td><form:input path="address" size="30" maxlength="200"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="city">Ciutat:</form:label></td>
		          	<td>
			          	<form:select name="city" path="city.id_city">
			          	  <option value=""> - Seleccionar opció -</option>
						  <c:forEach items="${citiesList}" var="cit">
						    <option value="${cit.id_city}"
						    	<c:if test="${cit.id_city eq property.city.id_city}"> selected="selected" </c:if>>
						        ${cit.city}
						    </option>
						  </c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="category">Categoria:</form:label></td>
		          	<td>
			          	<form:select name="category" path="category.id_category">
			          	  <option value=""> - Seleccionar opció -</option>
						  <c:forEach items="${categoryList}" var="cat">
						    <option value="${cat.id_category}"
						    	<c:if test="${cat.id_category eq property.category.id_category}"> selected="selected" </c:if>>
						        ${cat.name}
						    </option>
						  </c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="sellType">Tipus venda:</form:label></td>
		          	<td>		          		
		          		<form:select name="sellType" path="sellType.id_type">
		          		  <option value=""> - Seleccionar opció -</option>
						  <c:forEach items="${sellTypeList}" var="sellt">
						    <option value="${sellt.id_type}"						    
						     	<c:if test="${sellt.id_type eq property.sellType.id_type}"> selected="selected" </c:if>>
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
					<td><form:label path="contact">Telèfon de contacte:</form:label></td>
		          	<td><form:input path="contact" size="30" maxlength="200"></form:input></td>
				</tr>
				<tr  style="display:none">
					<td><form:label path="available">Publicat*:</form:label></td>
		          	<td>
		          		<form:select name="avai" path="available">
		          		    <option value=""> - Seleccionar opció -</option>						
						    <option value="0" selected="selected" >
						        No
						    </option>
						</form:select>
					</td>		
				</tr>
				<tr  style="display:none">
					<td><form:label path="reg_selling">Crear registre de venda**:</form:label></td>
		          	<td>
		          		<form:select name="reg_selling" path="reg_selling" style="display:none">
						    <option value="0"selected="selected" >	
						        No
						    </option>				
						</form:select>
					</td>		
				</tr>
				<tr>
					<td><form:label path="user">Usuari:</form:label></td>
		          	<td>		          		
		          		<form:select name="user" path="user.id_user">
		          		  <option value=""> - Seleccionar opció -</option>
						  <c:forEach items="${userList}" var="us">
						    <option value="${us.id_user}"						    
						     	<c:if test="${us.id_user eq property.user.id_user}"> selected="selected" </c:if>>
						        Nom: ${us.name} - Username: ${us.username} - Rol: ${us.role.description}
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
			<span>* L'immoble no apareixerà publicat en "Vendes" ni serà visible a "Compres/Lloguers/Traspassos" per la resta d'usuaris fins que l'administrador de la web validi la informació. Rebrà un correu electrònic informat del resultat.</span> 
		</form:form>
		<hr>
		<h3>Llistat dels meus Inmobles</h3>
		<c:if test="${!empty propertyList}">
			<table class="tg">
			<tr>
				<th width="50">Id</th>
				<th width="100">Nom</th>
				<th width="100">Imatge</th>
				<th width="100">Adreça</th>
				<th width="100">Ciutat</th>
				<th width="50">Categoria</th>
				<th width="50">Tipus Venda</th>
				<th width="100">Preu</th>
				<th width="100">Contacte</th>
				<th width="100">Publicat</th>				
			</tr>
			<c:forEach items="${propertyList}" var="property">
				<tr>
					<td>${property.id_property}</td>
					<td><c:out value="${property.name}"/></td>
					<td>
					<img src="data:image/jpg;base64,<c:out value='${property.getbase64()}'/>" width="140px" height="120px" />				
					</td>
					<td><c:out value="${property.address}"/></td>
					<td><c:out value="${property.city.city}"/></td>
					<td>${property.category.name}</td>
					<td>${property.sellType.name}</td>
					<td>${property.base_price}</td>
					<td>${property.contact}</td>
					<td>
						<c:if test="${property.available eq 0}"> No </c:if>
						<c:if test="${property.available eq 1}"> Si </c:if>
					</td>					
				</tr>
			</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty propertyList}">
			<table class="tg"><tr><th>Sense Resultats</th></tr></table>
		</c:if>
		<%@include file="../footerapp.jsp" %>
	</body>
</html>