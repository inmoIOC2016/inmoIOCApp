<div>
	<img src="<c:url value="/resources/img/logo.jpg" />" height="184" width="212">	
	<span class="spanTitle">InmoIOC App</span>
</div>
<ul>  
  <li><a class="liSelected" href="#">Consultar Operaciones</a></li>
  <li><a href="<c:url value='/vendes' />">Consultar/Sol·licitar Venda</a></li>
  <li><a href="<c:url value='/compres' />">Consultar/Sol·licitar Compra</a></li>
  <li><a href="<c:url value='/lloguers' />">Consultar/Sol·licitar Lloguer</a></li>
  <li><a href="<c:url value='/traspas' />">Consultar/Sol·licitar Traspàs</a></li>
  <li><a href="<c:url value='/traspas' />">Dades Usuari</a></li>
  <li>
  	<a onclick="return disconnect();" href="<c:url value='/logout' />">Desconectar usuari: <span id="userNameItem"></span></a>
  </li> 
</ul>