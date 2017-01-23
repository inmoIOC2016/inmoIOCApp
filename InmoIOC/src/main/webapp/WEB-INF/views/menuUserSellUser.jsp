<div>
	<img src="<c:url value="/resources/img/logoalternativo.png" />">	
	<span class="spanTitle"></span>
</div>
<ul>
  <li><a href="<c:url value='/principal' />">Pàgina Principal</a></li>
  <li><a href="<c:url value='/findSellingByUsernameP/' />${userName}">Vull Comprar/Llogar/Traspassar</a></li>
  <li><a href="<c:url value='/findPropertyByUsername/' />${userName}">Alta dels meus Inmobles</a></li>
  <li><a class="liSelected" href="#">Vendes</a></li>
  <li><a href="<c:url value='/findIncidenceByUsername/' />${userName}">Incidències</a></li>
  <li>
  	<a onclick="return disconnect();" href="<c:url value='/logout' />">Desconectar usuari: <span id="userNameItem"></span></a>
  </li> 
</ul>