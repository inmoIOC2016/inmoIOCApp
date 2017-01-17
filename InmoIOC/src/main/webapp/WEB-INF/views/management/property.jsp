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
		<form:form method="post" modelAttribute="property" action="/InmoIOC/addProperty">
			<table id="noborder">
				<tr>
					<th colspan="2">Gestió d'Inmobles</th>
				</tr>
				<tr>
					<form:hidden path="id_property" />
					<c:if test="${empty property.username}">
						<form:hidden path="username" value="${userName}" />
					</c:if>
					<c:if test="${!empty property.username}">
						<form:hidden path="username" />
					</c:if>					
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
					<td><form:label path="available">Disponible:</form:label></td>
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
		         <td><input type="text" name="fid" id="fid"/></td>				
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
				<th width="100">Adreça</th>
				<th width="50">Categoria</th>
				<th width="50">Tipus Venda</th>
				<th width="100">Preu</th>
				<th width="100">Contacte</th>
				<th width="100">Disponible</th>
				<th width="100">Comprador/Venedor</th>
				<th width="100">Accions</th>				
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
					<td>${property.username}</td>					
					<td>
						<a class="button buttonBlack buttonTableCell" href="<c:url value='/updateProperty/${property.id_property}' />" >Modificar</a>
						<a class="button buttonBlack buttonTableCell" onclick="return confirmDelete();" href="<c:url value='/deleteProperty/${property.id_property}' />" >Eliminar</a>
					</td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
		
		<%@include file="../footerapp.jsp" %>
	</body>
</html>