<div>
	<img src="<c:url value="/resources/img/logoalternativo.png" />">	
	<span class="spanTitle"></span>
</div>
<ul>
  <li><a href="<c:url value='/findSellingByUsernameP/' />${userName}">Vull Comprar/Llogar/Traspassar</a></li>
  <li><a href="<c:url value='/findPropertyByUsername/' />${userName}">Alta dels meus Inmobles</a></li>
  <li><a href="<c:url value='/findSellingByUsernameS/' />${userName}">Vendes</a></li>
  <li><a class="liSelected" href="#">Incid�ncies</a></li>
  <li>
  	<a href="<c:url value='/logout' />">Desconectar usuari: <span style='color:white;'>${userName}</span></a>
  </li>
</ul>