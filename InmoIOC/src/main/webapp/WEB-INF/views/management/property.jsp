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
				window.location.href = '/InmoIOC/inmobles';
			}
			
			function filter(){
				var fid = document.getElementById("fid").value;
				var fname = document.getElementById("fname").value;				
				if(fid == '' && fname == ''){
					filterAll();
				} else {
					if(fid != '' && fname != ''){						
						window.location.href = '/InmoIOC/findProperty/' + fid + '/' + fname;
					} else {
						if(fid != ''){
							window.location.href = '/InmoIOC/findPropertyById/' + fid;
						} 						
						if(fname != ''){
							window.location.href = '/InmoIOC/findPropertyByName/' + fname;
						}						
					}
				}
			}
		</script>				
	</head>	
	<body onload="loadUserData();">
	
		<%@include file="../menuAdminProperty.jsp" %>		
		
		<c:if test="${!empty message}">
			<div class="messageKO">${message}</div>
		</c:if>
		<br>		
		<form:form method="post" modelAttribute="property" enctype="multipart/form-data" action="/InmoIOC/addProperty">
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
				<tr>
					<td><form:label path="available">Publicat*:</form:label></td>
		          	<td>
		          		<form:select name="avai" path="available">
		          		    <option value=""> - Seleccionar opció -</option>						
						    <option value="0"						    
						     	<c:if test="${0 eq property.available}"> selected="selected" </c:if>>
						        No
						    </option>
						    <option value="1"						    
						     	<c:if test="${1 eq property.available}"> selected="selected" </c:if>>
						        Si
						    </option>
						    <option value="2"						    
						     	<c:if test="${2 eq property.available}"> selected="selected" </c:if>>
						        Pendent de validar
						    </option>
						</form:select>
					</td>		
				</tr>
				<tr>
					<td><form:label path="reg_selling">Crear registre de venda**:</form:label></td>
		          	<td>
		          		<form:select name="reg_selling" path="reg_selling">
						    <option value="0"						    
						     	<c:if test="${0 eq property.available}"> selected="selected" </c:if>>
						        No
						    </option>
						    <option value="1"						    
						     	<c:if test="${1 eq property.available}"> selected="selected" </c:if>>
						        Si
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
				<tr><td colspan="2"><span>* Publicat Si: Validat per l'administrador. Sortirà al llistat d'immobles que es poden vendre/llogar/traspassar</span></td></tr>
				<tr><td colspan="2"><span>** Registre de venda Si: Quan publicat sigui Si aquesta opció crearà un registre de venda amb 
				les dades per defecte configurades a l'immoble. Es visualitzarà el registre al llistat de l'opció de menú Vendes/Compres/Lloguers/Traspassos.
				(S'aplicarà un (10%) sobre el preu de venda de l'immoble com a percentatge de benefici d'inmoioc)</span></td></tr>				
				<tr>
					<td colspan="2">
						<input type="submit" value="Desar" class="button buttonBlack" />
						<input type="reset" value="Buidar" class="button buttonBlack" />
					</td>
				</tr>
			</table> 
		</form:form>
		<hr>
		<h3>Llistat Inmobles</h3>
		<table id="noborder">
			<tr>
				<th colspan="4">Cercador</th>
			</tr>
			<tr>	
				 <td>Id:</td>
		         <td><input type="number" name="fid" id="fid"/></td>				
		         <td>Nom:</td>
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
		<c:if test="${!empty propertyList}">
			<table class="tg">
			<tr>
				<th width="50">Id</th>
				<th width="100">Nom</th>
				<th width="100">Image</th>
				<th width="100">Adreça</th>
				<th width="100">Ciutat</th>
				<th width="50">Categoria</th>
				<th width="50">Tipus Venda</th>
				<th width="100">Preu</th>
				<th width="100">Contacte</th>
				<th width="100">Publicat</th>
				<th width="100">Comprador/Venedor</th>
				<th width="100">Accions</th>				
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
						<c:if test="${property.available eq 2}"> Pendent de validar </c:if>
					</td>
					<td>Nom: ${property.user.name} - Username: ${property.user.username} - Rol: ${property.user.role.description}</td>					
					<td>
						<a class="button buttonBlack buttonTableCell" href="<c:url value='/updateProperty/${property.id_property}' />" >Modificar</a>
						<a class="button buttonBlack buttonTableCell" onclick="return confirmDelete();" href="<c:url value='/deleteProperty/${property.id_property}' />" >Eliminar</a>
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