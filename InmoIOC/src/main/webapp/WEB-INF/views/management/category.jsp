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
				window.location.href = '/InmoIOC/categories';
			}
			
			function filter(){
				var fid = document.getElementById("fid").value;
				var fname = document.getElementById("fname").value;				
				if(fid == '' && fname == ''){
					filterAll();
				} else {
					if(fid != '' && fname != ''){						
						window.location.href = '/InmoIOC/findCategory/' + fid + '/' + fname;
					} else {
						if(fid != ''){
							window.location.href = '/InmoIOC/findCategoryById/' + fid;
						} 						
						if(fname != ''){
							window.location.href = '/InmoIOC/findCategoryByName/' + fname;
						}						
					}
				}
			}
		</script>
	</head>	
	<body onload="loadUserData();">
		<%@include file="../menuAdminCategory.jsp" %>				
		
		<c:if test="${!empty message}">
			<div class="messageKO">${message}</div>
		</c:if>
		<br>		
		<form:form method="post" modelAttribute="category" action="/InmoIOC/addCategory">
			<table id="noborder">
				<tr>
					<th colspan="2">Gestió de Categories</th>
				</tr>
				<tr>
					<form:hidden path="id_category" />
		          	<td><form:label path="name">Nom:</form:label></td>
		          	<td><form:input path="name" size="30" maxlength="200"></form:input></td>
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
		<h3>Llistat Categories</h3>		
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
		<c:if test="${!empty categoryList}">
			<table class="tg">
				<tr>
					<th width="50">Id</th>
					<th width="200">Nom</th>							
					<th width="100">Accions</th>
				</tr>
				<c:forEach items="${categoryList}" var="category">
					<tr>
						<td>${category.id_category}</td>
						<td><c:out value="${category.name}"/></td>
						<td>
							<a class="button buttonBlack buttonTableCell" href="<c:url value='/updateCategory/${category.id_category}' />" >Modificar</a>
							<a class="button buttonBlack buttonTableCell" onclick="return confirmDelete();" href="<c:url value='/deleteCategory/${category.id_category}' />" >Eliminar</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<%@include file="../footerapp.jsp" %>
	</body>
</html>