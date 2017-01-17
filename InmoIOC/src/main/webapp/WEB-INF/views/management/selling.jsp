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
				window.location.href = '/InmoIOC/vendes';
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
		<%@include file="../menuAdminSelling.jsp" %>
				
		<c:if test="${!empty message}">
			<div class="messageKO">${message}</div>
		</c:if>
		<br>		
		<form:form method="post" modelAttribute="selling" action="/InmoIOC/addSelling">
			<table id="noborder">
				<tr>
					<th colspan="2">Gestió de Vendes/Compres/Lloguers/Traspassos</th>
				</tr>				
		        <tr>
		        	<form:hidden path="id_selling" />
					<td><form:label path="id_user">Usuari:</form:label></td>
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
						<input type="submit" value="Desar" class="button buttonBlack" />
						<input type="reset" value="Buidar" class="button buttonBlack" />
					</td>
				</tr>
			</table> 
		</form:form>
		<hr>
		<h3>Llistat Vendes</h3>
		<table id="noborder">
			<tr>
				<th colspan="4">Cercador</th>
			</tr>
			<tr>	
				 <td>Id:</td>
		         <td><input type="text" name="fid" id="fid"/></td>				
		         <td>Inmoble:</td>
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
		<c:if test="${!empty sellingList}">
			<table class="tg">
			<tr>
				<th width="50">Id</th>
				<th width="100">Usuari</th>
				<th width="100">Inmoble</th>
				<th width="50">Preu</th>
				<th width="50">Tipus Venda</th>
				<th width="100">Data Inici</th>
				<th width="100">Data Fi</th>		
				<th width="100">Accions</th>
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
					<td>
						<a class="button buttonBlack buttonTableCell" href="<c:url value='/updateSelling/${selling.id_selling}' />" >Modificar</a>
						<a class="button buttonBlack buttonTableCell" onclick="return confirmDelete();" href="<c:url value='/deleteSelling/${selling.id_selling}' />" >Eliminar</a>
					</td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
		
		<%@include file="../footerapp.jsp" %>
	</body>
</html>