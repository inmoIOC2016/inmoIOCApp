<div>
	<img src="<c:url value="/resources/img/logo.jpg" />" height="184" width="212">	
	<span class="spanTitle">InmoIOC App</span>
</div>
<ul>  
  <li><a href="<c:url value='/inmobles' />">Immobles</a></li>
  <li><a href="<c:url value='/vendes' />">Vendes/Compres/Lloguers/Traspassos</a></li>
  <li><a href="<c:url value='/operacions' />">Operacions i Contactes amb Usuaris</a></li>
  <li><a href="<c:url value='/pagaments' />">Pagaments</a></li>
  <li><a href="<c:url value='/incidencies' />">Incidències</a></li>
  <li><a class="liSelected" href="#">Estadístiques</a></li>
  <li><a href="<c:url value='/categories' />">Categories</a></li>
  <li><a href="<c:url value='/usuaris' />">Usuaris</a></li>  
  <li>
  	<a onclick="return disconnect();" href="<c:url value='/logout' />">Desconectar usuari: <span id="userNameItem"></span></a>
  </li>  
</ul>